package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Graph 
{
		@GetMapping("/graph")
		public String graph()
		{
			return "ListExpenseUsingGraph";
		}

}
