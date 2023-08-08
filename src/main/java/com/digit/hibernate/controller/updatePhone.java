package com.digit.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernate.model.HibernateManager;



@WebServlet("/updatePhone")
public class updatePhone extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	String phone = req.getParameter("phone");
	HibernateManager hbm = new HibernateManager();
	
	if(hbm.UpdateSpecific(id,phone)){
		resp.sendRedirect("/AdharRegistration/UpdateNameSuccess.html");
	}
}
}
