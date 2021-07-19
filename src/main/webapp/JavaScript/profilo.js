
$(document).ready(function() {
    $("#success1").hide();
    $("#alert1").hide();
    $("#success2").hide();
    $("#alert2").hide();
    $("#alert3").hide();


    $("#but2").click(function () {
        var pw = $("#pass").val();
        var oldpw= $("#password").val();
        if(oldpw==pw && validatePassword ()){
            $.post("CambioPasswordServlet", {op: "modCred", pass: pw}, "html")
                .done(function(data){
                    $("#success2").slideDown();
                })
                .fail(function() {
                    $("#alert2").slideDown();
                });
        }else{
            $("#alert3").slideDown();
        }

    });

});