package com.film.service.entity;

/**
 * Class for Film
 */
public class Film {

    public Film(Long filmId, String filmTitle, Long filmYear, String filmDirector, String filmStars, String filmReview) {
        this.id = filmId;
        this.title = filmTitle;
        this.year = filmYear;
        this.director = filmDirector;
        this.stars = filmStars;
        this.review = filmReview;

    }

    public Film(String filmTitle, Long filmYear, String filmDirector, String filmStars, String filmReview) {
        this.title = filmTitle;
        this.year = filmYear;
        this.director = filmDirector;
        this.stars = filmStars;
        this.review = filmReview;
    }

    private Long id;
    private String title;
    private Long year;
    private String director;
    private String stars;
    private String review;

    public Long getFilmId() {
        return id;
    }

    public void setFilmId(Long filmId) {
        this.id = filmId;
    }

    public String getFilmTitle() {
        return title;
    }

    public void setFilmTitle(String filmTitle) {
        this.title = filmTitle;
    }

    public Long getFilmYear() {
        return year;
    }

    public void setFilmYear(Long filmYear) {
        this.year = filmYear;
    }

    public String getFilmDirector() {
        return director;
    }

    public void setFilmDirector(String filmDirector) {
        this.director = filmDirector;
    }

    public String getFilmStars() {
        return stars;
    }

    public void setFilmStars(String filmStars) {
        this.stars = filmStars;
    }

    public String getFilmReview() {
        return review;
    }

    public void setFilmReview(String filmReview) {
        this.review = filmReview;
    }

    @Override
    public String toString() {
        return " id::" + id +
                "-- title::" + title +
                "-- year::" + year +
                "-- director::" + director +
                "-- stars::" + stars +
                "-- reviews::" + review +
                ";;";
    }
}
