package co.davo.news;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

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
        try {
            articlesJsonString = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
            MainActivity.setHasIoException(true);
        }
        return articlesJsonString;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                String badResponseCode = "Error response code: " + urlConnection.getResponseCode();
                Log.e(LOG_TAG, badResponseCode);
                MainActivity.setHasBadResponseCode(true);
                MainActivity.setBadResponseCode(urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the article JSON results", e);
            MainActivity.setHasIoException2(true);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
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