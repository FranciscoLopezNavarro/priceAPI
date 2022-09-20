package com.kairos.gridtest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    @DisplayName("givenProduct_whenProductHave1Price_thenReturnPrice")
    void shouldReturnProductPriceWhenProductOnlyHasOnePrice() {
    }


    @Test
    @DisplayName("givenProduct_whenProductHaveMoreThan1Price_thenReturnPriceWithMorePriority")
    void shouldReturnProductPriceWithPriorityWhenProductHasMoreThanOnePrice() {
    }

}
