package ru.job4j.jsoup;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * Create by dinis of 26.09.17.
 */
public class ParserJsoup {
    /**
     * logge.
     */
    private static final Logger Log = LoggerFactory.getLogger(ParserJsoup.class);
    /**
     * date format.
     */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy", new Locale("ru", "RU"));
    /**
     * url of sql.ru website with java vacancy.
     */
    private String url = "http://www.sql.ru/forum/job-offers";

    public void startParse(DBManager db) {

    }

}
