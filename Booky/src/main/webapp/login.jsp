<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">Booky</a>
        </div>
    </nav>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header text-center">
                        <h3>User login</h3>
                    </div>
                    <div class="card-body">
                        <form class="mb-4" method="post" action="LoginServlet">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                            </div>
                            <div class="form-group mb-4">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Login</button>
                        </form>
                        <div class="row mb-4">
                        	<div class="col-md-6 d-flex justify-content-center">
                        		<div class="form-check">
                        			<input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
                        			<label class="form-check-label" for="loginCheck">Remember me</label>
                        		</div> 		
                        	</div>
                        	<div class="col-md-6 d-flex justify-content-center">
                        		<a href="">Forgot password?</a>
                        	</div>
                        </div>
                    </div>         
                </div>
            </div>
        </div>
    </div>
   		
</body>
</html>