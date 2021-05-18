package com.film.service.servlets;

import com.film.service.dao.FilmRepository;
import com.film.service.entity.Film;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class for Insert Film Servlet
 */

@WebServlet("/film/insert-film")
public class InsertFilmServlet extends HttpServlet {
    //DoPost as record is being inserted
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String filmTitle = request.getParameter("filmTitle");
        Long filmYear = Long.valueOf(request.getParameter("filmYear"));
        String filmDirector = request.getParameter("filmDirector");
        String filmStars = request.getParameter("filmStars");
        String filmReview = request.getParameter("filmReview");
        FilmRepository.getInstance().insertFilm(new Film(filmTitle, filmYear, filmDirector, filmStars, filmReview));

        String format = request.getParameter("format");
        if ("xml".equals(format)) {
            response.setContentType("text/xml");
            response.getWriter().println("<response> Successfully inserted film </response>");
        } else if ("json".equals(format)) {
            response.setContentType("application/json");
            response.getWriter().println("{\"response\":\"Successfully inserted film\"}");
        } else {
            response.setContentType("text/string");
            response.getWriter().println("Successfully inserted film");
        }

    }

}


