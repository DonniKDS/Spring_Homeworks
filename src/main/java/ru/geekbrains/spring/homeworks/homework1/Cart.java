package ru.geekbrains.spring.homeworks.homework1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private List<Product> cart;

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }

    public Cart() {
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void add(long id, ProductRepository repository) {
        cart.add(repository.getProductById(id));
    }

    public void delete(long id) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                cart.remove(i);
            }
        }
    }
}
