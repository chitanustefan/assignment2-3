package com.mow.mow.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Observable;

@Entity
@Table(name = "comanda")
@XmlRootElement
public class Order extends Observable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @Column
    private int idUser;

    @Column
    private int idRestaurant;

    @Column
    private int total;

    @Column
    private String status;

    @Column
    private String item;

    public Order(){ }

    public Order(int idUser, int idRestaurant, int total, String status, String item) {
        this.idUser = idUser;
        this.idRestaurant = idRestaurant;
        this.total = total;
        this.status = status;
        this.item = item;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int  idUser) {

        this.idUser = idUser;
        Persoana p = new Persoana();
        p.setIdUser(this.idUser);
        this.addObserver(p);
        setChanged();
        String response = "New order was placed to restaurant" + idRestaurant;
        notifyObservers(response);
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        Persoana p = new Persoana();
        p.setIdUser(this.idUser);
        this.addObserver(p);
        setChanged();
        String response = "Order status changed";
        notifyObservers(response);
        this.status = status;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
