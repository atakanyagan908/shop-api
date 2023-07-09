package com.example.shopapi.entity;


import jakarta.persistence.*; // for Spring Boot 3
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.AnyDiscriminator;

import java.util.List;
// import javax.persistence.*; // for Spring Boot 2

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 3)
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;




    public Category() {

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;

    }

    public long getId() {
        return id;
    }

    public  void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }








}