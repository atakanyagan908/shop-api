package com.example.shopapi.entity;


import jakarta.persistence.*; // for Spring Boot 3
// import javax.persistence.*; // for Spring Boot 2

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_name")

    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;




    public Product() {

    }

    public Product(String productName) {
        this.productName = productName;

    }

    public long getId() {
        return id;
    }

    public  void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
