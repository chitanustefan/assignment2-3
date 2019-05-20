package com.mow.mow.entities;

import javafx.beans.Observable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Observer;


@Entity
@Table(name="persoana")
@XmlRootElement
public class Persoana implements Observer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column
    private String name;

    @Column
    private String telefon;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String adresa;

    @Column
    private String role;

    @Column(nullable = true)
    private int restaurant;

    public  Persoana(){

    }


    public Persoana(String name, String telefon, String email, String password, String adresa, String role, int restaurant) {
        this.name = name;
        this.telefon = telefon;
        this.email = email;
        this.password = password;
        this.adresa = adresa;
        this.role = role;
        this.restaurant = restaurant;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        System.out.println("USER: " + this.idUser + " // status comanda schimbat");

    }
}
