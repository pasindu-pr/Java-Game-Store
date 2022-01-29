<!DOCTYPE html>
<%

//Scriptlets
String gameid = request.getParameter("gameid");
String gameName = request.getParameter("gameName");
String image = request.getParameter("image");
String description = request.getParameter("description");
String developer = request.getParameter("developer");
String publisher = request.getParameter("publisher");
String releaseDate = request.getParameter("releaseDate");
String platform = request.getParameter("platform");
String type = request.getParameter("type");
String androidVersion = request.getParameter("androidVersion");	
String iosVersion = request.getParameter("iosVersion");	
String mobileReleasedDate = request.getParameter("mobileReleasedDate");	

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Game</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
      integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Nunito&family=Ubuntu&display=swap"
      rel="stylesheet"
    />
  <link rel="stylesheet" href="styles/addgame.css" />
  </head>
  <body>
    <div class="nav-bar-area">
      <nav>
        <div>
          <h1>LOGO</h1>
        </div>

        <div>
          <ul>
          <a href="index.jsp">
          	<li>Store</li>
          </a>
            <li>FAQ</li>
            <li>News</li>
            <li>Pricing</li>
          </ul>
        </div>

        <div class="nav-account">
          <i class="fas fa-user-tie"></i>
          <p>Your account</p>
        </div>
      </nav>
    </div>
    <div class="page-container">
      <div class="form-container" style="padding: 20px 0"> 
        <form action="GameUpdateServerlet" method="post">
         
          <h1>Update Game <%= gameName %> </h1>

          <div class="input">
            <input type="text" placeholder="Game Name" name="gameid" value="<%= gameid %>" readonly />
          </div>
          
          <div class="input">
            <input type="text" placeholder="Game Name" name="gamename" value="<%= gameName %>"  />
          </div>

          <div class="input">
            <input type="text" placeholder="Image" name="image" value="<%= image %>" />
          </div>

          <div class="input">
            <input type="text" name="developer"  placeholder="Developer" value="<%= developer %>" />
          </div>

          <div class="input">
            <input type="text" name="publisher" placeholder="Publisher" value="<%= publisher %>"   />
          </div>

          <div class="input">
            <input
              type="date"
              name="releasedate"
              placeholder="Release Date"
              value="<%= releaseDate %>" 
            />
          </div>

          <div class="input">
            <input type="text" name="platform" placeholder="Platform" value="<%= platform %>"  />
          </div>
          
 		  <c:if test="${param.type == 'Mobile'}">
          
          		<div class="input">
            		<input type="text" name="androidVersion" placeholder="Platform" value="<%= androidVersion %>"  />
          		</div>
          
          
          		<div class="input">
            		<input type="text" name="iosVersion" placeholder="Platform" value="<%= iosVersion %>"  />
          		</div>
          		
          		<div class="input">
            		<input
              			type="date"
              			name="mobileReleasedDate"
              			placeholder="Release Date"
              			value="<%= mobileReleasedDate %>" 
            		/>
          		</div>
          		
     	   </c:if>
          
		<div>
          <textarea name="description" placeholder="Description"><%= description %> </textarea>
		</div>

          <button>Update</button>
        </form>
      </div>
    </div>
    <div class="footer-area">
      <footer class="footer">
        <div class="icons">
          <a href="#"><i class="fab fa-facebook"></i></a>
          <a href="#"><i class="fab fa-linkedin"></i></a>
          <a href="#"><i class="fab fa-instagram"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <p class="company-name">Gamestore &copy; 2021, ALL Rights Reserved</p>
        </div>
      </footer>
    </div>
  </body>
</html>
