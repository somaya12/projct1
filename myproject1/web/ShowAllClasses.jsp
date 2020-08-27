

<%@page import="ClassServies.ClassInfo"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <title>Show all Classes </title>
        
        <link rel="stylesheet" type="text/css" href="css2/style_1.css" />
        <link rel="stylesheet" type="text/css" href="css2/Show.css" />

    </head>
    <body>
    	<div id="container">
            <div id="header">
                <img src="images/logo1.png" alt="logo" height="200" , width="200" />
                    <h1> Coding School </h1>
                     <br>   <br> 
                    <p>  Classes List : </p>
            </div><!--- end header--->
           <br> <br> <br> <br> <br> <br> <br>   <br>  <br>   <br>  <br> 
           
            
         
                
                <div id="contant">
					<div id="All_rec_s" >
                    
                        <ul>
                            <li>
                                <div class="rec_s_f">
					<table border="0" >
                                    	<tr>
                                            <td>Class ID</td>
                                            <td>Class Name</td>
                                            <td>Department</td>
                                            <td>Level</td>
                                            <td>Teacher</td>
                                            <td>Edit & Delete</td>
                                           
                                        </tr>
                                    </table>
                                </div><!--- end rec_s--->
                            </li>
                            <%
                            ArrayList allstd= ClassServies.ClassInfo.getAll();
                            
                             
                            for (int i=0;i<allstd.size();i++)
                            {
                          
                            ClassInfo st = (ClassInfo) allstd.get(i);   
                            int id= st.getCid();
                            String name =st.getClassName();
                            String de =st.getDepartment();
                            String level= st.getLevel();
                            String teacher = st.getTeacher();
                             String num = st.getClassNum();
                   
                           
                            
                            
                            %>
                            <li>
                                <div class="rec_s">
                                    <form action="updataAndDeleteClass.jsp">
					<table border="0" >
                                    	<tr>
                                            <td><%= num %></td>
                                            <td> <%= name %></td>
                                            <td><%= de %></td>
                                            <td><%= level %></td>
                                             <td><%= teacher %></td>
                                           
                                            <td><input type=submit value=update name=<%= id %> > <input  type=submit value=Delete name=<%= id %> ></td>
                                           
                                        </tr>
                                    </table>
                                    </form>
                                </div><!--- end rec_s--->
                            </li>
                            <% } %>
                        </ul>
                        
                    </div><!--- end All_rec_s --->
                </div><!--- end contant--->
                
                <div id="contant">
                <div id="nav">
                  
               <a href="HomePage.jsp"> Home </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="adminPage.jsp"> Admin Page </a> &nbsp; &nbsp;
                     &nbsp;&nbsp; <a href="addClass.jsp"> add new class </a>  &nbsp; &nbsp;
                  
                 
                    </div><!--end nav--->
                </div><!--- end contant--->
              
                    
                <div id="footer">
                    <div id="footerIn">
                        <p>Contact us | abcd@somacodingschool.com </p>
                        <p>Tel: 123456789 </p>
                        
                    </div><!--- end footerIn--->
                </div><!--- end footer--->
  
    </body>
</html>