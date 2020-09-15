package ru.geekbrains.spring.homeworks.homework1;

public class Product {
    private long id;
    private String title;
    private long price;

    public Product() {
    }

    public Product(long id, String title, long price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id" + id + "| title " + title + "| price " + price;
    }
}
