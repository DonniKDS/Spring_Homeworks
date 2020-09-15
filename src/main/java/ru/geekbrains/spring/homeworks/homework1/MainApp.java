package ru.geekbrains.spring.homeworks.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository repository = context.getBean("productRepository", ProductRepository.class);
        Cart cart = context.getBean("cart", Cart.class);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите команду. \n /help - показать полный список команд.");
            label:
            while (true) {
                String com = reader.readLine();
                switch (com) {
                    case "/help":
                        help();
                        break;
                    case "/showAll":
                        showAll(repository);
                        break;
                    case "/showCart":
                        showCart(cart);
                        break;
                    case "/add":
                        add(repository, cart, reader);
                        break;
                    case "/delete":
                        delete(cart, reader);
                        break;
                    case "/exit":
                        break label;
                    default:
                        System.out.println("Некорректная команда");;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        context.close();
    }

    private static void help() {
        System.out.println("Полный список команд: \n" +
                "/add - добавляет продукт в корзину \n" +
                "/delete - удаляет продукт из корзины; \n" +
                "/showAll - показывает список продуктов; \n" +
                "/showCart - показывает продукты в корзине; \n" +
                "/exit - выйти из программы.");
    }

    private static void showAll(ProductRepository repository) {
        if (repository.getProductList().isEmpty()) {
            System.out.println("В магазине закончились продукты.");
        } else {
            for (Product product : repository.getProductList()) {
                System.out.println(product.toString());
            }
        }
    }

    private static void showCart(Cart cart) {
        if (cart.getCart().isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Product product : cart.getCart()) {
                System.out.println(product.toString());
            }
        }
    }

    private static void add(ProductRepository repository, Cart cart, BufferedReader reader) {
        System.out.println("Введите id");
        long id;
        while (true) {
            try {
                id = Long.parseLong(reader.readLine());
                break;
            } catch (IOException e) {
                System.out.println("Некорректный id. Введите снова!");
            }
        }
        cart.add(id, repository);
        System.out.println("Продукт успешно добавлен в корзину.");
    }

    private static void delete(Cart cart, BufferedReader reader) {
        System.out.println("Введите id");
        long id;
        while (true) {
            try {
                id = Long.parseLong(reader.readLine());
                break;
            } catch (IOException e) {
                System.out.println("Некорректный id. Введите снова!");
            }
        }
        cart.delete(id);
        System.out.println("Продукт успешно удален с корзины.");
    }
}
