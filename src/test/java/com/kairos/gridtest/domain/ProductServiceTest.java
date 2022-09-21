package com.kairos.gridtest.domain;

import com.kairos.gridtest.domain.model.Amount;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.model.ProductPrice;
import com.kairos.gridtest.domain.repository.ProductRepository;
import com.kairos.gridtest.domain.service.ProductService;
import com.kairos.gridtest.domain.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private ProductRepository productRepository;

    private ProductService productService;


    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    @DisplayName("givenQueryData_whenProductNotFound_thenThrowException")
    void shouldReturnNotFoundExceptionWhenProductNotFoundForGivenData() {
        var brandId = 1L;
        var productId = 2L;
        var date = LocalDateTime.now();

        when(productRepository.findProductByBrandAndProductIdAndDate(brandId, productId, date)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            productService.getProductPrice(brandId, productId, date);
        });

        assertEquals("Product not found for this data", ex.getMessage());
    }


    @Test
    @DisplayName("givenQueryData_whenProductFound_thenReturnProduct")
    void shouldReturnProductWhenFoundForGivenData() {
        var brandId = 1L;
        var productId = 2L;
        var startDate = LocalDateTime.now();
        var endDate = startDate.plusDays(7);
        Product product = new Product(brandId,
                productId,
                new ProductPrice(productId, 1, 0, new Amount(BigDecimal.TEN, "EUR"), startDate, endDate));


        var queryDate = startDate.plusDays(2);
        when(productRepository.findProductByBrandAndProductIdAndDate(brandId, productId, queryDate)).thenReturn(Optional.of(product));

        var getProductResponse = productService.getProductPrice(brandId, productId, queryDate);

        assertThat(getProductResponse, notNullValue());
        assertThat(getProductResponse.getBrandId(), is(brandId));
        assertThat(getProductResponse.getProductId(), is(productId));
        assertThat(getProductResponse.getPrice().getValue(), is(BigDecimal.TEN));

    }


    @Test
    @DisplayName("givenProduct_whenProductFoundAndHaveMoreThan1Price_thenReturnPriceWithMorePriority")
    void shouldReturnProductWithTheCorrectPriceWhenFoundForGivenDataAndItHasMoreThan1Price() {
        var brandId = 1L;
        var productId = 2L;
        var startDate = LocalDateTime.now();
        var endDate = startDate.plusDays(7);
        Product product = new Product(brandId,
                productId,
                new ProductPrice(productId, 1, 0, new Amount(BigDecimal.TEN, "EUR"), startDate, endDate));

        product.addProductPrice(1, new Amount(BigDecimal.ONE, "EUR"), startDate, endDate);

        var queryDate = startDate.plusDays(2);
        when(productRepository.findProductByBrandAndProductIdAndDate(brandId, productId, queryDate)).thenReturn(Optional.of(product));

        var getProductResponse = productService.getProductPrice(brandId, productId, queryDate);

        assertThat(getProductResponse, notNullValue());
        assertThat(getProductResponse.getBrandId(), is(brandId));
        assertThat(getProductResponse.getProductId(), is(productId));
        assertThat(getProductResponse.getPrice().getValue(), is(BigDecimal.ONE));


    }


}
