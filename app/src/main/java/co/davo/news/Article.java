package co.davo.news;

/**
 * Created by Davo on 6/4/2017.
 */

public class Article {
    private String title;
    private String section;
    private String publicationDate;
    private String url;

    public Article(String title, String section, String publicationDate, String url) {
        this.title = title;
        this.section = section;
        this.publicationDate = publicationDate;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getUrl() {
        return url;
    }
}
