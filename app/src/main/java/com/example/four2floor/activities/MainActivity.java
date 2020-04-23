package com.example.four2floor.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.four2floor.adapters.PostsAdapter;
import com.example.four2floor.managers.PostManager;
import com.example.four2floor.managers.listeners.OnDataChangedListener;
import com.example.four2floor.model.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.four2floor.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView postsListView;
    private PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postsListView = (ListView)findViewById(R.id.postsListView);
        postsAdapter = new PostsAdapter();
        postsListView.setAdapter(postsAdapter);

        OnDataChangedListener<Post> onPostsDataChangedListener = new OnDataChangedListener<Post>() {
            @Override
            public void onListChanged(List<Post> list) {
                postsAdapter.setList(list);
            }
        };

        PostManager.getInstance(getApplicationContext()).getPosts(onPostsDataChangedListener);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.addNewPostFab);

        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCreatePostActivity();
                }
            });
        }
    }

    private void openCreatePostActivity() {
        Intent intent = new Intent(this, CreatePostActivity.class);
        startActivity(intent);
    }
}