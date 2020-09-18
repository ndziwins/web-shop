package pw.ddteam.webshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "quantity")
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @NotBlank(message = "Product quantity must not be empty")
    private int quantity;

    public Quantity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateFrom(final Quantity source) {
        quantity = source.quantity;
    }
}
