<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Mobile Game</title>
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
        <form action="AddGameServerlet" method="post">
          <h1>Add New Mobile Game</h1>
          
          <c:if test="${validateError}">
          	<p class="error-msg">Please fillout all the required fields </p>
          </c:if> 
          
          <div class="input">
            <input type="text" placeholder="Game Name" name="gamename"   />
          </div>

          <div class="input">
            <input type="text" placeholder="Image" name="image"  />
          </div>

          <div class="input">
            <input type="text" name="developer"  placeholder="Developer"  />
          </div>

          <div class="input">
            <input type="text" name="publisher" placeholder="Publisher"   />
          </div>

          <div class="input">
            <input
              type="date"
              name="releasedate"
              placeholder="Release Date"
              id=""
            />
          </div>

          <div class="input">
            <input type="text" name="platform" placeholder="Platform" value="Mobile" readonly />
          </div>
          
          <div class="input">
            <input type="text" name="androidVersion" placeholder="Android Version Required" />
          </div>
          
          <div class="input">
            <input type="text" name="iosVersion" placeholder="IOS Version Required" />
          </div>

          <textarea name="description" placeholder="Description"></textarea>

          <div class="input">
           <input type="date" name="mobileReleaseDate" placeholder="Mobile Release Date" />
          </div>

          <button>Submit</button>
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
