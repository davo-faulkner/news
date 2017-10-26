package co.davo.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Davo on 6/5/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ArticleHolder> {
    private static ArrayList<Article> articles;

    public RecyclerAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public static class ArticleHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView publicationDateTextView;

        public ArticleHolder(View v) {
            super(v);

            this.titleTextView = (TextView) v.findViewById(R.id.title);
            this.sectionTextView = (TextView) v.findViewById(R.id.section);
            this.publicationDateTextView = (TextView) v.findViewById(R.id.publication_date);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");
            Context context = v.getContext();
            int itemPosition = getAdapterPosition();
            Article currentArticle = articles.get(itemPosition);
            String currentUrl = currentArticle.getUrl();
            Uri currentUri = Uri.parse(currentUrl);
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, currentUri);
            context.startActivity(websiteIntent);
        }
    }

    @Override
    public RecyclerAdapter.ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_view_layout, parent, false);
        return new ArticleHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ArticleHolder holder, int position) {
        Article article = articles.get(position);
        holder.titleTextView.setText(article.getTitle());
        holder.sectionTextView.setText(article.getSection());
        holder.publicationDateTextView.setText(article.getPublicationDate());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}