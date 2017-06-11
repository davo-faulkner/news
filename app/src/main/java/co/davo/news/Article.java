package co.davo.news;

/**
 * Created by Davo on 6/4/2017.
 */

public class Article {
    private String title;
    private String section;
    private boolean hasAuthor;
    private String author;
    private String publicationDate;
    private String url;

    public Article(String title, String section, boolean hasAuthor, String author, String publicationDate, String url) {
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

    public String getPublicationDate() {
        //TODO Add Date Formatter, Davo
        return publicationDate;
    }

    public String getUrl() {
        return url;
    }
}
