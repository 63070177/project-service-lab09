package com.sop.lab09.projectservice.core.data;

import com.sop.lab09.projectservice.core.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    ProductEntity findByProductId(String productId);
    ProductEntity findByProductIdOrTitle(String productId, String title);
}
