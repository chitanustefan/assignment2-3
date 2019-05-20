package com.mow.mow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="restaurant")
@XmlRootElement
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRestaurant",unique = true, nullable = false)
    private int idRestaurant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adresa;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "restaurant")
    private List<Category> category = new ArrayList<Category>();

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "restaurant")
    private List<SubCategory> subcategory = new ArrayList<SubCategory>();

    public Restaurant(){}
/*
    private Restaurant(Builder builder){
        this.name = builder.name;
        this.adresa = builder.adresa;
        this.idRestaurant = builder.idRestaurant;
        this.category = builder.category;

    }
 */

    public List<SubCategory> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<SubCategory> subcategory) {
        this.subcategory = subcategory;
    }

    public Restaurant(String name, String adresa) {
        this.name = name;
        this.adresa = adresa;
    }

    public Restaurant(String name, String adresa, List<Category> category) {
        this.name = name;
        this.adresa = adresa;
        this.category = category;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Category> getCategory() {
        return category;
    }


    public void setCategory(List<Category> category) {
        this.category = category;
    }

    /*
    public class Builder{

        private int idRestaurant;
        private String name;
        private String adresa;
        private List<Category> category;

        public Builder(String name, String adresa, List<Category> category) {
            this.name = name;
            this.adresa = adresa;
            this.category = category;
        }

        public Restaurant build(){
            return new Restaurant(this);
        }

    }
*/

}
