package com.mow.mow.controller;


import com.mow.mow.dao.*;
import com.mow.mow.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {


    public RestaurantService rs = new RestaurantService();
    public CategoryService cs = new CategoryService();
    public SubCategoryService ss = new SubCategoryService();
    public  PersoanaService ps = new PersoanaService();
    public OrderService os = new OrderService();

    @GetMapping("{idUser}/admin")
    public List<Order> getOrders(@PathVariable int idUser) {
        List<Order> list = os.findAll();
        List<Persoana> persList = ps.findAll();
        List<Order> orders = new ArrayList<Order>();
        int idRes = 0;
        for(Persoana p:persList)
          if(p.getIdUser() == idUser)
              idRes = p.getRestaurant();

          for(Order o : list)
              if(o.getIdRestaurant() == idRes)
                  orders.add(o);

        return orders;
    }

    @GetMapping("{idUser}/restaurant/{idRestaurant}")
    public List<Category> getCategory(@PathVariable int idUser,@PathVariable int idRestaurant){
        Restaurant restaurant = rs.findById(String.valueOf(idRestaurant));
        List<Category> cats = new ArrayList<Category>();
        List<Category> all = cs.findAll();
        for(Category c : all)
            if(c.getRestaurant().getIdRestaurant() == idRestaurant){
                cats.add(c);
                System.out.println(c.getName());
                //System.out.println(c.getRestaurant().getIdRestaurant());
            }

        return cats;
    }


    @GetMapping("{idUser}/restaurant/{idRestaurant}/{category}")
    public List<SubCategory> getSubCat(@PathVariable int idUser, @PathVariable int idRestaurant,@PathVariable int category){
        Restaurant restaurant = rs.findById(String.valueOf(idRestaurant));
        List<SubCategory> menu = new ArrayList<SubCategory>();
        List<SubCategory> all = ss.findAll();
        for(SubCategory food : all)
            if(food.getRestaurant().getIdRestaurant() == idRestaurant && food.getCategory().getIdCategorie() == category){
                menu.add(food);
                System.out.println(food.getName());
            }

        return menu;
    }


    @GetMapping("{idUser}/restaurant")
    public List<Restaurant> getRestaurants() {
        return rs.findAll();
    }
}
