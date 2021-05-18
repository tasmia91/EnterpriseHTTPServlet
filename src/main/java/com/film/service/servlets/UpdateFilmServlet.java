package com.film.service.servlets;

import com.film.service.dao.FilmRepository;
import com.film.service.entity.Film;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Class for Update Film Servlet
 */

@WebServlet("/film/update-film")
public class UpdateFilmServlet extends HttpServlet {
    //DoPut as record is being updated
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long filmId = Long.valueOf(request.getParameter("filmId"));
        String filmTitle = request.getParameter("filmTitle");
        Long filmYear = Long.valueOf(request.getParameter("filmYear"));
        String filmDirector = request.getParameter("filmDirector");
        String filmStars = request.getParameter("filmStars");
        String filmReview = request.getParameter("filmReview");
        FilmRepository.getInstance().updateFilm(new Film(filmId, filmTitle, filmYear, filmDirector, filmStars, filmReview));


        String format = request.getParameter("format");
        if ("xml".equals(format)) {
            response.setContentType("text/xml");
            response.getWriter().println("<response> Successfully updated film </response>");
        } else if ("json".equals(format)) {
            response.setContentType("application/json");
            response.getWriter().println("{\"response\":\"Successfully updated film\"}");
        } else {
            response.setContentType("text/string");
            response.getWriter().println("Successfully inserted film");
        }
    }
}


