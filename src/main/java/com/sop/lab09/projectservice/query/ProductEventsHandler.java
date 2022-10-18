package com.sop.lab09.projectservice.query;

import com.sop.lab09.projectservice.core.ProductEntity;
import com.sop.lab09.projectservice.core.data.ProductRepository;
import com.sop.lab09.projectservice.core.event.ProductCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreateEvent event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }
}
