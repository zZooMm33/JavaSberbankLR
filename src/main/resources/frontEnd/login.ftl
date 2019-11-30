<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#include "css/main.ftl">

</head>
<body>
<#include "elements/menu.ftl">

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-4 center">Login</h1>

            <form>
                <div class="form-group">
                    <label for="mailInput">Email address</label>
                    <input type="email" class="form-control" id="mailInput" aria-describedby="emailHelp" placeholder="Enter email">
                </div>

                <div class="form-group">
                    <label for="passInput">Password</label>
                    <input type="password" class="form-control" id="passInput" placeholder="Password">
                </div>

                <button type="button" class="btn btn-primary" onclick="login();" id="buttonLogin">Login</button>
            </form>
        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script>

    function login() {
        var mail = document.getElementById("mailInput").value,
            pass = document.getElementById("passInput").value;

        $.ajax({
            type: "POST",
            url: "${webAddress}/restApi/userPass",
            data: "&mail="+ mail + "&pass="+ pass,
            success: function(data) {
                window.location.replace("${webAddress}/index");
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });
    }
</script>

</html>






