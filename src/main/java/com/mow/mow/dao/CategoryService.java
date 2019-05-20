package com.mow.mow.dao;

import com.mow.mow.entities.Category;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class CategoryService {

    private static CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    public void persist(Category entity) {
        categoryDao.connection.openCurrentSessionwithTransaction();
        categoryDao.persist(entity);
        categoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public void update(Category entity) {
        categoryDao.connection.openCurrentSessionwithTransaction();
        categoryDao.update(entity);
        categoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public Category findById(String id) {
        categoryDao.connection.openCurrentSession();
        Category category = categoryDao.findById(id);
        categoryDao.connection.closeCurrentSession();
        return category;
    }

    public void delete(String id) {
        categoryDao.connection.openCurrentSessionwithTransaction();
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        categoryDao.connection.closeCurrentSessionwithTransaction();
    }

    @Cacheable("category")
    public List<Category> findAll() {
        categoryDao.connection.openCurrentSession();
        List<Category> category = categoryDao.findAll();
        categoryDao.connection.closeCurrentSession();
        return category;
    }

    public void deleteAll() {
        categoryDao.connection.openCurrentSessionwithTransaction();
        categoryDao.deleteAll();
        categoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public CategoryDao categoryDao() {
        return categoryDao;
    }

}
