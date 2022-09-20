package com.kairos.gridtest.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TechnicalTestApplicationTest {

	@Test
    @DisplayName("givenBrandProductAndDate_whenBrandNotExists_thenReturnNotFoundException")
    void shouldReturnNotFoundExceptionWhenBrandDoesNotExists() {
    }


    @Test
    @DisplayName("givenBrandProductAndDate_whenProductNotExists_thenReturnNotFoundException")
    void shouldReturnNotFoundExceptionWhenProductDoesNotExists() {
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate14/06/2020:10.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest1() {
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate14/06/2020:16.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest2() {
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate14/06/2020:21.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest3() {
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate15/06/2020:10.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest4() {
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate16/06/2020:21.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest5() {
    }
}
