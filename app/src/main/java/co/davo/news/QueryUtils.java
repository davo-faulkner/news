package co.davo.news;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static co.davo.news.MainActivity.LOG_TAG;

/**
 * Created by Davo on 6/11/2017.
 */

public final class QueryUtils {
    private static final String KEY_TITLE = "webTitle";
    private static final String KEY_SECTION = "sectionName";
    //TODO Get author key, Davo
    private static final String KEY_AUTHOR = "";
    private static final String KEY_PUBLICATION_DATE = "webPublicationDate";
    private static final String KEY_URL = "apiUrl";

    //Empty constructor to keep class from becoming instantiated
    private QueryUtils() {
    }

    public static ArrayList<Article> extractArticles(String requestUrl) {
        ArrayList<Article> articles = new ArrayList<>();
        String articlesJsonString = fetchArticleData(requestUrl);

        return articles;
    }

    private static String fetchArticleData(String requestUrl) {
        URL url = createUrl(requestUrl);
        String articlesJsonString = null;

        return articlesJsonString;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        }
        catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error creating URL", e);
            MainActivity.setHasMalformedUrlException(true);
        }
        return url;
    }

}
