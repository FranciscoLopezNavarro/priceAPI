package com.kairos.gridtest.application;

import com.kairos.gridtest.application.dto.ProductPrice;
import com.kairos.gridtest.domain.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetProductPriceUseCase {

    private final ProductDomainService domainService;

    @Autowired
    public GetProductPriceUseCase(ProductDomainService domainService) {
        this.domainService = domainService;
    }


    public ProductPrice execute(long brandId, long productId, LocalDateTime date) {
        return domainService.getProductPrice(brandId, productId, date);
    }
}
