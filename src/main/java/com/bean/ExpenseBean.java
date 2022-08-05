package com.bean;

public class ExpenseBean 
{
	private String expname;
	private String expdes;
	private int expsum;
	private String expdate;
	private String exptime;
	private String expfrom;
	private int expfromcard;
	public int getExpfromcard() {
		return expfromcard;
	}
	public void setExpfromcard(int expfromcard) {
		this.expfromcard = expfromcard;
	}
	public String getExpfrom() {
		return expfrom;
	}
	public void setExpfrom(String expfrom) {
		this.expfrom = expfrom;
	}
	public String getExpname() {
		return expname;
	}
	public void setExpname(String expname) {
		this.expname = expname;
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
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public String getExptime() {
		return exptime;
	}
	public void setExptime(String exptime) {
		this.exptime = exptime;
	}	
	
	
}
