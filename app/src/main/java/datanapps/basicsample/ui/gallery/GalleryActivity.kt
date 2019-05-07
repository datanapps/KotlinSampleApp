package datanapps.basicsample.ui.gallery

import android.os.Bundle
import datanapps.basicsample.R
import datanapps.basicsample.ui.BaseActivity
import datanapps.basicsample.ui.home.Movie
import datanapps.basicsample.utils.DNASnackBar
import java.util.*

class GalleryActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)


        setMoviewList()
    }


    private fun setMoviewList() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = GalleryViewPagerAdapter(this, moviesData)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {

            }

            override fun onPageSelected(i: Int) {
                DNASnackBar.show(this@GalleryActivity, "Selected Page  : " + (i + 1))
            }

            override fun onPageScrollStateChanged(i: Int) {

            }
        })
    }

    private val moviesData: List<Movie>
        get() {

            val movieList = ArrayList<Movie>()

            var movie = Movie("Marvel-Movies", "Action & Adventure", "2010")
            movie.imgUrl = "https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg"
            movieList.add(movie)

            movie = Movie("Baahubali", "Action & Adventurey", "2015")
            movie.imgUrl = "https://data1.ibtimes.co.in/cache-img-1200-675/en/full/671991/1512784860_top-ten-tamil-movies-chennai-box-office-baahubali-2.jpg"
            movieList.add(movie)

            movie = Movie("Misson Instaanbul", "Action & Adventurey", "2015")
            movie.imgUrl = "https://s3.scoopwhoop.com/aka/worstbolly/14.jpg"
            movieList.add(movie)


            movie = Movie("Saheb Bibi Aur Gangaster", "Action & Adventurey", "2016")
            movie.imgUrl = "https://im.rediff.com/movies/2013/mar/07royals-in-bollywood1.jpg"
            movieList.add(movie)


            movie = Movie("Piku", "love & family", "2017")
            movie.imgUrl = "https://d3de4ohto533o1.cloudfront.net/wp-content/uploads/2017/04/netflix-bollywood-movie.jpg"
            movieList.add(movie)

            movie = Movie("Laaga-Chunari-Mein-Daag", "Love & family", "2014")
            movie.imgUrl = "https://i.ytimg.com/vi/NwQg2X9EsAo/maxresdefault.jpg"
            movieList.add(movie)

            movie = Movie("Border", "Patriotic", "1997")
            movie.imgUrl = "https://s3.scoopwhoop.com/anj/border/56eeda25-ad33-41d4-9e02-48385d6464fa.jpg"
            movieList.add(movie)

            movie = Movie("Gangs Of Vasseypur", "Action & Adventurey", "2017")
            movie.imgUrl = "https://media0.mensxp.com/media/content/2017/Sep/here-are-7-bollywood-movies-that-were-based-on-based-on-real-stories1400-1506694790_1100x513.jpg"
            movieList.add(movie)

            movie = Movie("Nirdosh", "Action & Adventurey", "2018")
            movie.imgUrl = "https://viralend.com/wp-content/uploads/2019/04/Nirdosh-2018-1080p-Full-HD-Movie-400x212.jpg"
            movieList.add(movie)


            movie = Movie("Kick", "Action & Adventurey", "2014")
            movie.imgUrl = "https://www.leisuremartini.com/wp-content/uploads/2014/07/kick-poster.jpg"
            movieList.add(movie)

            movie = Movie("Azaan", "Action & Adventurey", "2014")
            movie.imgUrl = "https://i.ytimg.com/vi/ocTq8mYEGGE/maxresdefault.jpg"
            movieList.add(movie)

            movie = Movie("Bhaag-Milkha-Bhaag", "Action & Adventurey", "2014")
            movie.imgUrl = "https://static-bebeautiful-in.unileverservices.com/bhaag-milkha-bhaag-bollywood-movie-based-on-real-life-story.jpg"
            movieList.add(movie)


            movie = Movie("Devdass", "Romantic", "2008")
            movie.imgUrl = "https://phpnepal.org.np/images/PUBLICATION-NEWS/Featured-Articles/alcohol-bollywood-movie-por.jpg"
            movieList.add(movie)

            movie = Movie("Marvel-Movies", "Action & Adventure", "2010")
            movie.imgUrl = "https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg"
            movieList.add(movie)

            movie = Movie("Baahubali", "Action & Adventurey", "2015")
            movie.imgUrl = "https://data1.ibtimes.co.in/cache-img-1200-675/en/full/671991/1512784860_top-ten-tamil-movies-chennai-box-office-baahubali-2.jpg"
            movieList.add(movie)

            movie = Movie("Misson Instaanbul", "Action & Adventurey", "2015")
            movie.imgUrl = "https://s3.scoopwhoop.com/aka/worstbolly/14.jpg"
            movieList.add(movie)


            movie = Movie("Saheb Bibi Aur Gangaster", "Action & Adventurey", "2016")
            movie.imgUrl = "https://im.rediff.com/movies/2013/mar/07royals-in-bollywood1.jpg"
            movieList.add(movie)


            movie = Movie("Piku", "love & family", "2017")
            movie.imgUrl = "https://d3de4ohto533o1.cloudfront.net/wp-content/uploads/2017/04/netflix-bollywood-movie.jpg"
            movieList.add(movie)

            return movieList
        }


}
