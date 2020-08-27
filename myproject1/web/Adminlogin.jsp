<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
   
<title>Admin login</title>
</head>
	<head>
        
        
        <link rel="stylesheet" type="text/css" href="css2/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css2/add.css" />

	
    </head>
   </head>
<body>
    
    	<div id="container">
       	  <div id="header">
            <img src="images/logo1.png" alt="logo" height="200" , width="200"  />
            <h1>&nbsp;  Coding School </h1>
             <p>Admin login</p>
            </div><!--- end header--->
            
            <br> <br> <br> <br> <br> <br>  <br> <br> <br> <br> 
        
    
                <div id="contant">
                    
                 
                      
                    <div id="reg">
                    	 <form action="login2" method="post">
                 <label for="Aid">Admin Id:</label>
            <input name="Aid" size="30" />
            <br><br>
            <label for="Apassword">Password:</label>
            <input type="password" name="Apassword" size="30" />
            <br>${message}
            <br><br> 
            <input type=submit >
            
                                    
                         
                        </form>
                    </div><!--- end reg--->
			      </div><!--- end contant--->
               
     
             
        </div><!--- end container--->
    </body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                Aid: {
                    required: true,
                    Aid: true
                },
         
                Apassword: "required",
            },
             
            messages: {
                Aid: {
                    required: "Please enter email",
                    Aid: "Please enter a valid email address"
                },
                 
                Apassword: "Please enter password"
            }
        });
 
    });
</script>
</html>