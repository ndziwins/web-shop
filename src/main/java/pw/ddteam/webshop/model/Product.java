package pw.ddteam.webshop.model;


import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Product name must not be empty")
    private String name;
    private String description;
    private String picturePath;
    private double grossPrice;
    private int quantity;

    Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

 //   public void buy(int quantityBuyed) {this.quantity = quantity - quantityBuyed; }

    public void buy(final Product source){
        quantity = quantity - source.quantity;
    }

    public void updateFrom(final Product source) {
        name = source.name;
        description = source.description;
        picturePath = source.picturePath;
        quantity = source.quantity;
    }

}
