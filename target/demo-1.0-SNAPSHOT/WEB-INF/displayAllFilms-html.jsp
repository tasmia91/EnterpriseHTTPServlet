<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="com.film.service.entity.Film" %>
<%@page import="java.util.ArrayList" %>

<h1 class="text-center">Displaying all Films</h1>
<table border="1" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Film ID</b></th>
        <th><b>Film Title</b></th>
        <th><b>Film Year</b></th>
        <th><b>Film Director</b></th>
        <th><b>Film Stars</b></th>
        <th><b>Film Review</b></th>

    </tr>

    <%
        ArrayList<Film> filmsList = (ArrayList<Film>) request.getAttribute("filmList");
        for (Film f : filmsList) {
    %>

    <tr>
        <td><%=f.getFilmId()%>
        </td>
        <td><%=f.getFilmTitle() %>
        </td>
        <td><%=f.getFilmYear() %>
        </td>
        <td><%=f.getFilmDirector() %>
        </td>
        <td><%=f.getFilmStars() %>
        </td>
        <td><%=f.getFilmReview()%>
        </td>
    </tr>
    <%}%>
</table>