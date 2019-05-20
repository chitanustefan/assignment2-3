package com.mow.mow.dao;

import com.mow.mow.entities.Category;
import com.mow.mow.entities.Restaurant;

import java.util.List;

public class RestaurantService {
    private static RestaurantDao restaurantDao;

    public RestaurantService() {
        restaurantDao = new RestaurantDao();
    }

    public void persist(Restaurant entity) {
        restaurantDao.connection.openCurrentSessionwithTransaction();
        for(Category r:entity.getCategory()){
            restaurantDao.persist(entity);
        }

        restaurantDao.connection.closeCurrentSessionwithTransaction();
    }

    public void update(Restaurant entity) {
        restaurantDao.connection.openCurrentSessionwithTransaction();
        restaurantDao.update(entity);
        restaurantDao.connection.closeCurrentSessionwithTransaction();
    }

    public Restaurant findById(String id) {
        restaurantDao.connection.openCurrentSession();
        Restaurant restaurant = restaurantDao.findById(id);
        restaurantDao.connection.closeCurrentSession();
        return restaurant;
    }

    public void delete(String id) {
        restaurantDao.connection.openCurrentSessionwithTransaction();
        Restaurant restaurant = restaurantDao.findById(id);
        restaurantDao.delete(restaurant);
        restaurantDao.connection.closeCurrentSessionwithTransaction();
    }

    public List<Restaurant> findAll() {
        restaurantDao.connection.openCurrentSession();
        List<Restaurant> restaurant = restaurantDao.findAll();
        restaurantDao.connection.closeCurrentSession();
        return restaurant;
    }

    public void deleteAll() {
        restaurantDao.connection.openCurrentSessionwithTransaction();
        restaurantDao.deleteAll();
        restaurantDao.connection.closeCurrentSessionwithTransaction();
    }

    public RestaurantDao restarantDao() {
        return restaurantDao;
    }

}
