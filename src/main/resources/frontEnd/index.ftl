<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Index</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <#include "css/main.ftl">

    </head>
    <body>
        <#include "elements/menu.ftl">

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="mt-4 center">Index</h1>

                        <#if hotels?has_content>
                            <div class="row justify-content-center">
                                <p><b>Comments:</b></p>

                                <#list hotels as hotel>
                                    <div class="col-3 divHotel">
                                        <p><b>Name:</b> <a href="${webAddress}/HotelCard?id=${hotel.getId()}">${hotel.getName()}</a></p>
                                        <p><b>Website:</b> <a href="${hotel.getWebsite()}">${hotel.getWebsite()}</a></p>
                                        <p><b>Country:</b> ${hotel.getCountry()}</p>
                                        <p><b>City:</b> ${hotel.getCity()}</p>
                                        <p><b>Average rating:</b> ${hotel.getAverageRating()}</p>
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
        </div>
    </body>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>