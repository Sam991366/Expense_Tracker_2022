package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BankBean;
import com.bean.UserBean;
import com.dao.BankDao;

@RestController
public class RestCardController
{
	
	@Autowired
	BankDao bankDao;
	
	@GetMapping("/carddetail")
	public List<BankBean> card(@RequestParam("expfrom") String expfrom,HttpSession session)
	{
		UserBean u = (UserBean) session.getAttribute("user");
		List<BankBean> b = bankDao.getCardDetails(u.getUserid(),expfrom);
		return b;
	}

}
