


<%@page import="StudentsServies.StudentInfo"%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	
	<head>
        <title>Search for a Student </title>
        <link rel="stylesheet" type="text/css" href="css2/style_2.css" />
      
        <link rel="stylesheet" type="text/css" href="css2/Show.css" />
           <link rel="stylesheet" type="text/css" href="css2/add.css" />
	
    </head>
    
    <body>
    <div id="container">
            <div id="header">
           <img src="images/logo1.png" alt="logo" height="200" , width="200" ,  />
                    <h1> Coding School </h1>
                     <br> <br>
                    <p>  Students List : </p>
            </div><!--- end header--->
           
                &nbsp;
               <br> <br> <br> <br> <br> <br> <br>   <br> <br> <br> 
                
                <div id="contant">
                    <div id="reg">
                        <form name="f">
                            <input type="text" name="search"/>
                            <input type="submit" name="send" value="Search"/>
                        </form>
                        
                    </div>
                    <%
                    String search= request.getParameter("search");
                    if(search!=null)
                                               {
                    %>
					<div id="All_rec_s" >
                    
                        <ul>
                            <li>
                                <div class="rec_s_f">
					<table border="0" >
                                    	<tr>
                                            <td>SID</td>
                                            <td>Full Name</td>
                                            <td>Department</td>
                                            <td>Class</td>
                                            
                                            <td>Edit & Delete</td>
                                           
                                        </tr>
                                    </table>
                                </div><!--- end rec_s--->
                            </li>
                            <%
                            ArrayList allstd= StudentsServies.StudentInfo.SeachStudent(search);
                            
                            for (int i=0;i<allstd.size();i++)
                            {
                             StudentInfo st = (StudentInfo) allstd.get(i);   
                           int id= st.getSid();
                            String name =st.getfullname();
                            String de =st.getDepartment();
                            String level= st.getemail();
                            
                            %>
                            <li>
                                <div class="rec_s">
                                    <form action="updataAndDeleteStudent.jsp">
					<table border="0" >
                                    	<tr>
                                            <td><%= id %></td>
                                            <td> <%= name %></td>
                                            <td><%= de %></td>
                                            <td><%= level %></td>
                                            
                                            <td><input type=submit value=updata name=<%= id %> >&nbsp;<input  type=submit value=Delete name=<%= id %> ></td>
                                           
                                        </tr>
                                    </table>
                                    </form>
                                </div><!--- end rec_s--->
                            </li>
                            <% } //end for %>
                        </ul>
                    </div><!--- end All_rec_s --->
                    <% } //end if %>
                
                 </div><!--- end warpper--->
        </div><!--- end container--->
         <div id="contant">
                  <div id="nav">
                  
            
                   &nbsp;  <a href="HomePage.jsp"> Home </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="adminPage.jsp"> Admin Page </a> &nbsp; &nbsp;
                    
                 
                    </div><!--end nav--->
                </div><!--- end contant--->
               
           
    </body>
</html>