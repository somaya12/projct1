
<%@page import="StudentTable.ClassInfo"%>
<%@page import="java.util.Enumeration"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
Enumeration e=request.getParameterNames();
String submit=(String) e.nextElement();
ClassInfo st =new ClassInfo();
st.setCid(Integer.parseInt(submit));
st.fillstud();

if(request.getParameter(submit).equals("Delete"))
       {
    st.deleletSt();
    response.sendRedirect("http://localhost:8085/Myproject1/mytable.jsp");
       }
else
       {
%>
<html>
	<head>
        <title> add Class </title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css2/add.css" />
 
    </head>
    <body>
        
    	<div id="container">
       	  <div id="header">
            	
                 <img src="images/logo1.png" alt="logo" height="200" , width="200" />
                <h1> Coding School </h1>
              <br> <br>
              <p> <li> Check class information then submit to add  </p>
            </div><!--- end header--->
            
                
            <br> <br> <br> <br> <br> <br><br> <br> <br> 
               
                
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
                    	<form name=f action="MyTable" >  
                           
                        <br >
                            
                        Student ID : &nbsp;
                        <input type=text name=ytext id=sid value="${user.id}" > 
                        <font id=stuid class=valid1>*</font><br> 
                         <br>
                         Department : 
                        
                        <input type=text id=rad1 name=dept value=<%= st.getDepartment() %> readonly="">
                           
                        </select> <font id=deptid class=valid1>*</font><br>
                            Class ID :  &nbsp; &nbsp; &nbsp;
                        <input type=text name=xtext  id=fn value="<%= st.getClassNum() %>" readonly="  "> 
                        <font id=fid class=valid1 >*</font><br>  
                         
                        
                        Class Name : 
                        <input type=text name=ftext  id=fn value="<%= st.getClassName() %>" readonly="  "> 
                        <font id=fid class=valid1 >*</font><br>  
                       
                        
                       
                       
                      Level:&nbsp; &nbsp; &nbsp; 
                      <font id=classid class=valid1>*</font>
                    
                        <input type=text id=rad1 name=r1  value="<%= st.getLevel()%>"readonly="" >
                               <br>
                        
                       Teacher :&nbsp; &nbsp;
                                  
                         <input type="text" name=chh id=ch1 value="<%= st.getTeacher() %> "readonly= ""  >
                          <font id= ch1 class=valid1>*</font><br> 
                        
                        <br>
                       
                        <input type=submit onclick="return validateAll()"> 
                        
                       
                            
                        <br> 
                          <br> <br> <br> 
                           
			      </div><!--- end contant--->
                             </div><!--- end warpper--->
                              <div id="contant">
                <div id="nav">
                  
            
                   <a href="HomePage.jsp"> Home </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
              <a href="Studentpage.jsp"> Student Page </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="mytable.jsp"> My Table </a>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="searchAndAdd.jsp"> add Class </a>
                        </div><!--end nav--->
                </div><!--- end contant--->
                
                <div id="path">
                    <input type=password name=stext size="1"   value="<%= st.getCid() %>" readonly="  " > 
                </div>
 </form>
                 
                
               
          
        </div><!--- end container--->
       

    </body>
</html>
<%
}
%>