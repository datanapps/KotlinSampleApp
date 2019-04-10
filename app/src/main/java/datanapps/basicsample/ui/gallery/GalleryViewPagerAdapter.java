package datanapps.basicsample.ui.gallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import datanapps.basicsample.R;
import datanapps.basicsample.ui.home.Movie;
import datanapps.basicsample.utils.Utils;

public class GalleryViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Movie> moviesList;

    public GalleryViewPagerAdapter(Context context, List<Movie> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout_movie_list, collection, false);

        ImageView movieImage = view.findViewById(R.id.movie_image);
        ImageView imgShare = view.findViewById(R.id.img_share);
        TextView title = view.findViewById(R.id.title);
        TextView genre = view.findViewById(R.id.genre);
        TextView year =  view.findViewById(R.id.year);

        Movie movie = moviesList.get(position);
        title.setText(movie.getTitle());
        genre.setText(movie.getGenre());
        year.setText(movie.getYear());
        Glide
                .with(context)
                .load(movie.getImgUrl())
                .apply(new RequestOptions().centerCrop())
                .into( movieImage);
        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.shareAppDetail(context);
            }
        });
        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return this.moviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}