package com.digit.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernate.model.Adhar;
import com.digit.hibernate.model.HibernateManager;

@WebServlet("/UpdateName")
public class Updatename extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	String name = req.getParameter("name");
	HibernateManager hbm = new HibernateManager();
	
	if(hbm.UpdateSpecific(id,name)){
		resp.sendRedirect("/AdharRegistration/UpdateNameSuccess.html");
	}
}
}
