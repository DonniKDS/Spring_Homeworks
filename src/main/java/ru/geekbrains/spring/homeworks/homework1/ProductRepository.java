package ru.geekbrains.spring.homeworks.homework1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private static long countId = 5;

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<Product>(Arrays.asList(
                new Product(1L, "Book", 500L),
                new Product(2L, "Pen", 50L),
                new Product(3L, "Magazine", 300L),
                new Product(4L, "Postcard", 30L),
                new Product(5L, "Notebook", 60L)
        ));
    }

    public ProductRepository() {
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProductById(long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFound();
    }

    public void add(String title, long price) {
        countId++;
        if (price >= 0) {
            if (!title.trim().isEmpty()) {
                productList.add(new Product(countId, title, price));
            }
        }
    }

    public void delete(long id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }

    public void change(long id, String title, long price) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.get(i).setTitle(title);
                productList.get(i).setPrice(price);
            }
        }
    }
}
