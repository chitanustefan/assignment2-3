package com.mow.mow.dao;

import com.mow.mow.connection.HibernateCon;
import com.mow.mow.entities.Restaurant;

import java.util.List;

public class RestaurantDao implements PersoanDaoInterface<Restaurant, String> {


    HibernateCon connection = new HibernateCon();

    public void persist(Restaurant entity) {

        connection.getCurrentSession().saveOrUpdate(entity);
    }

    public void update(Restaurant entity) {
        connection.getCurrentSession().update(entity);
    }

    public Restaurant findById(String id) {
        Restaurant restaurant = (Restaurant) connection.getCurrentSession().get(Restaurant.class, Integer.parseInt(id));
        return restaurant;
    }

    public void delete(Restaurant entity) {
        connection.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Restaurant> findAll() {
        List<Restaurant> restaurant = (List<Restaurant>) connection.getCurrentSession().createQuery("from Restaurant").list();
        return restaurant;
    }

    public void deleteAll() {
        List<Restaurant> entityList = findAll();
        for (Restaurant entity : entityList) {
            delete(entity);
        }
    }
}
