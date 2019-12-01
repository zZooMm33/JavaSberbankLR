<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#include "css/main.ftl">

</head>
<body>
<#include "elements/menu.ftl">

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-4 center">Profile</h1>
            <form>
                <div class="form-group">
                    <label for="mailInput">Email address</label>
                    <input type="email" class="form-control" id="mailInput" aria-describedby="emailHelp" placeholder="Enter email" disabled <#if userInfo??> <#if userInfo.getMail()??>value=${userInfo.getMail()} </#if></#if>>
                </div>

                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input type="text" class="form-control" id="firstName" aria-describedby="emailHelp" placeholder="Enter first name" <#if userInfo??> <#if userInfo.getFirstName()??>value=${userInfo.getFirstName()}</#if></#if>>
                </div>
                <div class="form-group">
                    <label for="secondName">Second name</label>
                    <input type="text" class="form-control" id="secondName" aria-describedby="emailHelp" placeholder="Enter second name" <#if userInfo??> <#if userInfo.getLastName()??>value=${userInfo.getLastName()}</#if></#if>>
                </div>
                <div class="form-group">
                    <label for="birthDate">Birth date</label>
                    <input type="date" class="form-control" id="birthDate" aria-describedby="emailHelp" placeholder="Enter birth date" <#if userInfo??> <#if userInfo.getDateOfBirth()??>value=${userInfo.getDateOfBirth()}</#if></#if>>
                </div>

                <div class="form-group">
                    <label for="sexSelect">SEX:</label>
                    <select id="sexSelect" class="custom-select">
                        <#if userInfo??>
                            <#if userInfo.getSex()??>
                                <#if userInfo.getSex()=="Male">
                                    <option value="Male" selected>Male</option>
                                    <option value="Female">Female</option>
                                <#else>
                                    <option value="Male">Male</option>
                                    <option value="Female" selected>Female</option>
                                </#if>
                            <#else>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                            </#if>
                        <#else>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </#if>
                    </select>
                </div>

                <button type="button" class="btn btn-primary" onclick="changeUserInfo();" id="buttonChangeUserInfo">Change</button>

                <#if userInfo??>
                    <#if userInfo.isAdmin()??>
                        <#if userInfo.isAdmin()>
                            <br>
                            <a href="${webAddress}/AdminPage"><button type="button" class="btn btn-danger mt-2">Admin page</button></a>
                        </#if>
                    </#if>
                </#if>
            </form>

            <p class="mt-4"><b>Comments:</b></p>
            <#if userInfo??>
                <#if userInfo.getHotelReview()?has_content>
                    <#list userInfo.getHotelReview() as comment>
                        <div class="divHotel">
                            <label for="hotelName">Hotel name</label>

                            <select id="hotelChange${comment.getId()}" class="custom-select">
                                <#list hotels as hot>
                                    <#if hot.getId()==comment.getHotel().getId()>
                                        <option value="${hot.getId()}" selected>${hot.getName()}</option>
                                    <#else>
                                        <option value="${hot.getId()}">${hot.getName()}</option>
                                    </#if>
                                </#list>
                            </select>

                            <label for="dateOfVisit">DateOfVisit</label>
                            <input type="date" class="form-control" id="dateOfVisit${comment.getId()}" placeholder="Enter visit date" <#if comment.getDateOfVisit()?has_content> value=${comment.getDateOfVisit()}</#if>>

                            <label for="rating">Rating</label>
                            <input type="text" class="form-control" id="rating${comment.getId()}" <#if comment.getRating()??>value=${comment.getRating()}</#if>>

                            <label for="description">Description</label>
                            <input type="text" class="form-control" id="description${comment.getId()}" <#if comment.getDescription()??>value="${comment.getDescription()}"</#if>>

                            <button type="button" class="btn btn-primary mt-2 buttonChangeComment" onclick="changeComment(${comment.getId()});" id=${"change" + comment.getId()}>Change</button>
                            <button type="button" class="btn btn-primary mt-2 buttonDeleteComment" onclick="deleteComment(${comment.getId()});" id=${"delete" + comment.getId()}>Delete</button>
                        </div>
                    </#list>
                </#if>
            </#if>
        </div>
    </div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script>
    function changeUserInfo() {
        var mail = document.getElementById("mailInput").value,
            firstName= document.getElementById("firstName").value,
            secondName = document.getElementById("secondName").value,
            date = document.getElementById("birthDate").value;

        var sexSelector = document.getElementById("sexSelect"),
            sex = sexSelector[sexSelector.selectedIndex].value;

        $.ajax({
            type: "PUT",
            url: "${webAddress}/restApi/userInfo",
            data: "&mail="+ mail + "&first_name="+ firstName + "&second_name="+ secondName +"&sex="+sex+"&date="+date,
            success: function(data) {
                alert(data.successfully);
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });
    }

    function changeComment(idComment) {
        var dateOfVisit= document.getElementById("dateOfVisit"+idComment).value,
            rating = document.getElementById("rating"+idComment).value,
            description = document.getElementById("description"+idComment).value,
            hotelId = document.getElementById("hotelChange"+idComment).value;

        $.ajax({
            type: "PUT",
            url: "${webAddress}/restApi/hotelReviews",
            data: "&dateOfVisit="+ dateOfVisit + "&rating="+ rating + "&description="+ description+ "&idComment="+ idComment+ "&hotelId="+ hotelId,
            success: function(data) {
                alert(data.successfully);
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });
    }

    function deleteComment(idComment) {
        $.ajax({
            type: "DELETE",
            url: "${webAddress}/restApi/hotelReviews",
            data: "&idComment="+ idComment,
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






