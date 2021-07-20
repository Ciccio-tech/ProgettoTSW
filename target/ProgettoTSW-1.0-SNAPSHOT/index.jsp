<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Theme Made By www.w3schools.com - No Copyright -->
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        body {
            font: 400 15px/1.8 Lato, sans-serif;
            color: #777;
        }
        h3, h4 {
            margin: 10px 0 30px 0;
            letter-spacing: 10px;
            font-size: 20px;
            color: #111;
        }
        .container {
            padding: 80px 120px;
        }
        .person {
            border: 10px solid transparent;
            margin-bottom: 25px;
            width: 80%;
            height: 80%;
            opacity: 0.7;
        }
        .person:hover {
            border-color: #f1f1f1;
        }
        .navbar-toggle {
            margin-top: 18px;
        }
        .navbar-brand {
            float: left;
            height: 70px;
            padding: 7px 7px;
            font-size: 20px;
            line-height: 20px;
        }
        .navbar-nav>li>a {
            padding-top: 25px;
            padding-bottom: 15px;
        }
        .carousel-inner img {
            /* -webkit-filter: grayscale(90%);
             filter: grayscale(90%);  make all photos black and white */
            width: 100%; /* Set width to 100% */
            margin: auto;
        }
        .carousel-caption h3 {
            color: #fff !important;
        }
        @media (max-width: 600px) {
            .carousel-caption {
                display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
            }
        }
        .bg-1 {
            background: #2d2d30;
            color: #bdbdbd;
        }
        .bg-1 h3 {color: #fff;}
        .bg-1 p {font-style: italic;}
        .list-group-item:first-child {
            border-top-right-radius: 0;
            border-top-left-radius: 0;
        }
        .list-group-item:last-child {
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .thumbnail {
            padding: 0 0 15px 0;
            border: none;
            border-radius: 0;
        }
        .thumbnail p {
            margin-top: 15px;
            color: #555;
        }
        .btn {
            padding: 10px 20px;
            background-color: #333;
            color: #f1f1f1;
            border-radius: 0;
            transition: .2s;
        }
        .btn:hover, .btn:focus {
            border: 1px solid #333;
            background-color: #fff;
            color: #000;
        }
        .modal-header, h4, .close {
            background-color: #333;
            color: #fff !important;
            text-align: center;
            font-size: 30px;
        }
        .modal-header, .modal-body {
            padding: 40px 50px;
        }
        .nav-tabs li a {
            color: #777;
        }

        .navbar {
            font-family: Montserrat, sans-serif;
            margin-bottom: 0;
            background-color: #2d2d30;
            border: 0;
            font-size: 11px !important;
            letter-spacing: 4px;
            opacity: 0.9;
        }
        .navbar li a, .navbar .navbar-brand {
            color: #d5d5d5 !important;
        }
        .navbar-nav li a:hover {
            color: #fff !important;
        }

        .navbar-nav li.active a {
            color: #fff !important;
            background-color: #29292c !important;
        }
        .navbar-default .navbar-toggle {
            border-color: transparent;
        }
        .open .dropdown-toggle {
            color: #fff;
            background-color: #555 !important;
        }
        .dropdown-menu li a {
            color: #000 !important;
        }
        .dropdown-menu li a:hover {
            background-color: lightseagreen !important;
        }
        footer {
            background-color: #2d2d30;
            color: #f5f5f5;
            padding: 32px;
        }
        footer a {
            color: #f5f5f5;
        }
        footer a:hover {
            color: #777;
            text-decoration: none;
        }
        .form-control {
            border-radius: 0;
        }
        textarea {
            resize: none;
        }

        video{
            position: center;
        }
    </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<%@include file = "header.jsp" %>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="images/Slider/foto.jpg" alt="FotoSlider1" width="1200" height="600">
            <div class="carousel-caption">
            </div>
        </div>

        <div class="item">
            <img src="images/Slider/foto3.jpg" alt="FotoSlider2" width="1200" height="600">
            <div class="carousel-caption">
            </div>
        </div>

        <div class="item">
            <img src="images/Slider/foto5.jpg" alt="FotoSlider3" width="1200" height="600">
            <div class="carousel-caption">
            </div>
        </div>
    </div>


    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
    <h3> Chi siamo? </h3>
    <p>Siamo un ragazzo e una ragazza con la passione per la fotografia</p>
    <br>
    <div class="row">
        <h3> Cosa dicono di noi:</h3>
        <div class="col-sm-4">
            <p class="text-center"><strong>Elena</strong></p><br>
            <a href="#demo" data-toggle="collapse">
                <img src="images/FotoProdotti/CanonG9.jpg" class="img-circle person" alt="Spedizione" width="255" height="255">
            </a>
            <div id="demo" class="collapse">
                <p>Spedizione Puntuale, come sempre!</p>
            </div>
        </div>
        <div class="col-sm-4">
            <p class="text-center"><strong>Jin-Sung</strong></p><br>
            <a href="#demo2" data-toggle="collapse">
                <img  src="images/FotoProdotti/SigmaNikon50mm.jpg" class="img-circle person" alt="Servizio clienti" width="255" height="255">
            </a>
            <div id="demo2" class="collapse">
                <p>Gentili e cordiali</p>
            </div>
        </div>
        <div class="col-sm-4">
            <p class="text-center"><strong>Giovanni</strong></p><br>
            <a href="#demo3" data-toggle="collapse">
                <img src="images/FotoProdotti/Sigma100-400mmF5-6-3.jpg" class="img-circle person" alt="Prodotti" width="255" height="255">
            </a>
            <div id="demo3" class="collapse">
                <p>Prdootti di ottima qualità</p>
                <p>e prezzi scontati!</p>
            </div>
        </div>
    </div>
</div>

<!-- Container (Alcuni prodotti) -->
<div id="tour" class="bg-1">
    <div class="container">
        <h4>Preferiti dai Clienti:</h4>
        <div class="row text-center">
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="images/FotoProdotti/CanonG9.jpg" alt="CanonG9" width="400" height="300">
                    <p><strong>CanonG9</strong></p>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="images/FotoProdotti/FujifilmNstax.jpg" alt="FujifilmNstax" width="400" height="300">
                    <p><strong>FujifilmNstax</strong></p>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="images/FotoProdotti/Nikond610.jpg" alt="Nikond610" width="400" height="300">
                    <p><strong>Nikond610</strong></p>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal-->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Tickets</h4>
                </div>
                <div class="modal-body">
                    <form role="form">
                        <div class="form-group">
                            <label for="psw"><span class="glyphicon glyphicon-shopping-cart"></span> Tickets, $23 per person</label>
                            <input type="number" class="form-control" id="psw" placeholder="How many?">
                        </div>
                        <div class="form-group">
                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Send To</label>
                            <input type="text" class="form-control" id="usrname" placeholder="Enter email">
                        </div>
                        <button type="submit" class="btn btn-block">Pay
                            <span class="glyphicon glyphicon-ok"></span>
                        </button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span> Cancel
                    </button>
                    <p>Need <a href="#">help?</a></p>
                </div>
            </div>
        </div>
    </div>
</div>


<div id="video">
    <video width="500" height="450" controls>
        <source src="images/Video/Nikon.mp4" type="video/mp4">
    </video>
</div>


<!-- Container (Contact Section) -->
<div id="contact"  class="container">
    <h3 class="text-center">Contact</h3>

    <div class="row">
        <div class="col-md-4">
            <p></p>
            <p><span class="glyphicon glyphicon-map-marker">Position</span></p>
            <p><span class="glyphicon glyphicon-phone"></span>Phone: +00 1515151515</p>
            <p><span class="glyphicon glyphicon-envelope"></span>Email: mail@mail.com</p>
        </div>
        <!--  <div class="col-md-8">
           <div class="row">
               <div class="col-sm-6 form-group">
                   <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
               </div>
               <div class="col-sm-6 form-group">
                   <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
               </div>
           </div>
           <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
           <br>
           <div class="row">
               <div class="col-md-12 form-group">
                   <button class="btn pull-right" type="submit">Send</button>
               </div>
           </div>
       </div>
   </div>
   <br>
   <h3 class="text-center">From The Blog</h3>
   <ul class="nav nav-tabs">
       <li class="active"><a data-toggle="tab" href="#home">Mike</a></li>
       <li><a data-toggle="tab" href="#menu1">Chandler</a></li>
       <li><a data-toggle="tab" href="#menu2">Peter</a></li>
   </ul>

   <div class="tab-content">
       <div id="home" class="tab-pane fade in active">
           <h2>Mike Ross, Manager</h2>
           <p>Man, we've been on the road for some time now. Looking forward to lorem ipsum.</p>
       </div>
       <div id="menu1" class="tab-pane fade">
           <h2>Chandler Bing, Guitarist</h2>
           <p>Always a pleasure people! Hope you enjoyed it as much as I did. Could I BE.. any more pleased?</p>
       </div>
       <div id="menu2" class="tab-pane fade">
           <h2>Peter Griffin, Bass player</h2>
           <p>I mean, sometimes I enjoy the show, but other times I enjoy other things.</p>
       </div>-->
    </div>
</div>
</div>
<!-- Footer -->
<%@include file = "footer.jsp" %>


<script>
    $(document).ready(function(){
        // Initialize Tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Add smooth scrolling to all links in navbar + footer link
        $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

            // Make sure this.hash has a value before overriding default behavior
            if (this.hash !== "") {

                // Prevent default anchor click behavior
                event.preventDefault();

                // Store hash
                var hash = this.hash;

                // Using jQuery's animate() method to add smooth page scroll
                // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 900, function(){

                    // Add hash (#) to URL when done scrolling (default click behavior)
                    window.location.hash = hash;
                });
            } // End if
        });
    })
</script>

</body>
</html>