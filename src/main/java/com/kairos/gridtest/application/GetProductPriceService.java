package com.kairos.gridtest.application;

import com.kairos.gridtest.domain.ports.input.GetProductPriceUseCase;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetProductPriceService implements GetProductPriceUseCase {

    private final ProductService productDomainService;

    @Autowired
    public GetProductPriceService(ProductService productDomainService) {
        this.productDomainService = productDomainService;
    }

    @Override
    public ProductPrice getProductPrice(long brandId, long productId, LocalDateTime date) {
        return productDomainService.getProductPrice(brandId, productId, date);
    }
}
