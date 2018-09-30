package com.peake.webseed.feature.merchant.service;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.merchant.model.Merchant;
import com.peake.webseed.core.Service;


/**
 * Created by CodeGenerator on 2018/09/30.
 */
public interface MerchantService extends Service<Merchant> {
    Result deleteByIds(Long[] ids);
    Result getAllMerchants();
}
