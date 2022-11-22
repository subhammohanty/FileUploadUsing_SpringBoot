package com.javatechie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.controller.ProductController;
import com.javatechie.entity.Product;
import com.javatechie.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    private static final String ENDPOINT_URL = "/products";

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getProductsTest() throws Exception {
        Product product = new Product("Mobile" , 10000 , "OnePlus" , "Electronics");
        Mockito.when(productService.getProducts()).thenReturn(Collections.singletonList(product));
        mockMvc.perform(MockMvcRequestBuilders
                .get(ENDPOINT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductTest() throws Exception {
        Product product = new Product("Mobile" , 10000 , "OnePlus" , "Electronics");
        Mockito.when(productService.getProduct(Mockito.anyInt())).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/1")
                        .content(String.valueOf(Objects.requireNonNull(product)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void addProductTest() throws Exception {
        Product product = new Product("Mobile" , 10000 , "OnePlus" , "Electronics");
        Mockito.when(productService.addProduct(Mockito.any(Product.class))).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders
                        .post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
