package com.example.viewandgroupview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

public class MovieList extends AppCompatActivity {

    final static String TAG = "MoviesList dit: ";

    private Movies[] movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);
        Intent intent = getIntent();

        RecyclerView recyclerView =
                (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        this.movies=Movies.initMovie();
        MoviesAdapter adapter = new MoviesAdapter(movies);

        recyclerView.setAdapter(adapter);

        adapter.setListener(new MoviesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.i(TAG, "Clicked " + movies[position].getTitle());
            }
        });


    }

}
