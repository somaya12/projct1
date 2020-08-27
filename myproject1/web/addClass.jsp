<%-- 
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        
        <title>add Class </title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css2/add.css" />
       
    </head>
    <body>
        
    	<div id="container">
       	  <div id="header">
            <img src="images/logo1.png" alt="logo" height="200" , width="200" />
                <h1> Coding School </h1>
                <br>  <br>
                <p> add a new Class</p>
                
            </div><!--- end header--->
            <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> 
                
                <div id="contant">
                    
                  <% 
                    ArrayList allvalid=(ArrayList) session.getAttribute("valid");
                    
                    if(allvalid!=null)
                                               {

                    %>
                    
                    <div id="valid">
                        <ul>
                            <%
                            for(int i=0;i<allvalid.size();i++)
                                                               {
                                %>
                            <li><%= allvalid.get(i) %>  </li>
                            <%}%>
                        </ul>
                        
                    </div>
                        <% } %>
                    <div id="reg">
                    	<form name=f action="addClass" >
                             Choose  Department : &nbsp;&nbsp;&nbsp;
                        <select name=dept>
                        <option value="ch">Choose department 
                        <option value="DataScience" >Data Science
                        <option value="CyberSecurity">Cyber Security
                            <option value="WebDevelopment">Web Development
                                <option value="IOT">IOT
                        </select> <font id=deptid class=valid1>*</font><br><br>
                       Class ID : &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type=text name=xtext id=fn> 
                        <font id=fid class=valid1>*</font><br>
                        
                        Class Name : 
                        <input type=text name=ftext id=fn> 
                        <font id=fid class=valid1>*</font><br>  
                       
                        <br> Class Level:<font id=classid class=valid1>*</font>&nbsp;&nbsp;
                        
                        <input type=radio id=rad1 name=r1 value="First" checked="" >First &nbsp;&nbsp;
                        <input type=radio id=rad2 name=r1 value="Second">Second<br>
                      
                         <br> 
                         
                        Teacher :<br>
                                
                        <input type="text" name=GPA id=GPA   value="null" >
                          <font id=GPA class=valid1>*</font><br> 
                          <br> 
                      
                        <input type=submit onclick="return validateAll()">   
                        </form>
                    </div><!--- end reg--->
			      </div><!--- end contant--->
               
            </div><!--- end warpper--->
        </div><!--- end container--->
        <div id="contant">
                <div id="nav">
                  
            
                   <a href="HomePage.jsp"> Home </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="adminPage.jsp"> Admin Page </a> &nbsp; &nbsp;
                 
                    
                    
                 
                    </div><!--end nav--->
                </div><!--- end contant--->
       
    </body>
</html>