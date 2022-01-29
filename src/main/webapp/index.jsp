<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Homepage</title>
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
    
    
    <jsp:include page="/HomePageServerlet" flush="true" />
    <link rel="stylesheet" href="./styles/home.css" />
    <script src="./scripts/slider.js" async></script>
    <script src="./scripts/index.js"></script> 
  </head>
  <body>
    <div class="slider">
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
      <div class="slider-inner">
        <div class="slide" data-slide="1">
          <!-- <div class="content" style="background-color: #ff4d4d"></div> -->
          <img src="./images/slider/sherlock_holmes.jpg" class="content" />
        </div>

        <div class="slide" data-slide="2">
          <img src="./images/slider/girl_game.webp" class="content" />
        </div>

        <div class="slide" data-slide="3">
          <img src="./images/slider/car_race.jpg" class="content" />
        </div>

        <div class="slide" data-slide="4">
          <img src="./images/slider/fortnite.jpg" class="content" />
        </div>
      </div>

      <div class="indicators">
        <div class="indicator" data-slide="1" active></div>
        <div class="indicator" data-slide="2"></div>
        <div class="indicator" data-slide="3"></div>
        <div class="indicator" data-slide="4"></div>
      </div>

      <div class="arrows">
        <div class="arrow-prev">
          <i class="fas fa-chevron-left"></i>
        </div>
        <div class="arrow-next">
          <i class="fas fa-chevron-right"></i>
        </div>
      </div>
    </div>

    <div class="page-container">
      <div class="games-area">
        <div class="games-area-headline">
          <h1>PC GAMES</h1>
          <p>Buy your favourite games for your pc on the go</p>
        </div>


        <div class="game-card-area">
        
		<c:forEach items="${pcgames}" var="pcgames">
          	<div class="game-card">
            	<div class="game-card-image">
              		<img src="${pcgames.image}" />
            	</div>

            	<h3> ${pcgames.gameName} </h3>
            	<p>
					${pcgames.description}
            	</p>
            	<a href="GameDetailsServerlet?id=${pcgames.gameID}">
            		<button>Go to Game <i class="fas fa-arrow-right wish-icon"></i></button>
            	</a>
          	</div>	
		</c:forEach>
		
        </div>
      </div>
      
      
      <div class="games-area">
        <div class="games-area-headline">
          <h1>MOBILE GAMES</h1>
          <p>Buy your mobile games on the go</p>
        </div>


        <div class="game-card-area">
        
		<c:forEach items="${mobilegames}" var="mobilegames">
          	<div class="game-card">
            	<div class="game-card-image">
              		<img src="${mobilegames.image}" />
            	</div>

            	<h3> ${mobilegames.gameName} </h3>
            	<p>
					${mobilegames.description}
            	</p>
            	<a href="GameDetailsServerlet?id=${mobilegames.gameID}">
            		<button>Show Description <i class="fas fa-arrow-right wish-icon"></i></button>
            	</a>
          	</div>	
		</c:forEach>
		
        </div>
      </div>
      
      
    </div>

    <div class="footer-area">
      <!-- <footer>
        <ul>
          <li>About us</li>
          <li>Contact us</li>
          <li>Store</li>
          <li>Sitemap</li>
        </ul>


        <ul>
            <li>Pricing</li>
            <li>Support</li>
            <li>Payment & Refunds</li>
            <li>  </li>
          </ul>
      </footer> -->

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
