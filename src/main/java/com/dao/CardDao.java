package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BankBean;

@Repository
public class CardDao
{
	@Autowired
	JdbcTemplate stmt;
	
	
	
	public List<BankBean> listUserCardExists(int userid)
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
			System.out.println("SMW in BankDao :: listUserCardExists");
		}
		
		
		return ubankdetails; 
	}
}
