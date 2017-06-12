package co.davo.news;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Davo on 6/11/2017.
 */

public class ArticleLoader extends AsyncTaskLoader<ArrayList<Article>> {

    private String url;

    public ArticleLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Article> loadInBackground() {
        if (url == null) {
            return null;
        }
        ArrayList<Article> articles = QueryUtils.extractArticles(url);
        return articles;
    }
}