import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    @Test
    void testAddProduct() {
        OrderRepository orderRepository = new OrderRepository();
        Product product = new Product("TestProduct", 10);
        Product addedProduct = orderRepository.addProduct(product);

        assertEquals(product.getName(), addedProduct.getName());
        assertEquals(product.getPrice(), addedProduct.getPrice());
        assertEquals(1, addedProduct.getId());
    }

    @Test
    void testAddProducts() {
        OrderRepository orderRepository = new OrderRepository();
        List<Product> products = List.of(
                new Product("TestProduct1", 10),
                new Product("TestProduct2", 20));

        List<Product> addedProducts = orderRepository.addProducts(products);

        assertEquals(2, addedProducts.size());
        assertEquals(1, addedProducts.get(0).getId());
        assertEquals(2, addedProducts.get(1).getId());
    }

    @Test
    void testGetProduct() {
        OrderRepository orderRepository = new OrderRepository();
        Product product = new Product("TestProduct", 10);
        orderRepository.addProduct(product);

        Optional<Product> optionalProduct = orderRepository.getProduct(1);

        assertTrue(optionalProduct.isPresent());
        assertEquals(product.getName(), optionalProduct.get().getName());
        assertEquals(product.getPrice(), optionalProduct.get().getPrice());
        assertEquals(1, optionalProduct.get().getId());
    }

    @Test
    void testGetProducts() {
        OrderRepository orderRepository = new OrderRepository();
        List<Product> products = List.of(
                new Product("TestProduct1", 10),
                new Product("TestProduct2", 20));

        orderRepository.addProducts(products);

        List<Product> repoProducts = orderRepository.getProducts();

        assertEquals(2, repoProducts.size());
        assertEquals(1, repoProducts.get(0).getId());
        assertEquals(2, repoProducts.get(1).getId());
    }
}
