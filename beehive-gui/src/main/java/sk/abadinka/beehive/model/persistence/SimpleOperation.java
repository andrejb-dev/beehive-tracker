/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.abadinka.beehive.model.persistence;

import javax.persistence.EntityManager;

/**
 * Serves as anonymous class for executing data operations using EntityManager
 * @author abadinka <andrej.badinka@interway.sk>
 * @param <T> return type of data operation
 */
public interface SimpleOperation<T> {
    public T execute(EntityManager entityManager);
}
