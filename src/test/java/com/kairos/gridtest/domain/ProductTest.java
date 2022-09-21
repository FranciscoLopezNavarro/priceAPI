package com.kairos.gridtest.domain;

import com.kairos.gridtest.domain.model.Amount;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductTest {

    @Test
    @DisplayName("givenProduct_whenProductHave1Price_thenReturnPrice")
    void shouldReturnProductPriceWhenProductOnlyHasOnePrice() {
        var brandId = 1L;
        var productId = 2L;
        var startDate = LocalDateTime.now();
        var endDate = startDate.plusDays(7);

        Product product = new Product(brandId,
                productId,
                new Price(brandId, productId, 0, 0, new Amount(BigDecimal.TEN, "EUR"), startDate, endDate));

        assertThat(product.getPrice().getAmount().getValue(), is(BigDecimal.TEN));
    }


    @Test
    @DisplayName("givenProduct_whenProductHaveMoreThan1Price_thenReturnPriceWithMorePriority")
    void shouldReturnProductPriceWithPriorityWhenProductHasMoreThanOnePrice() {

        var brandId = 1L;
        var productId = 2L;
        var startDate = LocalDateTime.now();
        var endDate = startDate.plusDays(7);

        Product product = new Product(brandId,
                productId,
                new Price(brandId, productId, 0, 0, new Amount(BigDecimal.TEN, "EUR"), startDate, endDate));

        product.addProductPrice(1, new Amount(BigDecimal.ONE, "EUR"), startDate, endDate);

        assertThat(product.getPrices().size(), is(2));
        assertThat(product.getPrice().getAmount().getValue(), is(BigDecimal.ONE));
    }

}
