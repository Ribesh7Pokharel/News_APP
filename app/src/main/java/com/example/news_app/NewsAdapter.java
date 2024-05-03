package com.example.news_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news_app.MainActivity;
import com.example.news_app.NewsFragment;
import com.example.news_app.NewsItem;
import com.example.news_app.R;
import com.example.news_app.NewsItem;  // Only necessary if they are in different packages


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<NewsItem> newsList;
    private LayoutInflater inflater;

    public NewsAdapter(Context context, List<NewsItem> newsList) {
        this.context = context;
        this.newsList = newsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsItem news = newsList.get(position);
        holder.title.setText(news.getTitle());
        // You might want to load images using Glide or Picasso
        // Glide.with(context).load(news.getImageUrl()).into(holder.image);
        holder.itemView.setOnClickListener(v -> openNewsFragment(news));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            image = itemView.findViewById(R.id.imageViewNewsItem);
        }
    }

    private void openNewsFragment(NewsItem news) {
        NewsFragment fragment = NewsFragment.newInstance(news);
        ((MainActivity) context).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}
