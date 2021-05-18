package com.film.service.dao;

import com.film.service.entity.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.film.service.util.Constants.*;

/**
 * Class for Film repository
 */
public class FilmRepository {

    //Private constructor for singleton
    private FilmRepository() {
    }

    private final Logger logger = LoggerFactory.getLogger(FilmRepository.class);

    //Object made of FilmRepository
    private static FilmRepository dao;

    Film oneFilm;

    // Used for creating a connection to SQL
    Connection conn;

    // For querying and retrieving info from dB
    Statement stmt;

    //Synchronized
    public static synchronized FilmRepository getInstance() {
        if (dao == null) {
            dao = new FilmRepository();
        }
        return dao;
    }


    //An arraylist of films
    public List<Film> getAllFilms() {

        List<Film> allFilms = new ArrayList<>();
        openConnection();

        try {
            //Select query for all films
            String selectSQL = "SELECT * from films";
            ResultSet rs1 = stmt.executeQuery(selectSQL);
            //Retrieve the results
            while (rs1.next()) {
                oneFilm = getNextFilm(rs1);
                allFilms.add(oneFilm);
            }
        } catch (SQLException se) {
            logger.debug(se.getMessage());
        } finally {
            closeConnection();
        }
        return allFilms;
    }


    //Returning films by relevant filmID
    public Film getFilmById(Long filmId) {
        openConnection();
        oneFilm = null;
        //Creating SQL statement
        try {
            //Select query where film id is specified
            String selectSQL = String.format("SELECT * from films WHERE id = %s", filmId);
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                oneFilm = getNextFilm(rs);
            }
        } catch (SQLException se) {
            logger.debug(se.getMessage());
        } finally {
            closeConnection();
        }
        return oneFilm;
    }


    public List<Film> getFilm(String filmTitle) {
        openConnection();
        oneFilm = null;

        List<Film> allFilms = new ArrayList<>();
        //Creating SQL statement
        try {
            //Select query where film id is specified
            String selectSQL = String.format("SELECT * from films WHERE upper(title) like upper('%%%s%%')", filmTitle);
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                oneFilm = getNextFilm(rs);
                allFilms.add(oneFilm);
            }
        } catch (SQLException se) {
            logger.debug(se.getMessage());
        } finally {
            closeConnection();
        }
        return allFilms;
    }

    //Inserting films into database
    public int insertFilm(Film film) {
        openConnection();
        //Query to insert films
        String query = "INSERT INTO films (title, year, director, stars, review) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            //Setting each value using key pair
            pstmt.setString(1, film.getFilmTitle());
            pstmt.setLong(2, film.getFilmYear());
            pstmt.setString(3, film.getFilmDirector());
            pstmt.setString(4, film.getFilmStars());
            pstmt.setString(5, film.getFilmReview());
            return pstmt.executeUpdate();
        } catch (SQLException se) {
            logger.debug(se.getMessage());
        } finally {
            closeConnection();
        }
        return 0;
    }

    //Updating film records
    public int updateFilm(Film filmObj) {
        openConnection();
        //Query to update film
        String query = "UPDATE films SET title=?, director=?, year= ?, stars=?, review=? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            //Setting each value described in query
            pstmt.setString(1, filmObj.getFilmTitle());
            pstmt.setString(2, filmObj.getFilmDirector());
            pstmt.setLong(3, filmObj.getFilmYear());
            pstmt.setString(4, filmObj.getFilmStars());
            pstmt.setString(5, filmObj.getFilmReview());
            pstmt.setLong(6, filmObj.getFilmId());
            return pstmt.executeUpdate();
        } catch (SQLException se) {
            logger.debug(se.getMessage());
        } finally {
            closeConnection();
        }
        return 0;
    }

    //Delete film
    public int deleteFilm(Long filmId) {
        openConnection();
        //Delete query
        String query = "DELETE from films WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            //Setting each value using key pair
            pstmt.setLong(1, filmId);
            return pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        } finally {
            closeConnection();
        }
        return 0;
    }

    // Creating connection to mySQL database
    private void openConnection() {
        try {
            //Register JDBC Driver - used to connect database with java application
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Open a connection
            logger.debug("Connecting to a database..");
            conn = DriverManager.getConnection(DB_URL, USER, TOKEN);

            //Execute a query
            logger.debug("Creating database...");
            stmt = conn.createStatement();

        } catch (Exception se) {
            //Handle errors for JDBC
            logger.debug(se.getMessage());
        }//Handle errors for Class.forName

    }

    //Close connection
    private void closeConnection() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }

    //Getting next film and saving in thisFilm
    private Film getNextFilm(ResultSet rs) {
        Film thisFilm = null;
        try {
            thisFilm = new Film(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getLong("year"),
                    rs.getString("director"),
                    rs.getString("stars"),
                    rs.getString("review"));

            logger.debug("Get Next Film printing: {}", thisFilm);

        } catch (SQLException e) {
            logger.debug(e.getMessage());
        }
        return thisFilm;
    }

    // Stops anyone from cloning the object and makes it bullet proof thread safe
    // To make it full proof singleton
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
