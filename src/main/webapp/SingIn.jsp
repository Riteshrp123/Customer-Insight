<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="singin.css"> -->

    <style>
    ul{
      list-style:none;
      height: 100px;
       padding: 0;
       margin: 0;
       background-color: blueviolet;
        /* position: absolute;
       bottom: 0;
       width: 100%;  */
    }  
    li{
       display:inline;
       padding: 5px;
       /*
       1px = ?
       1ex = ?
       */
    }   
   li a{
       text-decoration: none;

       color: aliceblue;

    }        
  body{
   margin: 0;
   padding: 0;
   background-color: skyblue;
  }
  /* Pseudo selector */
li :hover{
   background-color: black;
}
/* .footer{
   text-align: center;
   height: 100px;
   color: rgb(15, 8, 4);
   background-color: rgb(209, 0, 157); */

form{
   text-align: center;
}
 /* p{ 
   background-color: chocolate;
   height: 100px;
}  */
/* td,tr:nth-child(odd){
   background-color: darkred;
} */
/* td{
   background-color: blue;
} */
/*  */
input[type="email"]{
   background-color: white;
}
/* tr tbody{
   color: blue; */

.singin{
   float: right;
    padding: 30px;
    font-size: 25px;

}
.singup{
   float:right;
   padding: 30px;
   font-size: 23px;
}
/*  larger screen size - display : inline
smaller screen size - display : block
*/
 @media only screen and (max-width: 1000px) {
   li{
       display: block;
       padding: 10px;
       background-color: black;
   }
   .singin{
       float: left;
       padding: 20%;
   }
   .singup{
      float: left;
   }
} 
 @media only screen and (max-width: 2000px) {
    body{
       background-color: white;
   }
}  
     form {
  border: 3px solid #f1f1f1;
}
     form {
  border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
  width: 40%;
  border-radius: 50%;
}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* The "Forgot password" text */
span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }
  .cancelbtn {
    width: 100%;
  }
}

    </style>
</head>
    <body>
    <form action=signin method="post">
        <!-- <div class="imgcontainer">
          <img src="img_avatar2.png" alt="Avatar" class="avatar">
        </div> -->
      <h2>${wrongCredentials}</h2>
        <div class="container">
          <label for="username"><b>UserId</b></label>
          <input type="text" placeholder="EmailId" name="email" required>
      
          <label for="password"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="password" required>
      
          <button type="submit">Login</button>
          <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
          </label>
        </div>
      
        <div class="container" style="background-color:#f1f1f1">
          <button type="button" class="cancelbtn">Cancel</button>
          <span class="password">Forgot <a href="ForgotPassword.jsp">password?</a></span>
        </div>
      </form;form>
      <table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${password}</td>
			<td style="font-style: italic; color: red;">${loginfailed}</td>
		</tr>
	</table>
      
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
    </body>
</html>
