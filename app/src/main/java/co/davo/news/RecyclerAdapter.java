package co.davo.news;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Davo on 6/5/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ArticleHolder> {
    private ArrayList<Article> articles;

    public RecyclerAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public static class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView authorTextView;
        private TextView publicationDateTextView;

        private static final String ARTICLE_KEY = "ARTICLE";

        public ArticleHolder(View itemView) {
            super(itemView);

            this.titleTextView = (TextView) itemView.findViewById(R.id.title);
            this.sectionTextView = (TextView) itemView.findViewById(R.id.section);
            this.authorTextView = (TextView) itemView.findViewById(R.id.author);
            this.publicationDateTextView = (TextView) itemView.findViewById(R.id.publication_date);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO Insert Website Intent here, Davo
            Log.d("RecyclerView", "CLICK!");
        }
    }

    @Override
    public RecyclerAdapter.ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ArticleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
