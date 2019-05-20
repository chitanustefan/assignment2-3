package com.mow.mow.dao;

import com.mow.mow.connection.HibernateCon;
import com.mow.mow.entities.Persoana;

import java.util.List;

public class PersoanDao implements PersoanDaoInterface<Persoana, String>  {


    HibernateCon connection = new HibernateCon();

    public void persist(Persoana entity) {
        connection.getCurrentSession().save(entity);
    }

    public void update(Persoana entity) {
        connection.getCurrentSession().update(entity);
    }

    public Persoana findById(String id) {
        Persoana user = (Persoana) connection.getCurrentSession().get(Persoana.class, id);
        return user;
    }

    public void delete(Persoana entity) {
        connection.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Persoana> findAll() {
        List<Persoana> users = (List<Persoana>) connection.getCurrentSession().createQuery("from Persoana").list();
        return users;
    }

    public void deleteAll() {
        List<Persoana> entityList = findAll();
        for (Persoana entity : entityList) {
            delete(entity);
        }
    }

}