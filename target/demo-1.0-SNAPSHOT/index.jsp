<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <title>FILM CENTRE</title>
    <style>
        .btn-primary:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body style="background-color: ivory">
<div align="center">
    <h1 class="mt-2">Welcome to Tasmia's Films Centre</h1>
    <p>Please choose from one of the following:</p>
    <div class="col-md-12 mt-2">
        <form action="requestDisplayAllFilms.html">
            <input type="submit" class="btn btn-primary" value="DISPLAY ALL FILMS"/>
        </form>
        <br>
        <form action="requestSearchFilm.html">
            <input type="submit" class="btn btn-primary" value="SEARCH FILM"/>
        </form>
        <br>
        <form action="requestInsertFilm.html">
            <input type="submit" class="btn btn-primary" value="INSERT FILM"/>
        </form>
        <br>
        <form action="requestUpdateFilm.html">
            <input type="submit" class="btn btn-primary" value="UPDATE FILM"/>
        </form>
        <br>
        <form action="requestDeleteFilm.html">
            <input type="submit" class="btn btn-primary" value="DELETE FILM"/>
        </form>
    </div>

</div>
</body>
</html>
