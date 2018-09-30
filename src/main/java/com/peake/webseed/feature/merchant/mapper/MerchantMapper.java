package com.peake.webseed.feature.merchant.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.merchant.model.Merchant;

public interface MerchantMapper extends Mapper<Merchant> {
    void batchDelete(Long ids[]);
}