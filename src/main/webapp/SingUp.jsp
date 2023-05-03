<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--  <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="save" method="post">
  <input type="text" placeholder="firstName" name="firstName">
  <input type="text" placeholder="lastName" name="lastName">
  <input type="text" placeholder="email" name="email">
  <input type="text" placeholder=password name="password">
  <input type="text" placeholder=confirmPassword name="confirmPassword">
  <input type="date" placeholder=dateOfBirth name="dateOfBirth">
  <legend>Choose your gender:</legend>
        <label for="male">Male</label>
        <input type="radio" name="gender" id="male" value="male" checked>
        <label for="female">Female</label>
        <input type="radio" name="gender" id="female" value="female">
  <button type="submit">save</button>
   </form>  -->
 <!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="singin.html"> -->
    <!-- <link rel="stylesheet" href="navigation.css"> -->


    <style>
           nav{
      height: 100px;
   }
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
       background-color: rgb(128, 0, 19);
   }
}  
    .gradient-custom-3 {
        /* fallback for old browsers */
        background: #84fab0;
        
        /* Chrome 10-25, Safari 5.1-6 */
        background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));
        
        /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5))
        }
        .gradient-custom-4 {
        /* fallback for old browsers */
        background: #84fab0;
        
        /* Chrome 10-25, Safari 5.1-6 */
        background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));
        
        /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
        }
        .ul{
            padding: 100px;
            height: 100px;
        }
    </style>
    </head>
        <body>
          <ul>
            <li><a href="SingUp.jsp" class="singup">SingUp</a></li>
            <li><a href="SingIn.jsp" class="singin">SingIn</a></li>
          </ul>
    <section>
  <!-- style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');"> -->
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Customer Registration</h2>

              <form action="save" method="post">

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example1cg" name="firstName" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example1cg">First Name</label>
                </div>
                <div class="form-outline mb-4">
                    <input type="text" id="form3Example1cg" name="lastName" class="form-control form-control-lg" />
                    <label class="form-label" for="form3Example1cg">Last Name</label>
                  </div>

                <div class="form-outline mb-4">
                  <input type="email" id="form3Example3cg" name="email" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example3cg">Your Email</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" id="form3Example4cg" name="password" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example4cg">Password</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="password" id="form3Example4cdg" name="confirmPassword" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example4cdg">Confirm your password</label>
                </div>
                <div class="form-outline mb-4">
                    <input class="form-control" type="date" name="DateOfBirth" placeholder="DateOfBirth" required>
                </div>
                
                <div class="form-outline mb-4">

                  <div class="col-md-12 mt-3">
                            <label class="mb-3 mr-1" for="gender">Gender: </label>

                            <input type="radio" class="btn-check" name="gender" id="male" autocomplete="off" required>
                            <label class="btn btn-sm btn-outline-secondary" for="male">Male</label>

                            <input type="radio" class="btn-check" name="gender" id="female" autocomplete="off" required>
                            <label class="btn btn-sm btn-outline-secondary" for="female">Female</label>

                            <input type="radio" class="btn-check" name="gender" id="secret" autocomplete="off" required>
                            <label class="btn btn-sm btn-outline-secondary" for="secret">Secret</label>
                               <div class="valid-feedback mv-up">You selected a gender!</div>
                                <div class="invalid-feedback mv-up">Please select a gender!</div>
                            </div>
                            </div>
                <div class="form-check d-flex justify-content-center mb-5">
                  <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />
                  <label class="form-check-label" for="form2Example3g">
                    I confirm that all data are correct<a href="#!" class="text-body"><u>Terms of service</u></a>
                  </label>
                </div>

                <div class="d-flex justify-content-center">
                    <button id="submit" type="submit" class="btn btn-primary">Register</button>
                </div>
                <p class="text-center">Have an account? <a href="">Log In</a> </p>
                <!-- <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="#!"
                    class="fw-bold text-body"><u>Login here</u></a></p> -->

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</body>
</html>

  