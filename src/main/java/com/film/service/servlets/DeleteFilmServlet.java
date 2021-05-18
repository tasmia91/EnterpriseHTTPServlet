package com.film.service.servlets;

import com.film.service.dao.FilmRepository;
import com.film.service.entity.Film;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.film.service.util.CommonUtil.convertListToJson;
/**
 * Class for Delete Film Servlet
 */

@WebServlet("/film/delete-film")
public class DeleteFilmServlet extends HttpServlet {

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long filmId = Long.valueOf(request.getParameter("filmId"));
        FilmRepository.getInstance().deleteFilm(filmId);
        List<Film> films = FilmRepository.getInstance().getAllFilms();

        response.setContentType("application/json");
        response.getWriter().println(convertListToJson(films));
    }
}


