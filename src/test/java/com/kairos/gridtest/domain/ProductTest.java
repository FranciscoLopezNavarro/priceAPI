package com.kairos.gridtest.domain;

import com.kairos.gridtest.domain.model.Amount;
import com.kairos.gridtest.domain.model.Price;
import com.kairos.gridtest.domain.model.Product;
import org.junit.jupiter.api.Disabled;
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

        Product product =
                new Product(
                        brandId,
                        productId,
                        Price.builder()
                                .brandId(brandId)
                                .productId(productId)
                                .priceId(0)
                                .priority(0)
                                .amount(Amount.builder()
                                        .value(BigDecimal.TEN)
                                        .currency("EUR")
                                        .build())
                                .startDate(startDate)
                                .endDate(endDate)
                                .build()
                );

        assertThat(product.getPrice().getAmount().getValue(), is(BigDecimal.TEN));
    }


    @Test
    @DisplayName("givenProduct_whenProductHaveMoreThan1Price_thenReturnPriceWithMorePriority")
    void shouldReturnProductPriceWithPriorityWhenProductHasMoreThanOnePrice() {

        var brandId = 1L;
        var productId = 2L;
        var startDate = LocalDateTime.now();
        var endDate = startDate.plusDays(7);

        Product product =
                new Product(
                        brandId,
                        productId,
                        Price.builder()
                                .brandId(brandId)
                                .productId(productId)
                                .priceId(0)
                                .priority(0)
                                .amount(Amount.builder()
                                        .value(BigDecimal.TEN)
                                        .currency("EUR")
                                        .build())
                                .startDate(startDate)
                                .endDate(endDate)
                                .build()
                );

        product.addProductPrice(
                1,
                1,
                Amount.builder()
                        .value(BigDecimal.ONE)
                        .currency("EUR")
                        .build(),
                startDate,
                endDate
        );

        assertThat(product.getPrices().size(), is(2));
        assertThat(product.getPrice().getAmount().getValue(), is(BigDecimal.ONE));
    }


}
