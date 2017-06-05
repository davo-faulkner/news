package co.davo.news;

import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Article>> {
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final int ARTICLE_LOADER_ID = 1;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter articleAdapter;
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
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //TODO Fix this, Davo
        articleAdapter = new ArticleAdapter(articles);
        recyclerView.setAdapter(articleAdapter);

        emptyStateTextView = (TextView) findViewById(R.id.empty_view);

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        progressBar = (ProgressBar) findViewById(R.id.loading_spinner);

        LoaderManager loaderManager = getLoaderManager();

        if (!isConnected) {
            progressBar.setVisibility(View.GONE);
            emptyStateTextView.setText(R.string.no_internet_connection);
        } else {
            //TODO Resume here, Davo
        }
    }

    @Override
    public Loader<ArrayList<Article>> onCreateLoader(int id, Bundle args) {
        return null;
    }
    @Override
    public void onLoadFinished(Loader<ArrayList<Article>> loader, ArrayList<Article> data) {

    }
    @Override
    public void onLoaderReset(Loader<ArrayList<Article>> loader) {

    }
}