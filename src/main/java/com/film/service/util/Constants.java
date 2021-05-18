package com.film.service.util;

public class Constants {
    /**
     * Class for Constants
     */

    private Constants() {
    }

    //User name in MySql database
    public static final String USER = "admin123";
    //Password in MySql database
    public static final String TOKEN = "admin123";
    //MySql database name
    public static final String DB_NAME = "assignment_film";
    //MySql database details
    public static final String DB_URL = String.format("jdbc:mysql://film.cx79hreqgxhy.eu-west-2.rds.amazonaws.com:3306/%s", DB_NAME);

}
