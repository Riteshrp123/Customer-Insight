<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
.divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
/* .email-input{
  display: none;
} */
a{
color: white ;
text-decoration: none;
}
</style>
</head>
<body>
<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <form action="validateOtp" method="get">
          <!-- Email input -->
          <div class="form-outline mb-4">
          <c:set var="email" scope="session" value="${EmailInput}"/> 
            <input type="hidden" id="form1Example13" class="form-control form-control-lg email-input" name="email" value="${email}">
        
          </div>
          <div class="form-outline mb-4">
            <input type="text" id="form1Example13" class="form-control form-control-lg" name="otp" maxlength="6">
            <label class="form-label" for="form1Example13">OTP</label>
          </div>

          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-lg btn-block">Enter otp</button>
          <h2>${wrong}</h2>
        </form>
      </div>
    </div>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
    </body>
</html>