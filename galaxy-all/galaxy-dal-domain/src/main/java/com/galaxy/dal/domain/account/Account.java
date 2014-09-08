package com.galaxy.dal.domain.account;

import com.galaxy.dal.domain.BaseDomain;
/**
 * 账户
 * @author luolishu
 *
 */
public class Account extends BaseDomain {
	private Long userId;//用户绑定的账户
	private AccountType accountType;//账户类型
	private Double amount;//账户历史
	private Long bonus;//积分
	private String realName;//真实姓名
	private String bankCardNum;//银行卡号
	private String alipayAccount;//支付宝账户
	private String tenpayAccount;//财付通账户
	
}
