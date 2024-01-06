import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void addProduct() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product 1");
        Product product2 = new Product(2, "Product 2");

        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(product1);
        expectedProducts.add(product2);

        assertEquals(expectedProducts, cart.getProducts());
    }

    @Test
    void addProducts() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product 1");
        Product product2 = new Product(2, "Product 2");
        Product product3 = new Product(3, "Product 3");

        List<Product> productsToAdd = new ArrayList<>();
        productsToAdd.add(product1);
        productsToAdd.add(product2);
        productsToAdd.add(product3);

        cart.addProducts(productsToAdd);

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(product1);
        expectedProducts.add(product2);
        expectedProducts.add(product3);

        assertEquals(expectedProducts, cart.getProducts());
    }

    @Test
    void removeProduct() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product 1");
        Product product2 = new Product(2, "Product 2");

        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(product2);

        assertEquals(expectedProducts, cart.getProducts());
    }

    @Test
    void getProducts() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Product 1");
        Product product2 = new Product(2, "Product 2");

        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(product1);
        expectedProducts.add(product2);

        assertEquals(expectedProducts, cart.getProducts());
    }
}
