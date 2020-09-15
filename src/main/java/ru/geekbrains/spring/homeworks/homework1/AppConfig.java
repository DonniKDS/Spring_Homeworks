package ru.geekbrains.spring.homeworks.homework1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>,
при старте в него нужно добавить 5 любых товаров. ProductRepository позволяет получить весь список или один товар по id.
Создаем бин Cart, в который можно добавлять и удалять товары по id. Написать консольное приложение, позволяющее управлять корзиной.
При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */

@Configuration
@ComponentScan(value = {"ru.geekbrains.spring.homeworks.homework1"})
public class AppConfig {
}
