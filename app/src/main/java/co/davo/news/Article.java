package co.davo.news;

import java.util.Date;

/**
 * Created by Davo on 6/4/2017.
 */

public class Article {
    private String title;
    private String section;
    private boolean hasAuthor;
    private String author;
    private Date publicationDate;
    private String url;

    public Article(String title, String section, boolean hasAuthor, String author, Date publicationDate, String url) {
        this.title = title;
        this.section = section;
        this.hasAuthor = hasAuthor;
        this.author = author;
        this.publicationDate = publicationDate;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public boolean getHasAuthor() {
        return  hasAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getUrl() {
        return url;
    }
}
