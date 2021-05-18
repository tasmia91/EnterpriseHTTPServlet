package com.film.service.servlets;

import com.film.service.dao.FilmRepository;
import com.film.service.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.film.service.util.CommonUtil.convertListToJson;
import static com.film.service.util.CommonUtil.convertListToXml;

/**
 * Class for Search Film Servlet
 */

@WebServlet("/film/getFilm")
public class SearchFilmServlet extends HttpServlet {
    //DoGet as still fetching a record
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmTitle = request.getParameter("filmTitle");
        Long filmId = request.getParameter("filmId") != null ? Long.valueOf((request.getParameter("filmId"))) : null;
        List<Film> films;
        if (filmTitle != null && !filmTitle.equals("")) {
            films = FilmRepository.getInstance().getFilm(filmTitle);
        } else {
            films = Collections.singletonList(FilmRepository.getInstance().getFilmById(filmId));
        }
        request.setAttribute("filmList", films);

        String format = request.getParameter("format");
        if ("xml".equals(format)) {
            response.setContentType("text/xml");
            response.getWriter().println(convertListToXml(films));
        } else if ("json".equals(format)) {
            response.setContentType("application/json");
            response.getWriter().println(convertListToJson(films));
        } else {
            response.setContentType("text/string");
            response.getWriter().println(films.toString());
        }
    }
}
