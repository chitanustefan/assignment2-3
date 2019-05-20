package com.mow.mow.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="category")
@XmlRootElement
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategorie",unique = true, nullable = false)
    private int idCategorie;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
    private List<SubCategory> subcat = new ArrayList<SubCategory>();

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch= FetchType.EAGER)
    @JoinColumn(name = "idRestaurant", nullable = false)
    private Restaurant restaurant;

    public Category(){}

    public Category(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    /*
    public Category(String name, List<SubCategory> subcat, Restaurant restaurant) {
        this.name = name;
        this.subcat = subcat;
        this.restaurant = restaurant;
    }
*/
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubcat() {
        return subcat;
    }

    public void setSubcat(List<SubCategory> subcat) {
        this.subcat = subcat;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
