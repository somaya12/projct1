<%-- 
    Document   : updataAndDelete
    Created on : Jun 29, 2012, 5:15:47 PM
    Author     : anas
--%>
<%@page import="StudentsServies.StudentInfo"%>
<%@page import="java.util.Enumeration"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Enumeration e=request.getParameterNames();
String submit=(String) e.nextElement();
StudentInfo st =new StudentInfo();
st.setSid(Integer.parseInt(submit));
st.fillstud();
st.fillPas();
if(request.getParameter(submit).equals("Delete"))
       {
    st.deleletSt();
    response.sendRedirect("http://localhost:8085/Myproject1/ShowAllStudent.jsp");
       }
else
       {
%>
<html>
	<head>
        <title> Update Student information </title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css2/add.css" />

    </head>
    <body>
        
    	<div id="container">
       	  <div id="header">
            	
                 <img src="images/logo1.png" alt="logo" height="200" , width="200" />
                <h1> Coding School </h1>
              <br> <br> 
                <p> add a new student </p>
            </div><!--- end header--->
            
                
            <br> <br> <br> <br> <br> <br><br> <br> <br> <br> <br> 
               
                
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
                    	<form name=f action="updateS" >
                        Student ID : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type=text name=stext id=sid value="<%= st.getSid()%>" readonly="" > 
                        <font id=stuid class=valid1>*</font><br>  
                        
                        Full Name : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type=text name=ftext id=fn value="<%= st.getfullname() %>"> 
                        <font id=fid class=valid1>*</font><br>  
                        Choose Your Department : 
                        <select name=dept>
                        <option value="ch">Choose  department 
                          <%
                            String selected1="";
                            String selected2="";
                            String selected3="";
                            String selected4="";
                              if(st.getDepartment().indexOf("Data Science")!=-1)
                                        selected1="selected";
                            if(st.getDepartment().indexOf("Cyber Security")!=-1)
                                        selected2="selected";
                            if(st.getDepartment().indexOf("Web Development")!=-1)
                                        selected3="selected";
                            if(st.getDepartment().indexOf("IOT")!=-1)
                                        selected4="selected";
                            %>
                         <option value="Data Science"<%=selected1%> >Data Science
                        <option value="Cyber Security"<%=selected2%>>Cyber Security
                            <option value="Web Development"<%=selected3%>>Web Development
                                <option value="IOT"<%=selected4%>>IOT
                                    
                        </select> <font id=deptid class=valid1>*</font><br><br>
                        Email:<font id=classid class=valid1>*</font>
                        &nbsp;
                        <input type=text name=r id=classid value="<%= st.getemail() %>"> 
                        
                        <br> 
                       <br> 
                          
                        
                    
                        <input type=submit onclick="return validateAll()">   
                        </form>
                          <br> <br> <br> 
                  
                    </div><!--- end reg--->
			      </div><!--- end contant--->
                              
               
            </div><!--- end warpper--->
        </div><!--- end container--->
    </body>
</html>
<%
}
%>