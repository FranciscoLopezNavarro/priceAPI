package com.kairos.gridtest.domain.service;

import com.kairos.gridtest.domain.model.Price;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.ports.input.dto.ProductPrice;
import com.kairos.gridtest.domain.ports.output.PriceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

        var filteredPriceList = filterPriceList(priceList, date);
        if (filteredPriceList.isEmpty())
            return null;

        var product = new Product(brandId, productId);
        filteredPriceList.forEach(product::addProductPrice);

        return buildProductPriceResponseFromProduct(product);
    }

    /**
     * Filter the prices list given some params
     *
     * @param date      Filter param to indicate the date in which our price is
     * @param priceList The price list
     * @return The filtered price list
     */
    private List<Price> filterPriceList(List<Price> priceList, LocalDateTime date) {
        return priceList.stream()
                .filter(price -> price.getStartDate().isBefore(date)
                        && price.getEndDate().isAfter(date))
                .collect(Collectors.toList());
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
