package com.kairos.gridtest.application;

import com.kairos.gridtest.domain.ports.input.GetProductPriceUseCase;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final GetProductPriceUseCase productService;

    @Autowired
    public PricesController(GetProductPriceUseCase productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/brand/{brandId}/product/{productId}/date/{date}")
    ResponseEntity<ProductPrice> getProductPrice(@PathVariable long brandId,
                                                 @PathVariable long productId,
                                                 @PathVariable
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return Optional
                .ofNullable(productService.getProductPrice(brandId, productId, date))
                .map(productPrice -> ResponseEntity.ok().body(productPrice))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
