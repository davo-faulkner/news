package co.davo.news;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Article>> {
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final int ARTICLE_LOADER_ID = 1;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
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

        RecyclerView articleRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        emptyStateTextView = (TextView) findViewById(R.id.empty_view);
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