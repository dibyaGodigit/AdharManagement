package com.digit.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernate.model.Adhar;
import com.digit.hibernate.model.HibernateManager;

@WebServlet("/register")
public class Register extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession(true);
	Adhar a = new Adhar();
	a.setId(req.getParameter("id"));
	a.setName(req.getParameter("name"));
	a.setDob(req.getParameter("dob"));
	a.setAddress(req.getParameter("address"));
	a.setPhone(req.getParameter("phone"));
	a.setEmail(req.getParameter("email"));
	a.setCountry(req.getParameter("country"));
	
	HibernateManager hbm = new HibernateManager();
	hbm.saveObject(a);
	
	resp.sendRedirect("/AdharRegistration/RegisterSucces.html");
}
}
