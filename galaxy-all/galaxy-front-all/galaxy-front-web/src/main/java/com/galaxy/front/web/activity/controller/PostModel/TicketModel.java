package com.galaxy.front.web.activity.controller.PostModel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/*author:huangshanqi
 *time  :2014年10月3日 上午10:22:07
 *email :hsqmobile@gmail.com
 */
public class TicketModel implements Serializable {
	private int id;
	private String name;
	private int qty;// 总票数
	private int saleqty;// 已售票数
	private float price;
	private int status;// 票状态
	private int type;// 票种，1=免费，2=收费

	public TicketModel() {
		super();
	}

	public TicketModel(int id, String name, int qty, int saleqty, float price, int status, int type) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.saleqty = saleqty;
		this.price = price;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSaleqty() {
		return saleqty;
	}

	public void setSaleqty(int saleqty) {
		this.saleqty = saleqty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result="";
		result += "id="+this.getId()+","
				+"name="+this.getName()+","
				+"price="+this.getPrice()+","
				+"qty="+this.getQty()+","
				+"saleqty="+this.getSaleqty()+","
				+"status="+this.getStatus()+","
				+"type="+this.getType();
		return result;
	}
	
	

}
