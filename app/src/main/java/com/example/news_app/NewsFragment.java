package com.example.news_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {
    private NewsItem newsItem;

    public static NewsFragment newInstance(NewsItem newsItem) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putSerializable("news", newsItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        if (getArguments() != null) {
            newsItem = (NewsItem) getArguments().getSerializable("news");
            ((ImageView) view.findViewById(R.id.imageViewNews)).setImageResource(R.drawable.news_image_placeholder); // Placeholder image
            ((TextView) view.findViewById(R.id.textViewDescription)).setText(newsItem.getDescription());
        }
        return view;
    }
}
