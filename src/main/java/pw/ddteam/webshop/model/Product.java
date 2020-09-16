package pw.ddteam.webshop.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private int id;
    @NotBlank(message = "Product name must not be empty")
    private String name;
    private String description;
    private String picturePath;

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
}
