package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.ports.output.PriceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductDomainService implements ProductService {

    private final PriceDAO priceDAO;

    @Autowired
    public ProductDomainService(PriceDAO priceDAO) {
        this.priceDAO = priceDAO;
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
        return ProductPrice.builder()
                .brandId(product.getBrandId())
                .productId(product.getProductId())
                .priceList(product.getPrice().getPriceId())
                .price(product.getPrice().getAmount())
                .startDate(product.getPrice().getStartDate())
                .endDate(product.getPrice().getEndDate())
                .build();
    }
}
