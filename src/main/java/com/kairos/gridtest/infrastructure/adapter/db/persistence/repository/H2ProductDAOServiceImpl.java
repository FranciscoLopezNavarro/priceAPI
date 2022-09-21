package com.kairos.gridtest.infrastructure.adapter.db.persistence.repository;

import com.kairos.gridtest.domain.model.Amount;
import com.kairos.gridtest.domain.model.Product;
import com.kairos.gridtest.domain.ports.output.ProductDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class H2ProductDAOServiceImpl implements ProductDAOService {

    private final PriceRepository priceRepository;

    @Autowired
    public H2ProductDAOServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findProductByBrandAndProductIdAndDate(long brandId, long productId, LocalDateTime date) {

        var product = new Product(brandId, productId);

        priceRepository.findByBrandIdAndProductId(brandId, productId)
                .filter(priceEntity -> priceEntity.getStartDate().isBefore(date)
                        && priceEntity.getEndDate().isAfter(date))
                .forEach(priceEntity -> {
                    product.addProductPrice(priceEntity.getPriceList(), priceEntity.getPriority(), new Amount(priceEntity.getPrice(), priceEntity.getCurrency()), priceEntity.getStartDate(), priceEntity.getEndDate());
                });

        return product.getPrices().isEmpty() ? Optional.empty() : Optional.of(product);
    }
}
