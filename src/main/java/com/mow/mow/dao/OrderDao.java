package com.mow.mow.dao;

import com.mow.mow.connection.HibernateCon;
import com.mow.mow.entities.Order;

import java.util.List;

public class OrderDao implements OrderDaoInterface<Order, String> {


    HibernateCon connection = new HibernateCon();

    public void persist(Order entity) {

        connection.getCurrentSession().save(entity);
    }

    public void update(Order entity) {
        connection.getCurrentSession().update(entity);
    }

    public Order findById(String id) {
        Order order = (Order) connection.getCurrentSession().get(Order.class, Integer.parseInt(id));
        return order;
    }

    public void delete(Order entity) {
        connection.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Order> findAll() {
        List<Order> orders = (List<Order>) connection.getCurrentSession().createQuery("from Order").list();
        return orders;
    }

    public void deleteAll() {
        List<Order> entityList = findAll();
        for (Order entity : entityList) {
            delete(entity);
        }
    }
}
