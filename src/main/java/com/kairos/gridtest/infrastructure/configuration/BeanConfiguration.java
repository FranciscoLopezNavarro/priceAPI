package com.kairos.gridtest.infrastructure.configuration;

import com.kairos.gridtest.domain.mapping.MapperService;
import com.kairos.gridtest.domain.mapping.MapperServiceImpl;
import com.kairos.gridtest.domain.ports.output.PriceDAO;
import com.kairos.gridtest.domain.service.ProductDomainService;
import com.kairos.gridtest.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductService productService(PriceDAO priceDAOService, MapperService mapperService) {
        return new ProductDomainService(priceDAOService, mapperService);
    }

    @Bean
    public MapperService mapper() {
        return new MapperServiceImpl();
    }

}