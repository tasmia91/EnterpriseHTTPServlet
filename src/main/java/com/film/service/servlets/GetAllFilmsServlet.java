package com.film.service.servlets;

import com.film.service.dao.FilmRepository;
import com.film.service.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.film.service.util.CommonUtil.convertListToJson;
import static com.film.service.util.CommonUtil.convertListToXml;
/**
 * Class for Get All Films Servlet
 */

@WebServlet("/film/getAllFilms")
public class GetAllFilmsServlet extends HttpServlet {
    @Override
    //DoGet as fetching the film records
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmRepository filmDao = FilmRepository.getInstance();
        List<Film> films = filmDao.getAllFilms();
        //FilmList is just a name by which will access in html
        //f is the actual object whose value this filmList will keep
        request.setAttribute("filmList", films);
        String format = request.getParameter("format");
        response.setCharacterEncoding("UTF-8");
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
