package org.faze.store.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="marka")
    @NotEmpty(message = "Имя продукта обязательно для заполнения")
    private String marka;

    @Column(name="description")
    @Size(max=255, message = "Описание продукта должно занимать не более 255 символов")
    private String description;

    @Column(name="price")
    @Min(value = 0, message = "Введите корректную цену продукта")
    private int price;

    @Column(name="amount")
    @Min(value = 0, message = "Введите корректное количество продукта")
    private int amount;

    public Product() {
    }

    public Product(String marka, String description, int price, int amount) {
        this.marka = marka;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
