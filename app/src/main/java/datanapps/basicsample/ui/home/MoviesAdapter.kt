package datanapps.basicsample.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import datanapps.basicsample.R
import datanapps.basicsample.utils.Utils

class MoviesAdapter(private val context: Context, private val moviesList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_movie_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year
        Glide
                .with(context)
                .load(movie.imgUrl)
                .apply(RequestOptions().centerCrop())
                .into(holder.movieImage)
        holder.imgShare.setOnClickListener { Utils.shareAppDetail(context) }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var year: TextView
        var genre: TextView
        var movieImage: ImageView
        var imgShare: ImageView

        init {
            movieImage = view.findViewById(R.id.movie_image)
            imgShare = view.findViewById(R.id.img_share)
            title = view.findViewById(R.id.title)
            genre = view.findViewById(R.id.genre)
            year = view.findViewById(R.id.year)
        }
    }
}