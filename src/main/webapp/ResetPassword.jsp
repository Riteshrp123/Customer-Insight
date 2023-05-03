<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Reset Password</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.1/css/bootstrap.min.css">
  </head>
  <body>
    <div class="container my-5">
      <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
          <div class="card border-primary">
            <div class="card-header bg-primary text-white">
              <h1 class="text-center">Reset Password</h1>
            </div>
            <div class="card-body">
              <form action="ResetPassword" method="post">
                <div class="mb-3">
                  <label for="email" class="form-label">Email Address</label>
                  <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                  <label for="new-password" class="form-label">New Password</label>
                  <input type="password" class="form-control" id="new-password" name="password" required>
                </div>
                <div class="mb-3">
                  <label for="confirm-password" class="form-label">Confirm New Password</label>
                  <input type="password" class="form-control" id="confirm-password" name="confirmPassword" required>
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Reset Password</button>
                </div>
                <h2>${otp}</h2>
                       <h2>${EmailInput}</h2>
                       <h2>${password}</h2>
                          <h2>${wrongPass}</h2>
                       
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.1/js/bootstrap.min.js"></script>
  </body>
</html>
