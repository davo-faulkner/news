package co.davo.news;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Davo on 6/5/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ArticleHolder> {
    private ArrayList<Article> articles;

    public RecyclerAdapter(ArrayList<Article> articles) {
        this.articles = articles;
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
