package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.*;
import com.agroconnect.frogger.repository.ProductRepository;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private User farmer;
    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        farmer = new User("John", "Doe", "john@example.com", "pass123", "FARMER", "123 Street", "City", "State", "12345", "0123456789");
        farmer.setId(BigInteger.valueOf(1));

        product = new Product(farmer, "Tomatoes", Category.VEGETABLE, 2.99, 10, Status.AVAILABLE);
        product.setId(BigInteger.valueOf(100));
    }

    @Test
    public void addProduct_shouldSaveProduct() {
        BigInteger farmerId = BigInteger.ONE;
        User farmer = new User();
        User mockFarmer = new User();
        mockFarmer.setId(farmerId);
        mockFarmer.setEmail("farmer@example.com");
        mockFarmer.setPassword("encoded-password");
        mockFarmer.setRole(Role.FARMER);
        mockFarmer.setFirstName("John");
        mockFarmer.setLastName("Doe");
        mockFarmer.setStreet("123 Street");
        mockFarmer.setCity("Lagos");
        mockFarmer.setState("Lagos");
        mockFarmer.setPostcode("12345");
        mockFarmer.setPhoneNumber("08012345678");

        Product product = new Product();
        product.setName("Tomato");
        product.setPrice(10.0);
        product.setQuantity(100);
        product.setCategory(Category.VEGETABLE);
        product.setStatus(Status.AVAILABLE);

        Product savedProduct = new Product();
        savedProduct.setId(BigInteger.valueOf(101));
        savedProduct.setName("Tomato");

        when(userRepository.findById(farmerId)).thenReturn(Optional.of(mockFarmer));
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        Product result = productService.addProduct(product, farmerId);

        assertNotNull(result);
        assertEquals("Tomato", result.getName());
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void getProductById_shouldReturnProduct() {
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getProductById(product.getId());

        assertTrue(result.isPresent());
        assertEquals("Tomatoes", result.get().getName());
    }

    @Test
    void getAllProducts_shouldReturnList() {
        when(productRepository.findAll()).thenReturn(List.of(product));

        List<Product> all = productService.getAllProducts();

        assertEquals(1, all.size());
    }

    @Test
    public void deleteProduct_shouldCallDelete() {
        BigInteger productId = BigInteger.ONE;
        String userEmail = "farmer@example.com";

        User farmer = new User();
        farmer.setId(BigInteger.TEN);
        farmer.setEmail(userEmail);
        farmer.setRole(Role.FARMER);

        Product product = new Product();
        product.setId(productId);
        product.setFarmer(farmer);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(farmer));

        assertDoesNotThrow(() -> productService.deleteProduct(productId, userEmail));

        verify(productRepository).deleteById(productId);
    }

    @Test
    public void updateProduct_shouldUpdateWhenAuthorized() {
        BigInteger productId = BigInteger.ONE;
        String userEmail = "farmer@example.com";
        User farmer = new User();
        farmer.setId(BigInteger.TEN);
        farmer.setEmail(userEmail);
        farmer.setRole(Role.FARMER);

        Product existingProduct = new Product();
        existingProduct.setId(productId);
        existingProduct.setFarmer(farmer);

        Product updatedProduct = new Product();
        updatedProduct.setName("Updated Name");
        updatedProduct.setPrice(15.0);
        updatedProduct.setQuantity(20);
        updatedProduct.setCategory(Category.VEGETABLE);
        updatedProduct.setStatus(Status.AVAILABLE);
        updatedProduct.setImageUrl("updated.jpg");

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(farmer));

        assertDoesNotThrow(() -> productService.updateProduct(productId, updatedProduct, userEmail));
        verify(productRepository).save(existingProduct);
        assertEquals("Updated Name", existingProduct.getName());
    }

}