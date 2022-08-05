package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.Expense_BankBean;



@Controller
public class Expense_BankController
{
	
	@GetMapping("/")
	public String verifyForAddExpense(Expense_BankBean expBankBean,Model model)
	{
		
		return "Home";
	}
	
}
