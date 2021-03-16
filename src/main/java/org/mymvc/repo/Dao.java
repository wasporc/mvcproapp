package org.mymvc.repo;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    T getById(Long id);
}
