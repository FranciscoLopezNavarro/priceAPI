package com.kairos.gridtest.infrastructure.adapter.db.repository;

import com.kairos.gridtest.domain.model.Amount;
import com.kairos.gridtest.domain.model.Price;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.ports.output.PriceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class H2PriceDAOService implements PriceDAO {

    private final PriceRepository priceRepository;

    @Autowired
    public H2PriceDAOService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    @Override
    public List<Price> findPriceByBrandAndProduct(long brandId, long productId) {

        return priceRepository.findByBrandIdAndProductId(brandId, productId)
                .map(priceEntity -> new Price(brandId,
                        productId,
                        priceEntity.getPriceList(),
                        priceEntity.getPriority(),
                        new Amount(priceEntity.getPrice(),
                                priceEntity.getCurrency()),
                        priceEntity.getStartDate(),
                        priceEntity.getEndDate()))
                .collect(Collectors.toList());

    }
}
