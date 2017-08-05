<?php
  require 'core.inc.php';
  require 'includes/config.php';
   if(loggedin()){ 
    ?>
      <html lang="en">
      <head>
        <title>Upaj</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="./js/jquery.min.js"></script>
      <script src="./js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="./css/bootstrap.min.css">

      <script type="text/javascript" src="./queries.js"></script>
      </head>
      <body style="background-color:#6666ff">
        <div class="wrappers">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>                        
                </button>
                <a class="navbar-brand" href="main.php">Upaj</a>
              </div>
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                  <li ><a href="main.php">Home</a></li>
                  <li><a href="done.php">Done</a></li>
                  <li><a href="spam.php">Spam</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li class="active"><a href="aboutus.php">About Us</a></li>
                  <li><a href="logout.php">Log out</a></li>
                </ul>
              </div>
            </div>
          </nav>
      <center><img src="includes/images/upaj_logo.jpg" class="img-rounded" alt="Upaj" width="60%" height="auto" style="max-height:260px;"></center>
      <center>
      <div class="container-fluid">
      
      <div class="col-md-12" style="color:#FF8833">
      <h3>Upaj ushers the advent of a new era by bridging the gap between two revolutionary ideas in India, the "Digital India" initiative and the "Krishi Kalyan". Upaj is a step towards achieving the vision of the Krishi/Farmer Kalyan which is to accomplish a "Helthy Crop and Happy Farmer" using technology.</h3>
      </div>
      <div class="col-md-12" style="color:#FFFFFF">
        <h3>We at Upaj provide an effective platform where users can report the problems related to decreasing health of crop and farming releted issues to Government authorities. It provides key features like request for proper guidance and solution. The problems are immediately reported to the concerned authorities who initiate further action for redressal of the problems.</h3>
      </div>
      <div class="col-md-12">
        <h3 style="color:#0F6D06"> Upaj promotes Helthy crop and brings happines to farmers through a mobile application which enables users to send pictures of crop, fruits releted problems to a website which is handled by the government authorities. The effect would be holistic development of the farmers. Smart Farming/Krishi Kalyan is the mission, Upaj is the channel.</h3>
      </div>
    
      </div>
      </center>
      </div>
      </body>
      </html>
      <?php 
      include './footer.php';
      ?>
  <?php }?>
  <?php if(!loggedin()){ ?>
    <center>
      <h3>You can't access without Loggedin...! </h3>
      <input type="button" onclick="location.href='index.php';" value="Go to Login window" /></center>
    
  <?php } ?>