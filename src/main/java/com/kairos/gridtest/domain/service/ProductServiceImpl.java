package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.model.dto.GetProductPriceResponse;
import com.kairos.gridtest.domain.repository.ProductRepository;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;


public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public GetProductPriceResponse getProductPrice(long brandId, long productId, LocalDateTime date) {
        var product = productRepository.findProductByBrandAndProductIdAndDate(brandId, productId, date);

        if (product.isEmpty())
            throw new RuntimeException("Product not found for this data");

        return mapper.map(product.get(), GetProductPriceResponse.class);
    }
}
