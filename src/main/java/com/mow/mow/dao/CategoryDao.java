package com.mow.mow.dao;

import com.mow.mow.connection.HibernateCon;
import com.mow.mow.entities.Category;

import java.util.List;

public class CategoryDao implements CategoryDaoInterface<Category, String> {

    HibernateCon connection = new HibernateCon();

    public void persist(Category entity) {
        connection.getCurrentSession().saveOrUpdate(entity);
    }

    public void update(Category entity) {
        connection.getCurrentSession().update(entity);
    }

    public Category findById(String id) {
        Category category = (Category) connection.getCurrentSession().get(Category.class, id);
        return category;
    }

    public void delete(Category entity) {
        connection.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        List<Category> category = (List<Category>) connection.getCurrentSession().createQuery("from Category").list();
        return category;
    }

    public void deleteAll() {
        List<Category> entityList = findAll();
        for (Category entity : entityList) {
            delete(entity);
        }
    }
}