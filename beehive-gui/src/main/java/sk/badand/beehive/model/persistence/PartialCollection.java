/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sk.badand.beehive.model.persistence;

import java.util.Collection;


public class PartialCollection<T> {
    
    private final long totalCount;
    private final Collection<T> content;

    public PartialCollection(long totalCount, Collection<T> content) {
        this.totalCount = totalCount;
        this.content = content;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public Collection<T> getContent() {
        return content;
    }
}
