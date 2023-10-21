package com.diego.springboot;

import com.diego.springboot.controllers.ProductController;
import com.diego.springboot.dtos.ProductRecordDto;
import com.diego.springboot.models.ProductModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringbootApplicationTests {

    @Autowired
    private ProductController productController;

    @Test
    @Transactional
    public void testSaveProduct() {
        ProductRecordDto dto = new ProductRecordDto("Produto de Teste", BigDecimal.TEN);
        ResponseEntity<ProductModel> response = productController.saveProduct(dto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @Transactional
    public void testGetAllProducts() {
        List<ProductModel> products = productController.getAllProducts().getBody();
        assertEquals(false, products.isEmpty());
    }

    @Test
    @Transactional
    public void testUpdateProduct() {
        ProductRecordDto dto = new ProductRecordDto("Produto Atualizado", BigDecimal.valueOf(200.0));
        List<ProductModel> products = productController.getAllProducts().getBody();
        ResponseEntity<Object> response = productController.updateProduct(products.get(0).getIdProduto(), dto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Transactional
    public void testDeleteProduct() {
        List<ProductModel> products = productController.getAllProducts().getBody();
        ResponseEntity<Object> response = productController.deleteProduct(products.get(0).getIdProduto());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}