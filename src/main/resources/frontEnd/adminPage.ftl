<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#include "css/main.ftl">

</head>
<body>
<#include "elements/menu.ftl">

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-4 center">Admin page</h1>
            <button type="button" class="btn btn-danger mt-2" onclick="maintenance();">Enable maintenance mode</button>
            <#if hotels?has_content>
                <div class="row justify-content-center">
                    <#list hotels as hotel>
                        <div class="col-3 divHotel">

                            <div class="form-group">
                                <label for="name${hotel.getId()}">Hotel name</label>
                                <input type="text" class="form-control" id="name${hotel.getId()}" aria-describedby="emailHelp" placeholder="Enter hotel name" value="${hotel.getName()}">
                            </div>

                            <div class="form-group">
                                <label for="website${hotel.getId()}">Website</label>
                                <input type="text" class="form-control" id="website${hotel.getId()}" aria-describedby="emailHelp" placeholder="Enter website" value="${hotel.getWebsite()}">
                            </div>

                            <div class="form-group">
                                <label for="country${hotel.getId()}">Country</label>
                                <input type="text" class="form-control" id="country${hotel.getId()}" aria-describedby="emailHelp" placeholder="Enter country" value="${hotel.getCountry()}">
                            </div>

                            <div class="form-group">
                                <label for="city${hotel.getId()}">City</label>
                                <input type="text" class="form-control" id="city${hotel.getId()}" aria-describedby="emailHelp" placeholder="Enter city" value="${hotel.getCity()}">
                            </div>

                            <div class="form-group">
                                <label for="description${hotel.getId()}">Description</label>
                                <input type="text" class="form-control" id="description${hotel.getId()}" aria-describedby="emailHelp" placeholder="Enter description" value="${hotel.getDescription()}">
                            </div>

                            <div class="form-group">
                                <label for="star${hotel.getId()}">Star</label>
                                <input type="text" class="form-control" id="star${hotel.getId()}" aria-describedby="emailHelp" placeholder="Enter star" value="${hotel.getStar()}">
                            </div>

                            <button type="button" class="btn btn-primary mt-2 buttonChangeComment" onclick="changeHotel(${hotel.getId()});" id=${"change" + hotel.getId()}>Change</button>
                        </div>
                        <div class="col-auto"></div>
                    </#list>
                </div>
            <#else>
                <p class="left"><b>No hotels</b></p>
            </#if>

        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script>
    function changeHotel(idHotel) {
        var name= document.getElementById("name"+idHotel).value,
            website = document.getElementById("website"+idHotel).value,
            country = document.getElementById("country"+idHotel).value,
            city = document.getElementById("city"+idHotel).value,
            description = document.getElementById("description"+idHotel).value,
            star = document.getElementById("star"+idHotel).value;

        $.ajax({
            type: "PUT",
            url: "${webAddress}/restApi/hotels",
            data: "&name="+ name + "&website="+ website + "&country="+ country+ "&city="+ city+ "&idHotel="+ idHotel + "&description="+ description + "&star="+ star,
            success: function(data) {
                alert(data.successfully);
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });
    }

    function maintenance() {
        $.ajax({
            type: "PUT",
            url: "${webAddress}/restApi/config",
            data: "&maintenance=true",
            success: function(data) {
                alert(data.successfully);
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });
    }
</script>
</html>