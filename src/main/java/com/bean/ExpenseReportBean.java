package com.bean;

public class ExpenseReportBean
{
	private int userid;
	private String expdes;
	private int expsum;
	private int totalprice;
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getExpdes() {
		return expdes;
	}
	public void setExpdes(String expdes) {
		this.expdes = expdes;
	}
	public int getExpsum() {
		return expsum;
	}
	public void setExpsum(int expsum) {
		this.expsum = expsum;
	}
	
}
