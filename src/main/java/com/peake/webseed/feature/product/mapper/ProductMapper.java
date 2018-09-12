package com.peake.webseed.feature.product.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.product.model.Product;

public interface ProductMapper extends Mapper<Product> {
    void batchDelete(Long ids[]);
}