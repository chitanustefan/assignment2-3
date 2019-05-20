package com.mow.mow.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="subcategory")
@XmlRootElement
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubcategory;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch= FetchType.EAGER)
    @JoinColumn(name = "idCategorie", nullable = false)
    private Category category;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch= FetchType.EAGER)
    @JoinColumn(name = "idRestaurant", nullable = false)
    private Restaurant restaurant;

    @Column
    private String image;

    public SubCategory(){}

    public SubCategory(String name, int price, Category category, String image) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public int getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(int idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
