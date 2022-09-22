package com.kairos.gridtest.application;

import com.kairos.gridtest.domain.ports.input.GetProductPriceUseCase;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetProductPriceUseCaseImpl implements GetProductPriceUseCase {


    private final ProductService productService;

    @Autowired
    public GetProductPriceUseCaseImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductPrice getProductPrice(long brandId, long productId, LocalDateTime date) {
        return productService.getProductPrice(brandId, productId, date);
    }
}
