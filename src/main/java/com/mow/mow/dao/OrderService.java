package com.mow.mow.dao;

import com.mow.mow.entities.Order;

import java.util.List;

public class OrderService {
    private static OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    public void persist(Order entity) {
        orderDao.connection.openCurrentSessionwithTransaction();
        orderDao.persist(entity);
        orderDao.connection.closeCurrentSessionwithTransaction();
    }

    public void update(Order entity) {
        orderDao.connection.openCurrentSessionwithTransaction();
        orderDao.update(entity);
        orderDao.connection.closeCurrentSessionwithTransaction();
    }

    public Order findById(String id) {
        orderDao.connection.openCurrentSession();
        Order order = orderDao.findById(id);
        orderDao.connection.closeCurrentSession();
        return order;
    }

    public void delete(String id) {
        orderDao.connection.openCurrentSessionwithTransaction();
        Order order = orderDao.findById(id);
        orderDao.delete(order);
        orderDao.connection.closeCurrentSessionwithTransaction();
    }

    public List<Order> findAll() {
        orderDao.connection.openCurrentSession();
        List<Order> orders = orderDao.findAll();
        orderDao.connection.closeCurrentSession();
        return orders;
    }

    public void deleteAll() {
        orderDao.connection.openCurrentSessionwithTransaction();
        orderDao.deleteAll();
        orderDao.connection.closeCurrentSessionwithTransaction();
    }

    public OrderDao orderDao() {
        return orderDao;
    }

}
