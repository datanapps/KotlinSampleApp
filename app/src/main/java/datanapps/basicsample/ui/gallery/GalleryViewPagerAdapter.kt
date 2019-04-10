package datanapps.basicsample.ui.gallery

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import datanapps.basicsample.R
import datanapps.basicsample.ui.home.Movie
import datanapps.basicsample.utils.Utils

class GalleryViewPagerAdapter(private val context: Context, private val moviesList: List<Movie>) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_movie_list, collection, false) as ViewGroup

        val movieImage = view.findViewById<ImageView>(R.id.movie_image)
        val imgShare = view.findViewById<ImageView>(R.id.img_share)
        val title = view.findViewById<TextView>(R.id.title)
        val genre = view.findViewById<TextView>(R.id.genre)
        val year = view.findViewById<TextView>(R.id.year)

        val movie = moviesList[position]
        title.text = movie.title
        genre.text = movie.genre
        year.text = movie.year
        Glide
                .with(context)
                .load(movie.imgUrl)
                .apply(RequestOptions().centerCrop())
                .into(movieImage)
        imgShare.setOnClickListener { Utils.shareAppDetail(context) }
        collection.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return this.moviesList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }
}