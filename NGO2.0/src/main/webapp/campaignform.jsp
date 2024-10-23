<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>HopeBridgeNGO</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

<!-- navbar starts-->

     <nav class="navbar navbar-expand-lg navbar-dark bg-custom">
  <a class="navbar-brand" href="index.jsp"><b>HopeBridgeNGO</b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</                                               span></a>
      </li>
     
      
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       Login
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="login.jsp">Donor</a>
          <a class="dropdown-item" href="loginOwner.jsp">Owner</a>
          
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Register
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="register.jsp">Donor</a>
          <a class="dropdown-item" href="registerOwner.jsp">Owner</a>
          
      </li>
      
      <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Dashboard</a></li>
			</ul>
    
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>   


<!-- navbar ends-->



	<div class="container">
   <div class="row mt-3">
      <div class="col-md-4 offset-md-4">
         <div class="card">
           <div class="card-header">
             <i class=""></i>
             <h5>Add a Campaign</h5>
        
           </div>
           
       
           <div class="card-body">
           <form action="registerServlet" method="post">
             <div class="form-group">
    <label for="exampleInputEmail1">Name of Campaign</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" name="cname">
    
    
     <div class="form-group">
    <label for="exampleInputEmail1">Description</label>
   
    <textarea class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter description" name="des" ></textarea>
    
   </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Fund to be Raised</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="enter fund amount" name="gamt">
  </div>
  
  <button type="submit" class="btn btn-primary btn-block badge-pill">Add</button>
</form>
           </div>
         </div>
      </div>
   </div>
</div>
</body>
</html>