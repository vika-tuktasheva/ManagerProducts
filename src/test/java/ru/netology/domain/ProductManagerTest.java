package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    //тест на добавление товаров в пустой репозиторий
    @Test
    void addNewProducts() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");
        Product book2 = new Book(2, "Harry Potter", 1200, "Rowling");
        Product smartphone1 = new Smartphone(3, "Xiaomi", 40000, "China");

        Product[] expected = new Product[]{book1, book2, smartphone1};
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);

        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    //тест на удаление товара по номеру id
    @Test
    void removeProductsByNumberId() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");
        Product smartphone1 = new Smartphone(2, "Xiaomi", 40000, "China");

        Product[] expected = new Product[]{book1};
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(smartphone1);

        manager.removeId(2);

        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    //тест на удаление единственного товара
    @Test
    void removeProductsByNumberIdOneProduct() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");

        Product[] expected = new Product[0];
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.removeId(1);

        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    //тест на поиск товара, 1 совпадение
    @Test
    void searchByNumberIdOneProductFound() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");
        Product smartphone1 = new Smartphone(3, "Xiaomi", 40000, "China");

        Product[] expected = new Product[]{book1};
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("Azbuka");
        assertArrayEquals(expected, actual);
    }

    //тест на поиск товара, несколько совпадений
    @Test
    void searchByNumberIdSomeProductFound() {
        Product book1 = new Book(1, "Azbuka", 500, "Marshak");
        Product smartphone1 = new Smartphone(2, "Xiaomi", 40000, "China");
        Product smartphone2 = new Smartphone(3, "Xiaomi", 15000, "Russia");

        Product[] expected = new Product[]{smartphone1, smartphone2};
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }
}