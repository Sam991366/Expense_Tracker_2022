package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BankBean;
import com.bean.ExpenseBean;
import com.bean.ExpenseReportBean;
import com.bean.Expense_BankBean;

@Repository
public class ExpenseDao
{
	@Autowired
	JdbcTemplate stmt;
	
	public List<Expense_BankBean> listUserCardExists(int userid,String utype,String ubanknum)
	{
	 
		List<Expense_BankBean> ifValidAccount = null;
	 
		try
		{
			ifValidAccount = stmt.query("select * from userbankdetails where userid = ?,utype = ? and ubanknum = ?",
					new BeanPropertyRowMapper<Expense_BankBean>(Expense_BankBean.class),
					new Object[] { userid,utype,ubanknum});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("SMW in BankDao :: listUserCardExists");
		}
		
		
		return ifValidAccount; 
	}
	
	
	public List<ExpenseBean> listExpensesByUserId(int userid)
	{
		List<ExpenseBean> ubankdetails = null;
		try
		{
					ubankdetails = stmt.query("select * from expense where userid = ?",
					new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class),
					new Object[] { userid});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("SMW in ExpenseDao :: listExpensesByUserId");
		}
		
		
		return ubankdetails;
		
	}


	public List<ExpenseReportBean> getExpensesByUserId(int userid)
	{
		List<ExpenseReportBean> alist = null;
		alist = stmt.query("select expdes,sum(expsum) as totalprice from expense where userid = ? group by expdes",
				new BeanPropertyRowMapper<ExpenseReportBean>(ExpenseReportBean.class),
				new Object[] { userid});
		System.out.println(alist);
		return alist;
	}

}
