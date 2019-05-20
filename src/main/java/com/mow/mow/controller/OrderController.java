package com.mow.mow.controller;


import com.mow.mow.dao.OrderService;
import com.mow.mow.dao.SubCategoryService;
import com.mow.mow.entities.*;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {


    private OrderService os = new OrderService();
    private SubCategoryService ss = new SubCategoryService();
    Cache cache = new Cache();

    @PostMapping("{idUser}/restaurant/{idRestaurant}/{category}/{item}")
    public Order order(@PathVariable int idUser, @PathVariable int idRestaurant, @PathVariable int category, @PathVariable int item){
        Order order = new Order();
        order.setIdRestaurant(idRestaurant);
        Persoana p = new Persoana();
        p.setIdUser(idUser);
        order.setIdUser(idUser);
        order.setStatus("neconfirmat");
        List<SubCategory> subcat = ss.findAll();
        for(SubCategory s : subcat){
            if(item == s.getIdSubcategory()){
                order.setTotal(s.getPrice());
                order.setItem(s.getName());
            }
        }
        System.out.println("idUser: " + idUser + "idRestaurant: " + idRestaurant + "Item: " + order.getItem());
        os.persist(order);
        return order;
    }



    @GetMapping("{idUser}/getOrders")
    public List<Order> getOrders(@PathVariable("idUser") int idUser){
        List<Order> result = new ArrayList<Order>();

        long val = System.currentTimeMillis() - cache.getTime();
        System.out.println(val);

        if(val<30000 && cache.getList() != null){
            result.addAll(cache.getList());
            System.out.println("From cache");
            cache.setTime(System.currentTimeMillis());
        }else{
            List<Order> list = os.findAll();
            for(Order o: list){
                if(o.getIdUser() == idUser)
                    result.add(o);
            }
            System.out.println("From db");
            cache.setList(result);
            cache.setTime(System.currentTimeMillis() + val);
        }
        return result;
    }

    @GetMapping("{idUser}/admin/export")
    public void exportCSV(HttpServletResponse response, @PathVariable int idUser) throws Exception{

        String filename = "orders.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
        StatefulBeanToCsv<Order> writer = new StatefulBeanToCsvBuilder<Order>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withQuotechar(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        writer.write(os.findAll());
        System.out.println("EXPORTED");
    }

    @PostMapping("{idUser}/admin")
    public Order changeStatus(@PathVariable int idUser, @RequestBody Order order) {
        List<Order> listOrd = os.findAll();
        for(Order o : listOrd)
            if(o.getIdOrder() == order.getIdOrder()){
                o.setStatus(order.getStatus());
                os.update(o);
            }
        return order;
    }
}
