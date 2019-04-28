package com.example.viewandgroupview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.content.Context;
import android.view.View;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onClick(int position);
    }

    private Movies[] movies;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView layout;

        public ViewHolder(CardView v) {
            super(v);
            layout = v;
        }
    }

    public MoviesAdapter(Movies[]movies){
        this.movies=movies;
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.layout;
        TextView title = (TextView) cardView.findViewById(R.id.title);
        TextView year = (TextView) cardView.findViewById(R.id.year);
        TextView director = cardView.findViewById(R.id.director);

        Context context = cardView.getContext();

        Movies film = movies[position];
        title.setText(film.getTitle());
        year.setText(context.getResources().getString(R.string.listview_year)
                + movies[position].getTitle());
        director.setText(film.getDirector());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
