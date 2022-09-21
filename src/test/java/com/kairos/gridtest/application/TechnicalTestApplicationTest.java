package com.kairos.gridtest.application;

import com.kairos.gridtest.domain.mapping.MapperService;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.ports.output.ProductDAOService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@SpringBootTest
class TechnicalTestApplicationTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MapperService mapper;
    @Autowired
    private ProductDAOService productRepository;

    @BeforeEach
    public void setupUp() {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    private MockMvcRequestSpecification requestJson() {
        return RestAssuredMockMvc
                .given()
                .log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept("application/json;charset=UTF-8");

    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenPriceNotExists_thenReturnNotFound")
    void shouldReturnNotFoundWhenPriceDoesNotExists() {
        var brandId = 1L;
        var productId = 2L;
        var date = LocalDateTime.now();

        requestJson()
                .when()
                .get("/prices/brand/" + brandId + "/product/" + productId + "/date/" + date)
                .then()
                .log().all()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate14/06/2020:10.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest1() {
        var brandId = 1L;
        var productId = 35455L;
        var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);


        var price = requestJson()
                .when()
                .get("/prices/brand/" + brandId + "/product/" + productId + "/date/" + date)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().body().as(ProductPrice.class);

        assertThat(price, notNullValue());
        assertThat(price.getBrandId(), is(brandId));
        assertThat(price.getProductId(), is(productId));
        assertThat(price.getPriceList(), is(1));
        assertThat(price.getPrice().getValue(), is(new BigDecimal("35.50")));
        assertThat(price.getPrice().getCurrency(), is("EUR"));
        assertThat(price.getStartDate(), is(LocalDateTime.of(2020, 6, 14, 0, 0, 0)));
        assertThat(price.getEndDate(), is(LocalDateTime.of(2020, 12, 31, 23, 59, 59)));

    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate14/06/2020:16.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest2() {
        var brandId = 1L;
        var productId = 35455L;
        var date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

        var price = requestJson()
                .when()
                .get("/prices/brand/" + brandId + "/product/" + productId + "/date/" + date)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().body().as(ProductPrice.class);

        assertThat(price, notNullValue());
        assertThat(price.getBrandId(), is(brandId));
        assertThat(price.getProductId(), is(productId));
        assertThat(price.getPriceList(), is(2));
        assertThat(price.getPrice().getValue(), is(new BigDecimal("25.45")));
        assertThat(price.getPrice().getCurrency(), is("EUR"));
        assertThat(price.getStartDate(), is(LocalDateTime.of(2020, 6, 14, 15, 0, 0)));
        assertThat(price.getEndDate(), is(LocalDateTime.of(2020, 6, 14, 18, 30, 0)));
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate14/06/2020:21.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest3() {
        var brandId = 1L;
        var productId = 35455L;
        var date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);


        var price = requestJson()
                .when()
                .get("/prices/brand/" + brandId + "/product/" + productId + "/date/" + date)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().body().as(ProductPrice.class);

        assertThat(price, notNullValue());
        assertThat(price.getBrandId(), is(brandId));
        assertThat(price.getProductId(), is(productId));
        assertThat(price.getPriceList(), is(1));
        assertThat(price.getPrice().getValue(), is(new BigDecimal("35.50")));
        assertThat(price.getPrice().getCurrency(), is("EUR"));
        assertThat(price.getStartDate(), is(LocalDateTime.of(2020, 6, 14, 0, 0, 0)));
        assertThat(price.getEndDate(), is(LocalDateTime.of(2020, 12, 31, 23, 59, 59)));
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate15/06/2020:10.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest4() {
        var brandId = 1L;
        var productId = 35455L;
        var date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

        var price = requestJson()
                .when()
                .get("/prices/brand/" + brandId + "/product/" + productId + "/date/" + date)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().body().as(ProductPrice.class);

        assertThat(price, notNullValue());
        assertThat(price.getBrandId(), is(brandId));
        assertThat(price.getProductId(), is(productId));
        assertThat(price.getPriceList(), is(3));
        assertThat(price.getPrice().getValue(), is(new BigDecimal("30.50")));
        assertThat(price.getPrice().getCurrency(), is("EUR"));
        assertThat(price.getStartDate(), is(LocalDateTime.of(2020, 6, 15, 0, 0, 0)));
        assertThat(price.getEndDate(), is(LocalDateTime.of(2020, 6, 15, 11, 0, 0)));
    }

    @Test
    @DisplayName("givenBrandProductAndDate_whenDate16/06/2020:21.00.00_thenReturnProduct")
    void shouldReturnProductForGivenDataTest5() {
        var brandId = 1L;
        var productId = 35455L;
        var date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

        var price = requestJson()
                .when()
                .get("/prices/brand/" + brandId + "/product/" + productId + "/date/" + date)
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().body().as(ProductPrice.class);

        assertThat(price, notNullValue());
        assertThat(price.getBrandId(), is(brandId));
        assertThat(price.getProductId(), is(productId));
        assertThat(price.getPriceList(), is(4));
        assertThat(price.getPrice().getValue(), is(new BigDecimal("38.95")));
        assertThat(price.getPrice().getCurrency(), is("EUR"));
        assertThat(price.getStartDate(), is(LocalDateTime.of(2020, 6, 15, 16, 0, 0)));
        assertThat(price.getEndDate(), is(LocalDateTime.of(2020, 12, 31, 23, 59, 59)));
    }
}
