<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Game Details of ${game.gameName}</title>
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
    <link rel="stylesheet" href="styles/home.css" />
    
    <c:set var="game" value="${game}"></c:set>
    
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

    <div class="gameinner-page-content">
      <div class="gameinner-details">
        <h1 class="game-inner-headline"> ${game.gameName} </h1>

        <div class="game-detail-image">
          <img src="${game.image}" alt="" />
        </div>

        <p class="desc"> ${game.description} </p>
      </div>
      <div class="game-subscribe-area">
        <div class="buttons-area">
        <a href="Game.zip" download>
          <div class="button">
            <button class="subcribe-btn">Download Game <i class="fas fa-download wish-icon"></i></button>
          </div>
 
        </a>

         <!--  <div class="button">
            <button
              style="background: rgba(205, 205, 205, 0.06)"
              class="subcribe-btn"
            >
              Add to Wishlist  <i class="fas fa-heart wish-icon"></i>
            </button>
          </div>  -->
         
 
			<c:if test="${sessionScope.isAdmin == true}">
          		<div class="button">
          			<c:url value="updategame.jsp" var="updateGame">
          				<c:param name="gameid" value="${game.gameID}" />
          				<c:param name="gameName" value="${game.gameName}" />
          				<c:param name="image" value="${game.image}" />
          				<c:param name="description" value="${game.description}" />
          				<c:param name="developer" value="${game.developer}" />
          				<c:param name="publisher" value="${game.publisher}" />
          				<c:param name="releaseDate" value="${game.releaseDate}" />
          				<c:param name="platform" value="${game.platform}" />
          				<c:param name="type" value="${game.type}" />
          				<c:if test="${game.type == 'Mobile'}">
          					<c:param name="androidVersion" value="${game.androidVersion}" />
          					<c:param name="iosVersion" value="${game.iosVersion}" />
          					<c:param name="mobileReleasedDate" value="${game.mobileReleasedDate}" />
          				</c:if>
          			</c:url>
          			<a href="${updateGame}">
            			<button
              				style="background: rgba(205, 205, 205, 0.06)"
              				class="subcribe-btn"
            				>
              				Edit Game <i class="fas fa-edit wish-icon"></i>
            			</button>
            		</a>
          		</div>
          
          		<div class="button">
          			<c:url value="DeleteServerlet" var="deleteGame">
          				<c:param name="id" value="${game.gameID}" />
          			</c:url>
          			<form method="post" action="${deleteGame}">
              			<button
              					style="background: rgba(205, 205, 205, 0.06)"
              					class="subcribe-btn"
            					>
              				Delete Game <i class="far fa-trash-alt wish-icon"></i>
            			</button>        			
          			</form>
          		</div>
			</c:if>          
        </div>
        


        <div class="specs-area">
          <div class="spec">
            <p>Developer : ${game.developer}</p>
          </div>

          <div class="spec">
            <p>Publisher : ${game.publisher}</p>
          </div>

          <div class="spec">
            <p>Release Date : ${game.releaseDate}</p>
          </div>

          <div class="spec">
            <p>Platform :${game.platform}</p>
          </div>
          
           <div class="spec">
            <p>Platform :${game.type}</p>
          </div>
          
 		  <c:if test="${game.type == 'Mobile'}">
          		<div class="spec">
            		<p>Android Version Required :${game.androidVersion}</p>
          		</div>
          		
          		<div class="spec">
            		<p>IOS Version Required :${game.iosVersion}</p>
          		</div>
          		
          		<div class="spec">
            		<p>Mobile Released Date :${game.mobileReleasedDate}</p>
          		</div>
     	   </c:if>
     	   
        </div>
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
