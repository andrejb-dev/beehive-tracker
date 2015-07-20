package sk.badand.beehive.model.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Implements base crud operations on database Any concrete dao can extend this class and provide more specific operations.
 *
 * @author abadinka <andrej.badinka@interway.sk>
 * @param <T> Entity type on whitch dao operates
 * @param <V> Entity's id class. For simple id can be set to Integer, or any serializable class representating primitive data types
 */
public abstract class AbstractGenericDao<T, V extends Serializable> {

    private static final Logger LOG = Logger.getLogger(AbstractGenericDao.class.getName());

    public T createEntity(EntityManager entityManager, T value) throws PersistenceException {
        entityManager.persist(value);
        return value;
    }

    public T readEntity(EntityManager entityManager, V primaryKey) {
        Class<T> genericClass = null;
        return entityManager.find(genericClass, primaryKey);
    }

    public T updateEntity(EntityManager entityManager, T value) throws PersistenceException {

        return entityManager.merge(value);
    }

    public T deleteEntity(EntityManager entityManager, T value) throws PersistenceException {
        T mergeResult = entityManager.merge(value);
        entityManager.remove(mergeResult);
        return mergeResult;
    }

    public T singleResult(EntityManager entityManager, String namedQuery, Map<String, String> queryParams) {
        T result;
        Query query = entityManager.createNamedQuery(namedQuery);

        if (queryParams != null && !queryParams.isEmpty()) {
            for (String paramName : queryParams.keySet()) {
                query.setParameter(paramName, queryParams.get(paramName));
            }
        }

        try {
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }

    //TODO: should we offer collection without paging?
    public Collection<T> resultList(EntityManager entityManager, String namedQuery) {
        return resultList(entityManager, namedQuery, null);
    }

    public Collection<T> resultList(EntityManager entityManager, String namedQuery, Map<String, String> queryParams) {
        Collection<T> result;
        Query query = entityManager.createNamedQuery(namedQuery);

        if (queryParams != null && !queryParams.isEmpty()) {
            for (String paramName : queryParams.keySet()) {
                query.setParameter(paramName, queryParams.get(paramName));
            }
        }

        result = query.getResultList();
        return result;
    }

    public PartialCollection<T> rangedResultList(EntityManager entityManager, String namedQuery, Map<String, String> queryParams, int firstResult, int maxResults) {
        Collection<T> result;
        long count;

        Query query = entityManager.createNamedQuery(namedQuery);
        //Query countQuery = QueryCreator.createCountQuery(entityManager, query);

        if (queryParams != null && !queryParams.isEmpty()) {
            for (String paramName : queryParams.keySet()) {
                query.setParameter(paramName, queryParams.get(paramName));
                //countQuery.setParameter(paramName, queryParams.get(paramName));
            }
        }

        setQueryRanges(query, firstResult, maxResults);

        result = query.getResultList();
        //count = ((Number) countQuery.getSingleResult()).longValue();
        return new PartialCollection<>(-1, result);
    }

    public PartialCollection<T> rangedResultList(EntityManager entityManager, String namedQuery, int firstResult, int maxResults) {
        return rangedResultList(entityManager, namedQuery, null, firstResult, maxResults);
    }

    /**
     * Sets first and max results to query
     *
     * @param query
     * @param firstResult - number of first record in query result
     * @param maxResults - has to be greater than zero to take effect, otherwise neither maxResults nor firstResult are set
     * @return returns true, if ranges had been set
     */
    protected boolean setQueryRanges(Query query, int firstResult, int maxResults) {
        if (maxResults > 0) {
            query.setMaxResults(maxResults);
            if (firstResult >= 0) {
                query.setFirstResult(firstResult);
            }
            return true;
        }
        
        return false;
    }
}
