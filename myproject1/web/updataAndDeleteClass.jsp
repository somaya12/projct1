
<%@page import="ClassServies.ClassInfo"%>
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
    response.sendRedirect("http://localhost:8085/Myproject1/ShowAllClasses.jsp");
       }
else
       {
%>
<html>
	<head>
        <title> Update Class information </title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css2/add.css" />
    
    </head>
    <body>
        
    	<div id="container">
       	  <div id="header">
            	
                 <img src="images/logo1.png" alt="logo" height="200" , width="200" />
                <h1> Coding School </h1>
              <br> <br> 
                <p> update Class information </p>
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
                    	<form name=f action="updataAndDeleteClass" >
                         Department : &nbsp;&nbsp;
                        <select name=dept>
                        <option value="ch"> department 
                          <%
                            String selected1="";
                            String selected2="";
                            String selected3="";
                            String selected4="";
                              if(st.getDepartment().indexOf("DataScience")!=-1)
                                        selected1="selected";
                            if(st.getDepartment().indexOf("CyberSecurity")!=-1)
                                        selected2="selected";
                            if(st.getDepartment().indexOf("WebDevelopment")!=-1)
                                        selected3="selected";
                            if(st.getDepartment().indexOf("IOT")!=-1)
                                        selected4="selected";
                            %>
                         <option value="DataScience"<%=selected1%> >Data Science
                        <option value="CyberSecurity"<%=selected2%>>Cyber Security
                            <option value="WebDevelopment"<%=selected3%>>Web Development
                                <option value="IOT"<%=selected4%>>IOT
                                    
                        </select> <font id=deptid class=valid1>*</font><br><br>  
                        
                     Class ID :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type=text name=xtext id=fn value="<%= st.getClassNum() %>"> 
                        <font id=fid class=valid1>*</font><br>  
                        
                        Class Name :&nbsp;&nbsp;
                        <input type=text name=ftext id=fn value="<%= st.getClassName() %>"> 
                        <font id=fid class=valid1>*</font><br>  
                         
                        level:<font id=classid class=valid1>*</font><br>
                       <%
                      selected1="";
                        selected2="";
                        selected3="";
                        selected4="";
                        if(st.getLevel().indexOf("First")!=-1)
                                    selected1="checked";
                        if(st.getLevel().indexOf("Second")!=-1)
                                    selected2="checked";
                       

                        %>
                        <input type=radio id=rad1 name=r1 value="First" <%=selected1%>>First &nbsp;&nbsp; 
                        <input type=radio id=rad2 name=r1 value="Second"<%=selected2%>>Second<br> 
                    
                        <br> 
                      
                             Teacher :<br>
                                
                          <input type="text" name=GPA id=GPA  value="<%=st.getTeacher()%> "  >
                          <font id=GPA class=valid1>*</font><br> 
                                    
                          <br> <br>
                        
                       
                        <input type=submit onclick="return validateAll()">   
                        
                          <br> <br> <br> 
                         
                              
               
            </div><!--- end warpper--->
        </div><!--- end container--->
        <div id="contant">
                <div id="nav">
                  
            
                   <a href="HomePage.jsp"> Home </a>  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
                    <a href="adminPage.jsp"> Admin Page </a> &nbsp; &nbsp;
                    
                 
                    </div><!--end nav--->
                </div><!--- end contant--->
                <div id="path">
                    <input type=password name=stext size="1"   value="<%= st.getCid() %>" readonly="  " > 
                </div>
                </form>
    </body>
</html>
<%
}
%>