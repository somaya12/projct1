


<%@page import="Mark.StudentInfo"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	
	<head>
        <title>Marks </title>
        <link rel="stylesheet" type="text/css" href="css2/style_2.css" />
      
        <link rel="stylesheet" type="text/css" href="css2/Show.css" />
           <link rel="stylesheet" type="text/css" href="css2/add.css" />
	
    </head>
    
    <body>
    <div id="container">
            <div id="header">
                <img src="images/logo1.png" alt="logo" height="200" , width="200" />
                    <h1> Coding School </h1>
                    <br> <br> 
                    <p>  Add Marks : </p>
            </div><!--- end header--->
            
                &nbsp;
               <br> <br> <br> <br> <br> <br> <br>   <br> <br> <br> 
                
                <div id="contant">
                    <div id="reg">
                        <form name="f">
                            <select name=search>
                        
                                <option value="${user.id}"  >${user.id} <br>
                             
                            <input type="submit" name="send" value="add marks"/>
                           
                            
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
                                           
                                            <td>Student ID</td>
                                            <td>Class ID</td>
                                            <td>Class Name</td>
                                            <td>Department</td>
                                            <td>level</td>
                                            <td>Teacher</td>
                                             <td>Mark</td>
                                            <td>Edit</td>
                                            
                                        </tr>
                                    </table>
                                </div><!--- end rec_s--->
                            </li>
                            <%
                            ArrayList allstd= Mark.StudentInfo.SearchStudent(search);
                            
                            for (int i=0;i<allstd.size();i++)
                            {
                             StudentInfo st = (StudentInfo) allstd.get(i);  
                          
                           int id= st.getCid();
                            String name =st.getCname();
                            String de =st.getDepartment();
                            String scalss= st.getLevel();
                            String ho =st.getTeacher();
                            String mark =st.getMark();
                            String sid =st.getSid();
                             String classNum =st.getNum();
                            %>
                            <li>
                                <div class="rec_s">
                                    <form action="updataMark.jsp">
					<table border="0" >
                                    	<tr>
                                            
                                            <td><%= sid %></td>
                                            <td><%= classNum %></td>
                                            <td> <%= name %></td>
                                            <td><%= de %></td>
                                            <td><%= scalss %></td>
                                            <td><%= ho %></td>
                                            <td><%= mark %></td>
                                            <td><input type=submit value=updata name=<%= id %> ></td>
                                            
                                        </tr>
                                    </table>
                                    </form>
                                </div><!--- end rec_s--->
                            </li>
                            <% } //end for %>
                        </ul>
                    </div><!--- end All_rec_s --->
                    <% } //end if %>
                </div><!--- end contant--->
                    <div id="contant">
                <div id="nav">
                  
            
                   <a href="HomePage.jsp"> Home </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="TeacherPage.jsp"> Teacher Page  </a> &nbsp; &nbsp;
                    
                 
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