package com.altran.Academy.controller;

import com.altran.Academy.Repository.ProductRepository;
import com.altran.Academy.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void shouldCreateProduct() throws Exception {
        Product p = new Product();
        p.setNome("Produto 1");
        p.setDescricao("Descrição toop");
        p.setPreco(50.0);
        p.setStock(5);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
                .content(new ObjectMapper().writeValueAsString(p))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldnotCreateProduct() throws Exception {
        Product p = new Product();
        p.setNome(null);
        p.setDescricao("Descrição not so good");
        p.setPreco(44.0);
        p.setStock(6);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
                .content(new ObjectMapper().writeValueAsString(p))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldReturnProductById() throws Exception{

        int id= 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/"+ id)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void shouldReturnALLProduct() throws Exception{
        
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }


}
