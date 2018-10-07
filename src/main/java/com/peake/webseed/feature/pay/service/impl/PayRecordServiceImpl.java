package com.peake.webseed.feature.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.common.redis.CacheService;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.order.model.Order;
import com.peake.webseed.feature.order.service.OrderService;
import com.peake.webseed.feature.pay.enums.EnumPayStatus;
import com.peake.webseed.feature.pay.enums.EnumPayWay;
import com.peake.webseed.feature.pay.mapper.PayRecordMapper;
import com.peake.webseed.feature.pay.model.PayRecord;
import com.peake.webseed.feature.pay.service.PayRecordService;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/10/07.
 */
@Service
@Transactional
public class PayRecordServiceImpl extends AbstractService<PayRecord> implements PayRecordService {

    Logger logger = LoggerFactory.getLogger(PayRecordServiceImpl.class);

    @Value("${alipay.appid}")
    private String alipayAppid;
    @Value("${alipay.sandbox}")
    private boolean alipaySandbox;
    @Value("${alipay.private_key}")
    private String alipayPrivateKey;
    @Value("${alipay.public_key}")
    private String alipayPublicKey;
    @Resource
    private OrderService orderService;
    @Resource
    private CacheService cacheService;
    @Resource
    private PayRecordMapper PayRecordMapper;

    @Override
    public Result getPayInfo(Order order, EnumPayWay payWay) {

       order.setCreateTime(now());
       order.setDataStatus(EnumDataStatus.normal.getValue());
       order.setOrderNo("2222");
        return null;
    }

    private void createPayInfo(Order order,EnumPayWay payWay) throws AlipayApiException {

        PayRecord payRecord = new PayRecord();
        payRecord.setAttach("");
        payRecord.setCreateTime(now());
        payRecord.setDataStatus(EnumDataStatus.normal.getValue());
        payRecord.setFkOrderId(order.getPkId());
        payRecord.setPayStatus(EnumPayStatus.to_pay.getValue());
        payRecord.setPayWay(payWay.getValue());
        payRecord.setTotalFee(order.getPayFee());
        payRecord.setOutTradeNo(order.getOrderNo());
        payRecord.setUpdateTime(now());

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayAppid, alipayPrivateKey, "json", "GBK", alipayPublicKey, "RSA2");
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+payRecord.getOutTradeNo()+"\"," +
//                "\"seller_id\":\""+payRecord.get()+"\"," +
                "\"total_amount\":"+payRecord.getTotalFee() + "," +
//                "\"discountable_amount\":8.88," +
                "\"subject\":\""+"订单标题" +"\"," +
//                "\"body\":\"Iphone6 16G\"," +
                "\"buyer_id\":\""+ cacheService.getMemberInfo().getOpenId()+"\"," +
//                "      \"goods_detail\":[{" +
//                "        \"goods_id\":\"apple-01\"," +
//                "\"goods_name\":\"ipad\"," +
//                "\"quantity\":1," +
//                "\"price\":2000," +
//                "\"goods_category\":\"34543238\"," +
//                "\"body\":\"特价手机\"," +
//                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
//                "        }]," +
//                "\"operator_id\":\"Yx_001\"," +
//                "\"store_id\":\"NJ_001\"," +
//                "\"terminal_id\":\"NJ_T_001\"," +
//                "\"extend_params\":{" +
//                "\"sys_service_provider_id\":\"2088511833207846\"," +
//                "\"industry_reflux_info\":\"{\\\\\\\"scene_code\\\\\\\":\\\\\\\"metro_tradeorder\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"xxxx\\\\\\\",\\\\\\\"scene_data\\\\\\\":{\\\\\\\"asset_name\\\\\\\":\\\\\\\"ALIPAY\\\\\\\"}}\"," +
//                "\"card_type\":\"S0JP0000\"" +
//                "    }," +
//                "\"timeout_express\":\"90m\"," +
//                "\"settle_info\":{" +
//                "        \"settle_detail_infos\":[{" +
//                "          \"trans_in_type\":\"cardSerialNo\"," +
//                "\"trans_in\":\"A0001\"," +
//                "\"summary_dimension\":\"A0001\"," +
//                "\"settle_entity_id\":\"2088xxxxx;ST_0001\"," +
//                "\"settle_entity_type\":\"SecondMerchant、Store\"," +
//                "\"amount\":0.1" +
//                "          }]" +
//                "    }," +
//                "\"business_params\":\"{\\\"data\\\":\\\"123\\\"}\"," +
//                "\"receiver_address_info\":{" +
//                "\"name\":\"张三\"," +
//                "\"address\":\"上海市浦东新区陆家嘴银城中路501号\"," +
//                "\"mobile\":\"13120180615\"," +
//                "\"zip\":\"200120\"," +
//                "\"division_code\":\"310115\"" +
//                "    }," +
//                "\"logistics_detail\":{" +
//                "\"logistics_type\":\"EXPRESS\"" +
//                "    }" +
                "  }");
        AlipayTradeCreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
//            response.getOutTradeNo();
//            response.getTradeNo();
            payRecord.setTransactionNo(response.getTradeNo());
            save(payRecord);
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
