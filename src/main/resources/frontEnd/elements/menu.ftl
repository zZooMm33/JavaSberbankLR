<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${webAddress}">zZooMm</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${webAddress}">Home</a>
            </li>
            <#if token??>
                <li class="nav-item">
                    <a class="nav-link" onclick="logout()" href="${webAddress}">Logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${webAddress}/Profile">Profile</a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="${webAddress}/Login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${webAddress}/Registration">Registration</a>
                </li>
            </#if>
        </ul>
    </div>
</nav>

<script>
    function logout() {
        $.ajax({
            type: "POST",
            url: "${webAddress}/restApi/userToken",
            data: "",
            success: function(data) {
                window.location.replace("${webAddress}/index");
            },
            error: function (jqXHR, exception) {
                alert(jQuery.parseJSON(jqXHR.responseText).error);
            }
        });

    }
</script>