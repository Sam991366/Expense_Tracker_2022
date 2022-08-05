package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.BankBean;
import com.bean.UserBean;
import com.dao.BankDao;
import com.dao.CardDao;

@Controller
public class BankController
{
	@Autowired
	BankDao bankDao;
	
	@Autowired
	CardDao cardDao;
	/*
	@GetMapping("/displayBankDetailsByUserId")
	public String checkBankDetails(Model model,BankBean bank)
	{
		model.addAttribute("bank", bank);
		return "displayBankDetailsByUserId";
	}
	
	@PostMapping("/displayBankDetailsByUserId")
	public String checkBankDetails(@ModelAttribute("bank") BankBean bank,BindingResult result,HttpSession session,Model model)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		System.out.println("FETCHING BANK DETAILS BY USERID..");
		List<BankBean> check = bankDao.getUBankDetailsAfterLogin(userid);
		if(check.isEmpty()==false)
		{
			model.addAttribute("msg", "Bank Details Verified succesfully.....");
			return "AddBalance";
			
		}
		else
		{
			model.addAttribute("msg", "Bank Details cannot be	 Found.....");
			return "Home";
		}
			
	}*/
	
	
	@GetMapping("/listbankdetailsofuser")
	public String getAllUsers(Model model,HttpSession session)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		List<BankBean> ubankdetails = cardDao.listUserCardExists(userid);
		model.addAttribute("ubankdetails", ubankdetails);
		return "ListUserBankDetails";
	}
	
	@GetMapping("/checkIfCardExistByUser")
	public String  checkIfCardExistByUser(Model model,HttpSession session)
	{
		return "";
	}
	
	}
