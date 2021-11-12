package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Book java = new Book(1, "CoreJava", 100, "Author1");
    Smartphone apple = new Smartphone(2, "Apple13", 450, "Stiv");
    Book test = new Book(3, "CoreJava", 150, "Author3");

    @Test
    void shouldSearchByNameBook() {
        manager.add(java);
        Product[] expected = new Product[]{java};
        Product[] actual = manager.searchBy("CoreJava");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorBook() {
        manager.add(java);
        Product[] expected = new Product[]{java};
        Product[] actual = manager.searchBy("Author1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        manager.add(apple);
        Product[] expected = new Product[]{apple};
        Product[] actual = manager.searchBy("Apple13");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducerSmartphone() {
        manager.add(apple);
        Product[] expected = new Product[]{apple};
        Product[] actual = manager.searchBy("Stiv");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducerSmartphoneFalse() {
        manager.add(apple);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Stiven");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorBookFalse() {
        manager.add(java);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Author2");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphoneFalse() {
        manager.add(apple);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Apple12");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameBookFalse() {
        manager.add(java);
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

    @Test
    void shouldSearchByNameSeveralBook() {
        manager.add(java);
        manager.add(test);
        Product[] expected = new Product[]{java, test};
        Product[] actual = manager.searchBy("CoreJava");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldRemoveById() {
        manager.add(java);
        manager.add(test);
        repository.removeById(1);
        Product[] expected = new Product[]{ test};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldRemoveByIdWithException() {
        manager.add(java);
        manager.add(test);

        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}