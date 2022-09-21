package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.mapping.MapperService;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.ports.output.ProductDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImplUseCase implements ProductService {

    private final ProductDAOService productRepository;

    private final MapperService mapper;

    @Autowired
    public ProductServiceImplUseCase(ProductDAOService productRepository, MapperService mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    /**
     * Get the price of a product according to a given date.
     *
     * @param brandId   The brand to which the product belong
     * @param productId The product identifier.
     * @param date      The date in which the price wants to be obtained.
     * @return The price of the product and its details.
     */
    @Override
    public ProductPrice getProductPrice(long brandId, long productId, LocalDateTime date) {
        var product = productRepository.findProductByBrandAndProductIdAndDate(brandId, productId, date);

        if (product.isEmpty())
            return null;

        return buildProductPriceResponseFromProduct(product.get());
    }

    /**
     * Builds the response object from the product obtained from the repository
     *
     * @param product The product obtained from the repository
     * @return The price of the product and its details.
     */
    private ProductPrice buildProductPriceResponseFromProduct(Product product) {
        return mapper.getMapper().map(product.getPrice(), ProductPrice.class);
    }
}
