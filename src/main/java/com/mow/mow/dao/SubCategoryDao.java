package com.mow.mow.dao;

import com.mow.mow.connection.HibernateCon;
import com.mow.mow.entities.SubCategory;

import java.util.List;

public class SubCategoryDao implements SubCateoryDaoInterface<SubCategory, String> {


    HibernateCon connection = new HibernateCon();

    public void persist(SubCategory entity) {
        connection.getCurrentSession().save(entity);
    }

    public void update(SubCategory entity) {
        connection.getCurrentSession().update(entity);
    }

    public SubCategory findById(String id) {
        SubCategory sub = (SubCategory) connection.getCurrentSession().get(SubCategory.class, id);
        return sub;
    }

    public void delete(SubCategory entity) {
        connection.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<SubCategory> findAll() {
        List<SubCategory> subs = (List<SubCategory>) connection.getCurrentSession().createQuery("from SubCategory").list();
        return subs;
    }

    public void deleteAll() {
        List<SubCategory> entityList = findAll();
        for (SubCategory entity : entityList) {
            delete(entity);
        }
    }
}