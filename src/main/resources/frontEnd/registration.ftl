<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#include "css/main.ftl">

</head>
<body>
<#include "elements/menu.ftl">

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-4 center">Registration</h1>

            <form>
                <div class="form-group">
                    <label for="mailInput">Email address</label>
                    <input type="email" class="form-control" id="mailInput" aria-describedby="emailHelp" placeholder="Enter email">
                </div>

                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input type="text" class="form-control" id="firstName" aria-describedby="emailHelp" placeholder="Enter first name">
                </div>
                <div class="form-group">
                    <label for="secondName">Second name</label>
                    <input type="text" class="form-control" id="secondName" aria-describedby="emailHelp" placeholder="Enter second name">
                </div>
                <div class="form-group">
                    <label for="birthDate">Birth date</label>
                    <input type="date" class="form-control" id="birthDate" aria-describedby="emailHelp" placeholder="Enter birth date">
                </div>

                <div class="form-group">
                    <label for="sexSelect">SEX:</label>
                    <select id="sexSelect" class="custom-select">
                        <option value="Male" selected>Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="passInput">Password</label>
                    <input type="password" class="form-control" id="passInput" placeholder="Password">
                </div>

                <button type="button" class="btn btn-primary" onclick="reg();" id="buttonReg">Registration</button>
            </form>
        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script>
    function reg() {
        var mail = document.getElementById("mailInput").value,
            firstName= document.getElementById("firstName").value,
            secondName = document.getElementById("secondName").value,
            pass = document.getElementById("passInput").value,
            date = document.getElementById("birthDate").value;

        var sexSelector = document.getElementById("sexSelect"),
            sex = sexSelector[sexSelector.selectedIndex].value;

        $.ajax({
            type: "POST",
            url: "${webAddress}/restApi/userInfo",
            data: "&mail="+ mail + "&pass="+ pass + "&first_name="+ firstName + "&second_name="+ secondName +"&sex="+sex+"&date="+date,
            success: function(data) {
                alert(data.successfully);
                window.location.replace("${webAddress}/Profile");
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });
    }
</script>

</html>






