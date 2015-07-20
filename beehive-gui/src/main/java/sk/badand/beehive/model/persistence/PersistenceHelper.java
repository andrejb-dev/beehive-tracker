/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.badand.beehive.model.persistence;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Persistence helper class that provides EntityManager basic operations per-thread
 * @author abadinka <andrej.badinka@interway.sk>
 */
public abstract class PersistenceHelper {
    
    /**
     * <p>
     * Declare the persistence unit for this PersistenceHelper ("entity").
     * </p>
     * <p>
     * This is the only setting that might need to be changed between
     * applications. Otherwise, this class can be dropped into any JPA
     * application.
     * </p>
     */
    private static final String PERSISTENCE_UNIT_NAME = "ftmPU";
    private static final String CONNECTION_STRING = "jdbc:derby:testDB;create=true";

    private static final EntityManagerFactory factory;
    private static final ThreadLocal<EntityManager> threadLocal;
    private static final Logger logger;
    
    public static JdbcConnectionSource connectionSource;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        threadLocal = new ThreadLocal<>();
//        logger = LogFactory.getLog(PersistenceHelper.class);
        logger = Logger.getLogger(PersistenceHelper.class.getSimpleName());
        
        try {
            connectionSource = new JdbcConnectionSource(CONNECTION_STRING);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Provide a per-thread EntityManager "singleton" instance.
     * </p>
     * <p>
     * This method can be called as many times as needed per thread, and it will
     * return the same EntityManager instance, until the manager is closed.
     * </p>
     * 
     * @return EntityManager singleton for this thread
     */
    public static EntityManager getEntityManager() {
        EntityManager manager = threadLocal.get();
        if (manager == null || !manager.isOpen()) {
            manager = factory.createEntityManager();
            threadLocal.set(manager);
        }
        return manager;
    }

    /**
     * <p>
     * Close the EntityManager and set the thread's instance to null.
     * </p>
     */
    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        if (em != null)
            em.close();
    }

    /**
     * <p>
     * Initiate a transaction for the EntityManager on this thread.
     * </p>
     * <p>
     * The Transaction will remain open until commit or closeEntityManager is
     * called.
     * </p>
     */
    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    /**
     * <p>
     * Submit the changes to the persistance layer.
     * </p>
     * <p>
     * Until commit is called, rollback can be used to undo the transaction.
     * </p>
     */
    public static void commit() {
        getEntityManager().getTransaction().commit();
    }

    /**
     * <p>
     * Create a query for the EntityManager on this thread.
     * </p>
     * @param query
     * @return 
     */
    public static Query createQuery(String query) {
        return getEntityManager().createQuery(query);
    }

    /**
     * <p>
     * Flush the EntityManager state on this thread.
     * </p>
     */
    public static void flush() {
        getEntityManager().flush();
    }

    /**
     * <p>
     * Write an error message to the logging system.
     * </p>
     */
    public static void logError(String info, Throwable ex) {
        logger.log(Level.SEVERE, info, ex);
    }

    /**
     * <p>
     * Undo an uncommitted transaction, in the event of an error or other
     * problem.
     * </p>
     */
    public static void rollback() {
        getEntityManager().getTransaction().rollback();
    }

}
