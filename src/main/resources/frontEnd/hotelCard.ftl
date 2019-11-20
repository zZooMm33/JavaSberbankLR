<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotel Card</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#include "css/main.ftl">

</head>
<body>
<#include "elements/menu.ftl">

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-4 center">Hotel Card</h1>

            <p><b>Name:</b> ${hotel.getName()}</p>
            <p><b>Website:</b> <a href="${hotel.getWebsite()}">${hotel.getWebsite()}</a></p>
            <p><b>Country:</b> ${hotel.getCountry()}</p>
            <p><b>City:</b> ${hotel.getCity()}</p>
            <p><b>Star:</b> ${hotel.getStar()}</p>
            <p><b>Description:</b> ${hotel.getDescription()}</p>
            <br>

            <#if hotel.getHotelReview()?has_content>
                <p><b>Comments:</b></p>

                <#list hotel.getHotelReview() as comment>
                    <div class="divHotel">
                        <p>DateOfVisit: ${comment.getDateOfVisit()}</p>
                        <p>UserAgeOfVisit: ${comment.getUserAgeOfVisit()}</p>
                        <p>Rating: ${comment.getRating()}</p>
                        <p>Description: ${comment.getDescription()}</p>
                    </div>
                </#list>
            <#else>
                <p><b>No comments</b></p>
            </#if>
        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>