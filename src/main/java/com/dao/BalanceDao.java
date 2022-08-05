package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BalanceBean;
import com.bean.BankBean;
import com.bean.UserBean;

@Repository
public class BalanceDao
{
	@Autowired
	JdbcTemplate stmt;
	
	
	
	
	/*public int addBalByUserId(BalanceBean balBean,int userid,int ubankid)
	{
		int rec = stmt.update("insert into userbankbalance (ubank,utype,userid,ubanknum) values (?,?,?,?)",
				balBean.getUbal(),balBean.getUbaltype(),userid,bank.getUbanknum());
		if(rec>0)
		{
			return 1;
		}
		else
		{
			return 0;
		};
	}*/
	
}
