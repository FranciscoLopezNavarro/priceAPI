package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.mapping.MapperService;
import com.kairos.gridtest.domain.model.Price;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.ports.input.GetProductPriceUseCase;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.ports.output.PriceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductDomainService implements ProductService {

    private final PriceDAO priceDAO;

    private final MapperService mapper;

    @Autowired
    public ProductDomainService(PriceDAO priceDAO, MapperService mapper) {
        this.priceDAO = priceDAO;
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
        var priceList = priceDAO.findPriceByBrandAndProduct(brandId, productId);

        if (priceList.isEmpty())
            return null;

        var product = new Product(brandId, productId);

        priceList.stream()
                .filter(price -> price.getStartDate().isBefore(date) && price.getEndDate().isAfter(date))
                .forEach(price -> product.getPrices().add(price));

        return buildProductPriceResponseFromProduct(product);
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
