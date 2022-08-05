package com.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.BankBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;



@Controller
public class ExpenseController 
{
	@Autowired
	JdbcTemplate stmt;
	
	@Autowired
	ExpenseDao expDao;
	
	@GetMapping("/listExpensesByUserId")
	public String listExpensesByUserId(HttpSession session,Model model)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		System.out.println("LIST EXPENSES CALLED.....");
		List<ExpenseBean> ubankdetails = expDao.listExpensesByUserId(userid);
		model.addAttribute("ubankdetails", ubankdetails);
		return "ListUserExpenseDetails";
	}
}
