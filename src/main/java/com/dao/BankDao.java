package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BankBean;

@Repository
public class BankDao 
{

	@Autowired
	JdbcTemplate stmt;
	
	public int addBankDetails(BankBean bank, int userid) 
	{
		int rec = stmt.update("insert into userbankdetails (ubank,utype,userid,ubanknum,ubankbal) values (?,?,?,?,?)",
				bank.getUbank(),bank.getUtype(),userid,bank.getUbanknum(),bank.getUbankbal());
		if(rec>0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	
	
	public List<BankBean> getUBankDetailsAfterLogin(int userid)
	{
		List<BankBean> ubankdetails = null;
		try
		{
			ubankdetails = stmt.query("select * from userbankdetails where userid = ?",
					new BeanPropertyRowMapper<BankBean>(BankBean.class),
					new Object[] { userid});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("SMW in BankDao :: getUBankIdsAfterLogin");
		}
		
		
		return ubankdetails;
	}
	
	
	
	public List<BankBean> checkIfCardExistByUser(BankBean bank)
	{
		List<BankBean> user = null;
		try {
		user = stmt.query("select * from userbankdetails where ubanknum = ?",
				new BeanPropertyRowMapper<BankBean>(BankBean.class),
				new Object[] { bank.getUbanknum()});
		}
		catch(Exception e)
		{
		System.out.println("SMW in BankDao :: checkIfCardExistByUser");
		e.printStackTrace();}
		return user;
	}



	public List<BankBean> getCardDetails(int userid,String ufrom) 
	{
		List<BankBean> b = stmt.query("select * from userbankdetails where userid = ? and utype = ?", new BeanPropertyRowMapper<BankBean>(BankBean.class),userid,ufrom);
		return b;
	}
	
	public int minusExpenseFromBalance(int expense,int userid,int bankbal)
	{
		System.out.println("Balance is ::"+bankbal);
		System.out.println("Expense::"+expense);
		bankbal = bankbal - expense;
		int rec = stmt.update("Update userbankdetails set ubankbal = ? where userid = ?",bankbal,userid);
		return rec;
	}
	
}
