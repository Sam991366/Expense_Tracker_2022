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
import org.springframework.web.bind.annotation.RequestParam;
import com.bean.BankBean;
import com.bean.ExpenseBean;
import com.bean.ExpenseReportBean;
import com.bean.Expense_BankBean;
import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.BankDao;
import com.dao.ExpenseDao;
import com.dao.UserDao;

@Controller
public class UserController
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ExpenseDao expDao;
	
	
	@GetMapping("/signup")
	public String signupUser(UserBean user,Model model)
	{
		model.addAttribute("user", user);
		return "Signup";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") UserBean user,BindingResult result,Model model)
	{
		System.out.println("SAVE USER");
		UserBean user2 = userDao.checkDuplicatePhone(user);
		if(user2==null)
		{
			model.addAttribute("msg", "Signup done..");
			userDao.addUser(user);
			return "Login";
		}
		else
		{
			model.addAttribute("msg", "Mobile Number Already Registered....");
			return "Signup";	
		}
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	
	@PostMapping("/login")
	public String login(LoginBean login, Model model, HttpSession session)
	{
		UserBean user = userDao.verifyMobile(login);
		if (user == null)
		{
			model.addAttribute("msg", "InvalidCredentials");
			return "Login";
		} else if (user.getUsertype().contentEquals("user")) {
			session.setAttribute("user", user);
			
			int userid = user.getUserid();
			List<ExpenseReportBean> expenses = expDao.getExpensesByUserId(userid);
			model.addAttribute("expenses", expenses);//name , totalprice 
			
			return "Home";
		} else if (user.getUsertype().contentEquals("admin")) {
			session.setAttribute("user", user);
			return "Dashboard";
		} else {
			model.addAttribute("msg", "Please Contact Admin");
			return "Login";
		}
	}
	
	
	@GetMapping("/addExpense")
	public String addExpense()
	{
		return "AddExpense";
	}
	@PostMapping("/addExpense")
	public String addExpense(
			   				@RequestParam String expname,
							@RequestParam String expdes,
							@RequestParam int expsum,
							@RequestParam String expdate,
							@RequestParam String exptime,
							@RequestParam String expfrom,
							@RequestParam int expfromcardnum,
							HttpSession session,
							Model model)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		System.out.println(user.getUserid());
		Expense_BankBean expBean = new Expense_BankBean();
		expBean.setExpname(expname);
		expBean.setExpdate(expdate);
		expBean.setExpdes(expdes);
		expBean.setExpsum(expsum);
		expBean.setUbankbal(expsum);
		expBean.setExptime(exptime);
		expBean.setUtype(expfrom);
		expBean.setExpfrom(expfrom);
		expBean.setUbanknum(expfromcardnum);
		expBean.setExpfromcard(expfromcardnum);
		System.out.println(expBean.getExpfrom());
		System.out.println(expfromcardnum);
		System.out.println("Exp name"+expname);
		int check = userDao.addExpenseByUserId(expBean,user.getUserid());
		if(check==1)
		{
			model.addAttribute("msg", "Bank Details Verified succesfully.....");
		}
		else
		{
			model.addAttribute("msg", "Invalid Bank Details.....");
		}
			return "Home";
	
	}
	
	
	
	
	@GetMapping("/addBankDetails")
	public String addBankDetails(Model model,BankBean bank)
	{
		model.addAttribute("bank", bank);
		return "AddBankDetails";
	}
	
	@PostMapping("/addBankDetails")
	public String addBankDetails(@ModelAttribute("bank") BankBean bank,BindingResult result,HttpSession session,Model model)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		System.out.println("SAVE BANK DETAILS");
		int check = bankDao.addBankDetails(bank,userid);
		System.out.println("ubankid"+bank.getUbankid());
		if(check==1)
		{
			model.addAttribute("msg", "Bank Details added succesfully.....");
		}
		else
		{
			model.addAttribute("msg", "Bank Details cannot be added.....");
		}
			return "Home";
	}
	
	
	
	
	
	
	
	@GetMapping("/checkBankDetails")
	public String checkBankDetails(Model model,BankBean bank)
	{
		model.addAttribute("bank", bank);
		return "CheckIfUserCardExists";
	}
	
	@PostMapping("/checkBankDetails")
	public String checkBankDetails(@ModelAttribute("bank") BankBean bank,BindingResult result,HttpSession session,Model model)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		System.out.println("CHECKING BANK DETAILS");
		List<BankBean> check = bankDao.checkIfCardExistByUser(bank);
		if(check.isEmpty()==false)
		{
			model.addAttribute("msg", "Bank Details Verified succesfully.....");
			return "AddBalance";
			
		}
		else
		{
			model.addAttribute("msg", "Bank Details cannot be Found.....");
			return "Home";
		}
			
	}
	
	
	
	
	
	@GetMapping("/addBankBalance")
	public String addBankBalance(Model model,BankBean bank)
	{
		model.addAttribute("bank", bank);
		return "AddBalance";
	}
	
	@PostMapping("/addBankBalance")
	public String addBankBalance(@ModelAttribute("bank") BankBean bank,BindingResult result,HttpSession session,Model model)
	{
		UserBean user = (UserBean) session.getAttribute("user");
		int userid = user.getUserid();
		System.out.println("CHECKING BANK DETAILS");
		List<BankBean> check = bankDao.checkIfCardExistByUser(bank);
		if(check.isEmpty()==false)
		{
			model.addAttribute("msg", "Bank Details Verified succesfully.....");
			return "AddBalance";
			
		}
		else
		{
			model.addAttribute("msg", "Bank Details cannot be Found.....");
			return "Home";
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
