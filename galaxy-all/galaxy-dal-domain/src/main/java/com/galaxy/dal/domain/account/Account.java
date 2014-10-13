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
	private Double amount;//账户余额 
	private String realName;//真实姓名
	private String bankCardNum;//银行卡号
	private String alipayAccount;//支付宝账户
	private String tenpayAccount;//财付通账户
	private AccountStatus status;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getBankCardNum() {
		return bankCardNum;
	}
	public void setBankCardNum(String bankCardNum) {
		this.bankCardNum = bankCardNum;
	}
	public String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	public String getTenpayAccount() {
		return tenpayAccount;
	}
	public void setTenpayAccount(String tenpayAccount) {
		this.tenpayAccount = tenpayAccount;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
}
