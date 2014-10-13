package com.galaxy.dal.domain.trade;

import com.galaxy.dal.domain.BaseDomain;
/**
 * 交易订单
 * @author luolishu
 *
 */
public class TradeOrder extends BaseDomain {
	Long userId;
	OrderType type;
	Long productId;
	OrderStatus status;
	

}
