package datanapps.basicsample.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import datanapps.basicsample.R;
import datanapps.basicsample.utils.DNASnackBar;
import datanapps.basicsample.utils.Utils;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    private Context context;

    public MoviesAdapter(Context context, List<Movie> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_movie_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        Glide
                .with(context)
                .load(movie.getImgUrl())
                .apply(new RequestOptions().centerCrop())
                .into( holder.movieImage);
        holder.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Utils.shareAppDetail(context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView movieImage;
        public ImageView imgShare;
        public MyViewHolder(View view) {
            super(view);
            movieImage = view.findViewById(R.id.movie_image);
            imgShare = view.findViewById(R.id.img_share);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.genre);
            year =  view.findViewById(R.id.year);
        }
    }
}