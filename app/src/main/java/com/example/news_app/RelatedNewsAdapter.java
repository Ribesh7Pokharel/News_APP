package com.example.news_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.news_app.NewsItem;


import com.example.news_app.R;

import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {
    private List<NewsItem> relatedNews;
    private LayoutInflater inflater;

    public RelatedNewsAdapter(Context context, List<NewsItem> relatedNews) {
        this.relatedNews = relatedNews;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.related_news_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsItem news = relatedNews.get(position);
        holder.title.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return relatedNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewRelatedTitle);
        }
    }
}
