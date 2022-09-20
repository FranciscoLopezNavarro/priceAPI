package com.kairos.gridtest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {


    @Test
    @DisplayName("givenQueryData_whenProductNotFound_thenNotFoundException")
    void shouldReturnNotFoundExceptionWhenProductNotFoundForGivenData() {

    }


    @Test
    @DisplayName("givenQueryData_whenProductFound_thenReturnProduct")
    void shouldReturnProductWhenFoundForGivenData() {

    }


    @Test
    @DisplayName("givenProduct_whenProductFoundAndHaveMoreThan1Price_thenReturnPriceWithMorePriority")
    void shouldReturnProductWithTheCorrectPriceWhenFoundForGivenDataAndItHasMoreThan1Price() {
    }
}
