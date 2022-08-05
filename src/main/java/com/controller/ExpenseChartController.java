package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.ExpenseReportBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;

@Controller
public class ExpenseChartController
{
	@Autowired
	ExpenseDao expDao;
	
	@GetMapping("/mychart")
	public String myChart(Model model,HttpSession session) 
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		List<ExpenseReportBean> expenses = expDao.getExpensesByUserId(userid);
		model.addAttribute("expenses", expenses);//name , totalprice 
		return "Home";
	}

}
