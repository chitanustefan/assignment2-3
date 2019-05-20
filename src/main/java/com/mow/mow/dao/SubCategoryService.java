package com.mow.mow.dao;

import com.mow.mow.entities.SubCategory;

import java.util.List;

public class SubCategoryService {

    private static SubCategoryDao subCategoryDao;

    public SubCategoryService() {
        subCategoryDao = new SubCategoryDao();
    }

    public void persist(SubCategory entity) {
        subCategoryDao.connection.openCurrentSessionwithTransaction();
        subCategoryDao.persist(entity);
        subCategoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public void update(SubCategory entity) {
        subCategoryDao.connection.openCurrentSessionwithTransaction();
        subCategoryDao.update(entity);
        subCategoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public SubCategory findById(String id) {
        subCategoryDao.connection.openCurrentSession();
        SubCategory category = subCategoryDao.findById(id);
        subCategoryDao.connection.closeCurrentSession();
        return category;
    }

    public void delete(String id) {
        subCategoryDao.connection.openCurrentSessionwithTransaction();
        SubCategory category = subCategoryDao.findById(id);
        subCategoryDao.delete(category);
        subCategoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public List<SubCategory> findAll() {
        subCategoryDao.connection.openCurrentSession();
        List<SubCategory> category = subCategoryDao.findAll();
        subCategoryDao.connection.closeCurrentSession();
        return category;
    }

    public void deleteAll() {
        subCategoryDao.connection.openCurrentSessionwithTransaction();
        subCategoryDao.deleteAll();
        subCategoryDao.connection.closeCurrentSessionwithTransaction();
    }

    public SubCategoryDao subcategoryDao() {
        return subCategoryDao;
    }

}
