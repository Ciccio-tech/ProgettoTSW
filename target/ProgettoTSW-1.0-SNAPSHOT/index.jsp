<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="css1/mystyle.css">
</head>
<body>

<img src="images/Logo%20(1).png" alt="logo" class="Logo">

<div class="header">
<ul class="h">
    <li> <a href="Login1.jsp" > About Us </a></li>
    <li>
        <div class="dropdown">
            <button class="dropbtn" onclick="myFunction()">Categorie
             <i class="fa fa-caret-down"></i>
            </button>
                <div class="dropdown-content" id="myDropdown">
                 <a href="#">Link 1</a>
                 <a href="#">Link 2</a>
                 <a href="#">Link 3</a>
                </div>
        </div>
    </li>
    <li> <a href="WEB-INF/nome.html" >Prodotti </a></li>
    <li> <a href="Login.jsp" >Iscriviti</a> </li>
    <li>
        <a href="Login.jsp">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-seam" viewBox="0 0 16 16">
                <path d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2l-2.218-.887zm3.564 1.426L5.596 5 8 5.961 14.154 3.5l-2.404-.961zm3.25 1.7l-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z"/>
            </svg>
        </a>
    </li>
    <li>
        <a href="WEB-INF/nome.html">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16">
                <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
            </svg>
        </a>
    </li>
    <li>
        <form class="search" action="action_page.php">
            <a href="WEB-INF/Registrazione.jsp">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
            </svg>
            </a>
        </form>
    </li>
</ul>
</div>


<!--Script per il menu a tendina "Categorie"-->

<!--
<script>
    $(document).ready(function(){
        $('.dropbtn').hover(
            function(){
                $('ul', this).delay(5).slideDown(50);
            },
            function(){
                $('ul', this).delay(5).slideUp(50);
            }
        );
    });


</script>
-->


<script>
    /* When the user clicks on the button,
    toggle between hiding and showing the dropdown content */
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(e) {
        if (!e.target.matches('.dropbtn')) {
            var myDropdown = document.getElementById("myDropdown");
            if (myDropdown.classList.contains('show')) {
                myDropdown.classList.remove('show');
            }
        }
    }
</script>


<!-- The sidebar -->

<div class="sidebar" style="width:70px; text-align: right; color: transparent">
        <a href="https://api.whatsapp.com/send?phone=DA INSERIRE UN NUMERO DI TELEFONO&text=Salve,%20vorrei%20qualche%20informazione%20in%20merito%20ai%20vostri%20prodotti." ><img src="images/whatsapp.png" width=25px height=25px alt="whatsapp"> </a><br>
        <a href="https://www.facebook.com/francesco.cammarota.562"> <img src="images/facebook.png" width=25px height=25px alt="facebook"></a><br>
        <a href="https://www.instagram.com/cammarota.f"> <img src="images/insta.png" width=25px height=25px alt="instagram"></a><br>
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
            <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2zm13 2.383l-4.758 2.855L15 11.114v-5.73zm-.034 6.878L9.271 8.82 8 9.583 6.728 8.82l-5.694 3.44A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.739zM1 11.114l4.758-2.876L1 5.383v5.73z"/>
            </svg>
</div>



<div class="slideshow-container">

    <div class="mySlides">
        <img src="images/Slider/foto.jpg" alt="Canon" class="slider-image" id="slider-image-1" height="500px" width="1000px">
    </div>

    <div class="mySlides">
        <img src="images/Slider/foto1.jpg" alt="paesaggio" class="slider-image" id="slider-image-2" height="500px" width="1000px">
    </div>

    <div class="mySlides">
        <img src="images/Slider/foto2.jpg" alt="bimbo" class="slider-image" id="slider-image-3" height="500px" width="1000px">
    </div>

</div>

<!-- script per le immagini-->
<script>
    var slideIndex = 0;
    showSlides();

    function showSlides() {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}
        slides[slideIndex-1].style.display = "block";
        setTimeout(showSlides, 3000); // Change image every 3 seconds
    }
</script>





<div class="product">
    <p>Prodotti più venduti:</p>
    <!--codice per inserire immagini e prezzo-->
    <ul>
        <li id="prodotti"></li>
    </ul>
    <!--
    <script>
        document.ready();
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                xhttp.open("doRetrieveAll", "../java/model/Prodotto.java", true);
                xhttp.send();
                var s=xhttp.responseText;
                var array = new Array();
                array = s.split(".jpg");
                if(array.length > 0){
                    document.getElementById("prodotti").innerHTML=array;
                }
            }
        };
    </script>


<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      loadProducts(this);
    }
  };
  xhttp.open("GET", "../java/model/Prodotto.java", true);
  xhttp.send();
}
function loadProducts(xml) {
  var i;
  var xmlDoc = xml.responseXML;
  var table="<tr><th>Prodotti</th><th>Title</th></tr>";
  var x = xmlDoc.getElementsByTagName("Obiettivi");
  for (i = 0; i <x.length; i++) {
    table += "<tr><td>" +
    x[i].getElementsByTagName("Marca")[0].childNodes[0].nodeValue +
    "</td><td>" +
    x[i].getElementsByTagName("prezzo")[0].childNodes[0].nodeValue +
    "</td></tr>";
    DA CONTINUARE
  }
  document.getElementById("demo").innerHTML = table;
}
</script>


    -->

</div>



<footer class="footer">
    <p class="marchio">&copy;2021 Reflex Your World</p>
    <ul>
        <li><a href="#">Privacy</a></li>
        <li><a href="#">Terms</a></li>
        <li><a href="#">Support</a></li>
    </ul>
</footer>

</body>
</html>