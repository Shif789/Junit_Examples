<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%
	// read form data
	String username=request.getParameter("uname");
	String password=request.getParameter("password");
	
	if(username.equals("")|| password.equals("")|| username.length()==0|| password.length()==0){
		out.println("provide credentials");
		return;
	}
	
	//provide logic for authentication
	if(username.equalsIgnoreCase("shefat")&& password.equalsIgnoreCase("1234")){
		out.println("valid credentials");
	}else
		out.println("invalid credentials");
%>
