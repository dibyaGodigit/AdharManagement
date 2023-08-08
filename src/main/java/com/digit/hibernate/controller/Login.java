package com.digit.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernate.model.Adhar;
import com.digit.hibernate.model.HibernateManager;

@WebServlet("/login")
public class Login extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Adhar a = new Adhar();
	a.setId(req.getParameter("id"));
	a.setName(req.getParameter("name"));
	
	HibernateManager hbm = new HibernateManager();
	
	if(hbm.selectSpecific(a.getId()) != null) {
		resp.sendRedirect("/AdharRegistration/Home.html");
	}
}
}
