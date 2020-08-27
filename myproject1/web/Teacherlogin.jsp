<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    
<meta charset="utf-8">
<title>Teacher login</title>
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
             <p>Teacher login</p>
            </div><!--- end header--->
            
            <br> <br> <br> <br> <br> <br>  <br> <br> <br> <br> 
        
         <div id="contant">
                    
                 
                      
                    <div id="reg">
                    	 <form action="login5" method="post">
                 <label for="id">Teacher Id:</label>
            <input name="id" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br> 
            <input type=submit >
            
                                    
                         
                        </form>
                    </div><!--- end reg--->
			      </div><!--- end contant--->
                   
           
        </form>
    </div>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                id: {
                    required: true,
                   id: true
                },
         
                password: "required",
            },
             
            messages: {
                id: {
                    required: "Please enter id",
                    id: "Please enter a valid id address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>