package com.kairos.gridtest.infrastructure.configuration;

import com.kairos.gridtest.domain.ports.output.PriceDAO;
import com.kairos.gridtest.domain.service.ProductDomainService;
import com.kairos.gridtest.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductService productService(PriceDAO priceDAOService) {
        return new ProductDomainService(priceDAOService);
    }

}