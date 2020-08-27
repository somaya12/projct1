
<%@page import="Mark.StudentInfo"%>
<%@page import="java.util.Enumeration"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Enumeration e=request.getParameterNames();
String submit=(String) e.nextElement();
StudentInfo st =new StudentInfo();
st.setCid(Integer.parseInt(submit));
st.fillstud();
if(request.getParameter(submit).equals("Delete"))
       {
    st.deleletSt();
    response.sendRedirect("http://localhost:8085/Coding/ShowAll.jsp");
       }
else
       {
%>
<html>
	<head>
        <title>update Marks </title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css2/add.css" />
  
    </head>
    <body>
        
    	<div id="container">
       	  <div id="header">
            	
                 <img src="images/logo1.png" alt="logo" height="100" , width="100" />
                <h1> Coding School </h1>
              
                <p> add a new class </p>
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
                    	<form name=f action="updataMark" >
                      
                           teacher  ID : &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type=text name=Ttext id=sid value="${user.id}" readonly=""> 
                        
                        <font id=stuid class=valid1>*</font><br>
                            Student  ID : &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type=text name=ytext id=sid value="<%= st.getSid()%>" readonly=""> 
                        <font id=stuid class=valid1>*</font><br> 
                        
                      
                        
                        Class Name : &nbsp;&nbsp;
                        <input type=text name=ftext id=fn value="<%= st.getCname()%>"readonly=""> 
                        <font id=fid class=valid1>*</font><br>  
                        Department : &nbsp;&nbsp;
                        
                        <input type=text id=rad1 name=dept value="<%= st.getDepartment() %>"readonly="">
                           
                        </select> <font id=deptid class=valid1>*</font><br><br>
                        Level:<font id=classid class=valid1>*</font>
                    
                        <input type=text id=rad1 name=r1 value="<%= st.getLevel()%>"readonly="">
                               <br>
                        
                       Teacher :
                        <input type=text name=chh id=ch1 value="<%= st.getTeacher()%>"readonly=""> 
                        <font id=ch1 class=valid1>*</font><br>  
 Mark : &nbsp; &nbsp;
 <input type=text name=chhh id=ch2 size="7" value="<%= st.getMark()%>"> 
 <font id=ch2 class=valid1>*</font><br>  <br>

                        
                        <input type=submit onclick="return validateAll()">   
                       
                    </div><!--- end reg--->
		
            </div><!--- end warpper--->
        </div><!--- end container--->
         <div id="path">
                    <input type=password name=stext size="1"   value="<%= st.getCid() %>" readonly="  " > 
                </div>
                 </form>
    </body>
</html>
<%
}
%>