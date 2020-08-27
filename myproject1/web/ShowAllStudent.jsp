
<%@page import="StudentsServies.StudentInfo"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <title>Show all Student </title>
        
        <link rel="stylesheet" type="text/css" href="css2/style_1.css" />
        <link rel="stylesheet" type="text/css" href="css2/Show.css" />
	
    </head>
    <body>
    	<div id="container">
            <div id="header">
              <img src="images/logo1.png" alt="logo" height="200" , width="200" ,  />
                    <h1> Coding School </h1>
                    <br>  <br>  
                    <p>  Students List : </p>
            </div><!--- end header--->
           <br> <br> <br> <br> <br> <br> <br>   <br>  <br>   <br> <br>   <br> 
           
            
         
                
                <div id="contant">
					<div id="All_rec_s" >
                    
                        <ul>
                            <li>
                                <div class="rec_s_f">
					<table border="0" >
                                    	<tr>
                                            <td>Student ID</td>
                                            <td>Student Name</td>
                                            <td>Department</td>
                                            <td>Email</td>                                     
                                            <td>Update & Delete</td>
                                        </tr>
                                    </table>
                                </div><!--- end rec_s--->
                            </li>
                            <%
                            ArrayList allstd= StudentsServies.StudentInfo.getAll();
                            
                             
                            for (int i=0;i<allstd.size();i++)
                            {
                          
                            StudentInfo st = (StudentInfo) allstd.get(i);   
                            int id= st.getSid();
                            String name =st.getfullname();
                            String de =st.getDepartment();
                            String email= st.getemail();
                            String pass = st.getPassword();
                            
                  
                           
                            
                            
                            %>
                            <li>
                                <div class="rec_s">
                                    <form action="updataAndDeleteStudent.jsp">
					<table border="0" >
                                    	<tr>
                                            <td><%= id %></td>
                                            <td> <%= name %></td>
                                            <td><%= de %></td>
                                            <td><%= email %></td>
                                            
                                           
                                            <td><input type=submit value=update name=<%= id %> >&nbsp;<input type=submit value=Delete name=<%= id %> > </td>
 
                                            
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
                     <a href="addStudent.jsp"> add Student  </a> &nbsp; &nbsp;
                 
                    </div><!--end nav--->
                </div><!--- end contant--->
                <div id="footer">
                    <div id="footerIn">
                        <p>Contact us | abcd@somacodingschool.com </p>
                        <p>Tel: 123456789 </p>
                        
                    </div><!--- end footerIn--->
                </div><!--- end footer--->
            </div><!--- end warpper--->
        </div><!--- end container--->
    </body>
</html>