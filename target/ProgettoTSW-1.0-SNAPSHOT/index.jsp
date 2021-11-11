<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Theme Made By www.w3schools.com - No Copyright -->
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        input[type=text]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
        }

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
        .prodotto {
            border: 10px solid transparent;
            margin-bottom: 25px;
            width: 80%;
            height: 80%;
            opacity: 0.7;
        }
        .prodotto:hover {
            border-color: #d0d0d0;
        }

        .carousel-inner img {
            width: 100%;
            margin: auto;
        }

        .bg-1 {
            background: #2d2d30;
            color: #bdbdbd;
        }
        .bg-1 h3 {color: #fff;}
        .bg-1 p {font-style: italic;}

        .thumbnail {
            padding: 0 0 15px 0;
            border: none;
            border-radius: 0;
        }
        .thumbnail p {
            margin-top: 15px;
            color: #555;
        }

        h4 {
            background-color: #333;
            color: #fff !important;
            text-align: center;
            font-size: 30px;
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
        </div>

        <div class="item">
            <img src="images/Slider/foto3.jpg" alt="FotoSlider2" width="1200" height="600">
        </div>

        <div class="item">
            <img src="images/Slider/foto5.jpg" alt="FotoSlider3" width="1200" height="600">

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
<div id="band" class="container text-center">

<!-- Container per le recensioni-->
        <h3> Cosa dicono di noi:</h3>
        <div class="col-sm-4">
            <p class="text-center"><strong>Elena</strong></p><br>
            <a href="#demo" data-toggle="collapse">
                <img src="images/FotoProdotti/CanonG9.jpg" class="img-circle prodotto" alt="Spedizione" width="255" height="255">
            </a>
            <div id="demo" class="collapse">
                <p>Spedizione Puntuale, come sempre!</p>
            </div>
        </div>
        <div class="col-sm-4">
            <p class="text-center"><strong>Jin-Sung</strong></p><br>
            <a href="#demo2" data-toggle="collapse">
                <img src="images/FotoProdotti/SigmaNikon50mm.jpg" class="img-circle prodotto" alt="Servizio clienti" width="255" height="255">
            </a>
            <div id="demo2" class="collapse">
                <p>Gentili e cordiali</p>
            </div>
        </div>
        <div class="col-sm-4">
            <p class="text-center"><strong>Giovanni</strong></p><br>
            <a href="#demo3" data-toggle="collapse">
                <img src="images/FotoProdotti/Sigma100-400mmF5-6-3.jpg" class="img-circle prodotto" alt="Prodotti" width="255" height="255">
            </a>
            <div id="demo3" class="collapse">
                <p>Prodotti di ottima qualità</p>
                <p>e prezzi scontati!</p>
            </div>
        </div>
    </div>
</div>

<!-- Container ( prodotti) -->
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
                    <img src="images/FotoProdotti/FujifilNstax.jpg" alt="FujifilmNstax" width="400" height="300">
                    <p><strong>FujifilmNstax</strong></p>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="images/FotoProdotti/NikonD610.jpg" alt="Nikond610" width="400" height="300">
                    <p><strong>Nikond610</strong></p>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Video -->
<div id="video">
    <video style="width: 100%; height: 100%" controls>
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
            <p><span class="glyphicon glyphicon-envelope"></span>Email: ReflexYourWordld@gmail.com</p>
        </div>

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
            }
        });
    })
</script>

</body>
</html>