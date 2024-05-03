package com.example.news_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewTopStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTopStories = findViewById(R.id.recyclerViewTopStories);
        recyclerViewTopStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopStories.setAdapter(new NewsAdapter(this, getMockNewsData()));
    }

    private List<NewsItem> getMockNewsData() {
        List<NewsItem> newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("Title 1", "Description 1", "ImageURL 1", new ArrayList<>()));
        // Populate more items as needed...
        return newsItems;
    }

    public void openNewsFragment(NewsItem news) {
        NewsFragment fragment = NewsFragment.newInstance(news);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}
