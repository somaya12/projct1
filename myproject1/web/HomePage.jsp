



<!DOCTYPE html>
<html>
	<head>
        <title>Home Page </title>
        <link rel="stylesheet" type="text/css" href="css2/style.css" />
        <script type="text/javascript" src="js/code1.js"></script>
	
    </head>
    <body>
    	<div id="container">
       	  <div id="header">
            <img src="images/logo1.png" alt="logo1" height="200" , width="200" ,  />
            <h1>  Coding School </h1>
               </div><!--- end header--->


 
           
          

<div class="dropdown">
  <button class="dropbtn">Login</button>
  <div class="dropdown-content">
    <a href="Studentlogin.jsp">Student Login</a>
    <a href="Teacherlogin.jsp">Teacher Login</a>
    <a href="Adminlogin.jsp">Admin Login</a>
    
  </div>
  &nbsp;&nbsp;
</div>
               <div class="dropdown1">
                   
  <button class="dropbtn">our Department</button>
  <div class="dropdown1-content">
    <a href="">Web Development</a>
    <a href="">Data Science</a>
    <a href="">Cyber Security</a>
     <a href="">IOT</a>
    
  </div>
</div>
               
        <br> <br> <br> <br> <br>         
   
 <div id="slider">

<div class="mySlides fade">
  
  
       <img src="images/5.jpg" alt="2"  height="500" , width="1000"/>
               
</div>

<div class="mySlides fade">
 <img src="images/3.jpg" alt="5"  height="600" , width="1000"  /> 
               
  
</div>
     <div class="mySlides fade">
 <img src="images/1.jpg" alt="2"  />
              
</div>
     <div class="mySlides fade">
  <img src="images/2.jpg" alt="2" /> 
               
</div>
     <div class="mySlides fade">
 <img src="images/8.jpg" alt="2"  height="600" , width="1000"/> 
                  
</div>
     <div class="mySlides fade">
<img src="images/4.jpg" alt="2"  height="600" , width="1000"/> 
                 
</div>
     <div class="mySlides fade">
   <img src="images/9.png" alt="2"  height="600" , width="1000"/> 
</div>


</div>
<br>

<div style="text-align:center">
  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>                                <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span>  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>


           
           
            
          
            
            
            <br> <br> <br> <br> <br> 
            
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