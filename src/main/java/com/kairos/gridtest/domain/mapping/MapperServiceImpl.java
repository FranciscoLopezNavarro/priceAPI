package com.kairos.gridtest.domain.mapping;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.kairos.gridtest.domain.model.Price;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.model.dto.ProductPrice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

public class MapperServiceImpl implements MapperService {

    private Mapper mapper;

    @Override
    public Mapper getMapper() {
        return mapper;
    }

    @PostConstruct
    public void initDozer() {
        mapper = DozerBeanMapperBuilder.create()
                .withMappingBuilder(new BeanMappingBuilder() {
                    @Override
                    protected void configure() {
                        mapping(Price.class, ProductPrice.class)
                                .fields("priceId", "priceList")
                                .fields("amount", "price");

                    }
                })
                .build();
    }
}
