package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager= new ProductManager(repository);




    @Test
    void shouldSearchByNameBook() {
        Book Java = new Book(1, "CoreJava", 100, "Author1");
        manager.add(Java);
        Product[] expected = new Product[]{Java};
        Product[] actual = manager.searchBy("CoreJava");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByAuthorBook() {
        Book Java = new Book(1, "CoreJava", 100, "Author1");
        manager.add(Java);
        Product[] expected = new Product[]{Java};
        Product[] actual = manager.searchBy("Author1");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNameSmartphone() {
        Smartphone Apple = new Smartphone(2,"Apple13",450,"Stiv");
        manager.add(Apple);
        Product[] expected = new Product[]{Apple};
        Product[] actual = manager.searchBy("Apple13");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByProducerSmartphone() {
        Smartphone Apple = new Smartphone(2,"Apple13",450,"Stiv");
        manager.add(Apple);
        Product[] expected = new Product[]{Apple};
        Product[] actual = manager.searchBy("Stiv");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByProducerSmartphoneFalse() {
        Smartphone Apple = new Smartphone(2,"Apple13",450,"Stiv");
        manager.add(Apple);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Stiven");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByAuthorBookFalse() {
        Book Java = new Book(1, "CoreJava", 100, "Author1");
        manager.add(Java);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Author2");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNameSmartphoneFalse() {
        Smartphone Apple = new Smartphone(2,"Apple13",450,"Stiv");
        manager.add(Apple);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Apple12");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByNameBookFalse() {
        Book Java = new Book(1, "CoreJava", 100, "Author1");
        manager.add(Java);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("CoreJava1");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchByZero() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Stiv");

        assertArrayEquals(expected, actual);
    }
}