
$(document).ready(function() {


    $("#cambio").click(function () {
        var pw = $("#password").val();
        var oldpw= $("#vecchiaPassword").val();
        var username= $("#username").val();
        var confermaPass=$("#conferma_password").val();
        if(oldpw!=pw && confermaPass == pw && validatePassword(pw)){
            $.post("CambioPasswordServlet", {password: pw, username: username, vecchiaPassword: oldpw, conferma_password: confermaPass})
                .done(function(){
                   alert("Modifica avvenuta con successo");
                })
                .fail(function() {
                    alert("Errore! Modifica non avvenuta");
                });
        }else{
            alert("Password non ha i requisiti per essere sicura!");
        }

    });

});