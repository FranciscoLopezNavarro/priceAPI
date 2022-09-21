package com.kairos.gridtest.infrastructure.configuration;

import com.kairos.gridtest.domain.mapping.MapperService;
import com.kairos.gridtest.domain.mapping.MapperServiceImpl;
import com.kairos.gridtest.domain.ports.output.ProductRepository;
import com.kairos.gridtest.domain.service.ProductService;
import com.kairos.gridtest.domain.service.ProductServiceImplUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    ProductService productService(ProductRepository productRepository, MapperService mapperService) {
        return new ProductServiceImplUseCase(productRepository, mapperService);
    }

    @Bean
    public MapperService mapper() {
        return new MapperServiceImpl();
    }
}