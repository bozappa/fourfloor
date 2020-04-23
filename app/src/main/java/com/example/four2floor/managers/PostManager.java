package com.example.four2floor.managers;

import android.content.Context;
import android.util.Log;

import com.example.four2floor.ApplicationHelper;
import com.example.four2floor.managers.listeners.OnDataChangedListener;
import com.example.four2floor.model.Post;

public class PostManager {

    private static final String TAG = PostManager.class.getSimpleName();
    private static PostManager instance;

    private Context context;

    public static PostManager getInstance(Context context) {
        if (instance == null) {
            instance = new PostManager(context);
        }

        return instance;
    }

    private PostManager(Context context) {
        this.context = context;
    }

    public void createOrUpdatePost(Post post) {
        try {
            ApplicationHelper.getDatabaseHelper().createOrUpdatePost(post);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void getPosts(OnDataChangedListener<Post> onDataChangedListener) {
        ApplicationHelper.getDatabaseHelper().getPostList(onDataChangedListener);
    }
}