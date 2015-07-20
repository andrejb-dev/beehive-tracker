/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.abadinka.beehive.model.persistence;

import javax.persistence.EntityManager;

/**
 * Class provides two basic ways to execute operation:
 *  - trasaction operation, that executes inside transaction and ends with commit or rollback (in exception case)
 *  - non-transaction operation, used for read onlu operations, where no transaction is needed
 * It uses the generic SimpleOperation interface with an 'execute' operation.
 * Typicaly this class can be extended in specific data providing services, where thay can implement execute operation
 * using daos, criterias or writing custom query. EntityManager will be present in the execute method.
 * For example:
 * 
 * public FooBarCollectionWrapped findFoosAndBars() {
 *       
 *      Collection<FooEntity> foos = this.executeNonTransactionOperation(new SimpleOperation<Collection<FooEntity>>() {
 *          
 *          @Override
 *          public Collection<FooEntity> execute(EntityManager entityManager) {
 *              return fooDao.getFooFromNamedQ(entityManager, "fooQuery");
 *          }
 *      });
 *       
 *      BarEntity bar = this.executeTransactionOperation(new SimpleOperation<Collection<BarEntity>>() {
 *          
 *          @Override
 *          public BarEntity execute(EntityManager entityManager) {
 *              return entityManager.remove(foos[0].toBar());
 *          }
 *      });
 *      
 *      return convertToFooBarCollectionWrapped(foos,bar);
 *  }
 * 
 * @author abadinka <andrej.badinka@interway.sk>
 */
public abstract class AbstractDataOperationExecutor {

    /**
     * Enables the derived classes to execute read only operation using the entityManager
     * @param <T>
     * @param operation
     * @return
     */
    protected <T> T executeNonTransactionOperation(SimpleOperation<T> operation) {
        try {
            EntityManager entityManager = PersistenceHelper.getEntityManager();

            T result = operation.execute(entityManager);

            return result;
        } catch (Exception e) {
            //TODO: throw our custom exception?
            throw e;
        } finally {
            PersistenceHelper.closeEntityManager();
        }
    }

    /**
     * Enables the derived classes to execute operation (inside transaction) using the entityManager
     * @param <T>
     * @param operation
     * @return
     */
    protected <T> T executeTransactionOperation(SimpleOperation<T> operation) {
        try {
            EntityManager entityManager = PersistenceHelper.getEntityManager();
            
            PersistenceHelper.beginTransaction();
            T result = operation.execute(entityManager);
            PersistenceHelper.commit();

            return result;
        } catch (Exception e) {
            PersistenceHelper.rollback();
            //TODO: throw our custom exception?
            throw e;
        } finally {
            PersistenceHelper.closeEntityManager();
        }
    }
}
