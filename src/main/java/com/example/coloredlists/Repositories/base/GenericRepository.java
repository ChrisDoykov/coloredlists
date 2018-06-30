package com.example.coloredlists.Repositories.base;

import com.example.coloredlists.models.base.ModelEntity;


import java.util.List;

public interface GenericRepository<T extends ModelEntity> {
    List<T> getAll();

    T getById(int id);

    T create(T entity);
}
