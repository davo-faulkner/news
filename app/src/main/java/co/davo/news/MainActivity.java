package co.davo.news;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Article>> {
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final int ARTICLE_LOADER_ID = 1;
    private static final String QUERY_URL = "http://content.guardianapis.com/search?q=tower&api-key=test";

    private ArrayList<Article> articles;

    private RecyclerView recyclerView;
    private RecyclerAdapter articleRecyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private TextView emptyStateTextView;
    private ProgressBar progressBar;

    private static boolean hasJsonException = false;
    private static boolean hasParseException = false;
    private static boolean hasIoException = false;
    private static boolean hasBadResponseCode = false;
    private static int badResponseCode;
    private static boolean hasIoException2 = false;
    private static boolean hasMalformedUrlException = false;

    public static void setHasJsonException(boolean hasJsonException) {
        MainActivity.hasJsonException = hasJsonException;
    }

    public static void setHasParseException(boolean hasParseException) {
        MainActivity.hasParseException = hasParseException;
    }

    public static void setHasIoException(boolean hasIoException) {
        MainActivity.hasIoException = hasIoException;
    }

    public static void setHasBadResponseCode(boolean hasBadResponseCode) {
        MainActivity.hasBadResponseCode = hasBadResponseCode;
    }

    public static void setBadResponseCode(int badResponseCode) {
        MainActivity.badResponseCode = badResponseCode;
    }

    public static void setHasIoException2(boolean hasIoException2) {
        MainActivity.hasIoException2 = hasIoException2;
    }

    public static void setHasMalformedUrlException(boolean hasMalformedUrlException) {
        MainActivity.hasMalformedUrlException = hasMalformedUrlException;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setVisibility(View.GONE);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        emptyStateTextView = (TextView) findViewById(R.id.empty_view);
        emptyStateTextView.setText(R.string.no_articles_found);
        emptyStateTextView.setVisibility(View.GONE);

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        progressBar = (ProgressBar) findViewById(R.id.loading_spinner);
        progressBar.setVisibility(View.VISIBLE);

        if (!isConnected) {
            progressBar.setVisibility(View.GONE);
            emptyStateTextView.setText(R.string.no_internet_connection);
            emptyStateTextView.setVisibility(View.VISIBLE);
        } else {
            articleRecyclerAdapter = new RecyclerAdapter(new ArrayList<Article>());
            recyclerView.setAdapter(articleRecyclerAdapter);
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
        }
    }

    @Override
    public Loader<ArrayList<Article>> onCreateLoader(int id, Bundle args) {
        return new ArticleLoader(this, QUERY_URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Article>> loader, ArrayList<Article> data) {
        progressBar.setVisibility(View.GONE);
        if (data != null && !data.isEmpty()) {
            recyclerView.setVisibility(View.VISIBLE);
            this.articles = data;
            articleRecyclerAdapter = new RecyclerAdapter(articles);
        } else {
            emptyStateTextView.setVisibility(View.VISIBLE);
        }
        if (hasJsonException) {
            Toast.makeText(this, "Problem parsing the book JSON results", Toast.LENGTH_SHORT).show();
        }
        if (hasParseException) {
            Toast.makeText(this, "Problem parsing the Date", Toast.LENGTH_SHORT).show();
        }
        if (hasIoException) {
            Toast.makeText(this, "Error closing input stream", Toast.LENGTH_SHORT).show();
        }
        if (hasBadResponseCode) {
            String badResponseCodeString = "Error response code " + badResponseCode;
            Toast.makeText(this, badResponseCodeString, Toast.LENGTH_SHORT).show();
        }
        if (hasIoException2) {
            Toast.makeText(this, "Problem retrieving the book JSON results", Toast.LENGTH_SHORT).show();
        }
        if (hasMalformedUrlException) {
            Toast.makeText(this, "Error creating URL", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Article>> loader) {
        articles.clear();
    }
}