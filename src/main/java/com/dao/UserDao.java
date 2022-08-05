package com.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BankBean;
import com.bean.Expense_BankBean;
import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao 
{
	
	@Autowired // spring.xml or stereotype annotation
	JdbcTemplate stmt;
	
	@Autowired
	BankDao bankDao;

	public void addUser(UserBean user)
	{
		stmt.update("insert into users (firstname,usertype,email,mobile,password,gender) values (?,?,?,?,?,?)",
				user.getFirstname(), "user", user.getEmail(), user.getMobile(),user.getPassword(),
				user.getGender());
	}
	
	public UserBean verifyMobile(LoginBean loginBean)
	{
		UserBean user = null;
		System.out.println(loginBean.getMobile());
		try {
		user = stmt.queryForObject("select * from users where mobile = ? and password = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { loginBean.getMobile(), loginBean.getPassword() });
		System.out.println(user);
		}catch(Exception e) {
			System.out.println("invalid email password");
		}
		return user;
		
	}
	
	
	
	public UserBean checkDuplicatePhone(UserBean loginBean)
	{
		UserBean user = null;
		System.out.println(loginBean.getMobile());
		try {
		user = stmt.queryForObject("select * from users where mobile = ?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { loginBean.getMobile()});
		System.out.println(user);
		}catch(Exception e) {
			System.out.println("Number already Present....");
		}
		return user;
		
	}

	public int addExpenseByUserId(Expense_BankBean expBean,int userid) 
	{
		Expense_BankBean alist = null;
		try	
		{
		
		System.out.println("Card::"+expBean.getExpfrom());
		System.out.println("Card Type::"+expBean.getExpfrom());
		System.out.println("Card Number::"+expBean.getUbanknum());
		System.out.println("Expense Sum is ::"+expBean.getExpsum());
				
		

		alist = stmt.queryForObject("select * from userbankdetails where utype = ? and ubanknum = ? and userid=?",new BeanPropertyRowMapper<Expense_BankBean>(Expense_BankBean.class),
				new Object[] { expBean.getUtype(),expBean.getUbanknum(),userid});
		int bankbal = alist.getUbankbal();
		//temp = alist.getUbankbal();
		if(alist != null)
		{	
			
			int rec = stmt.update("insert into expense (expname,expdes,expsum,expdate,exptime,userid,expfrom,expfromcard) values (?,?,?,?,?,?,?,?)",
				expBean.getExpname(),  expBean.getExpdes(), expBean.getExpsum(), expBean.getExpdate(),
				expBean.getExptime(),userid,expBean.getExpfrom(),expBean.getExpfromcard());
			
		
			
		if(rec>0)
		{
			bankDao.minusExpenseFromBalance(expBean.getExpsum(), userid,bankbal);
			
			return 1;
		}	
		else
		{
			return 0;
		}
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	
	

	
	
}
