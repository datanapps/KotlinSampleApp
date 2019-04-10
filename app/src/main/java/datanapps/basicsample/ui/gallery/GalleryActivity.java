package datanapps.basicsample.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import datanapps.basicsample.R;
import datanapps.basicsample.ui.BaseActivity;
import datanapps.basicsample.ui.aboutus.AboutUsActivity;
import datanapps.basicsample.ui.home.Movie;
import datanapps.basicsample.ui.home.MoviesAdapter;
import datanapps.basicsample.ui.login.LoginActivity;
import datanapps.basicsample.utils.Constants;
import datanapps.basicsample.utils.DNASharedPreferenceUtils;
import datanapps.basicsample.utils.DNASnackBar;
import datanapps.basicsample.utils.Utils;

public class GalleryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        setMoviewList();
    }



    private void setMoviewList() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new GalleryViewPagerAdapter(this, getMoviesData()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                DNASnackBar.show(GalleryActivity.this, "selected page"+(i+1));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private List<Movie> getMoviesData() {

        List<Movie> movieList = new ArrayList<>();

        Movie movie = new Movie("Marvel-Movies", "Action & Adventure", "2010");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Baahubali", "Action & Adventurey", "2015");
        movie.setImgUrl("https://data1.ibtimes.co.in/cache-img-1200-675/en/full/671991/1512784860_top-ten-tamil-movies-chennai-box-office-baahubali-2.jpg");
        movieList.add(movie);

        movie = new Movie("Misson Instaanbul", "Action & Adventurey", "2015");
        movie.setImgUrl("https://s3.scoopwhoop.com/aka/worstbolly/14.jpg");
        movieList.add(movie);


        movie = new Movie("Saheb Bibi Aur Gangaster", "Action & Adventurey", "2016");
        movie.setImgUrl("https://im.rediff.com/movies/2013/mar/07royals-in-bollywood1.jpg");
        movieList.add(movie);


        movie = new Movie("Piku", "love & family", "2017");
        movie.setImgUrl("https://d3de4ohto533o1.cloudfront.net/wp-content/uploads/2017/04/netflix-bollywood-movie.jpg");
        movieList.add(movie);

        movie = new Movie("Laaga-Chunari-Mein-Daag", "Love & family", "2014");
        movie.setImgUrl("https://i.ytimg.com/vi/NwQg2X9EsAo/maxresdefault.jpg");
        movieList.add(movie);

        movie = new Movie("Border", "Patriotic", "1997");
        movie.setImgUrl("https://s3.scoopwhoop.com/anj/border/56eeda25-ad33-41d4-9e02-48385d6464fa.jpg");
        movieList.add(movie);

        movie = new Movie("Gangs Of Vasseypur", "Action & Adventurey", "2017");
        movie.setImgUrl("https://media0.mensxp.com/media/content/2017/Sep/here-are-7-bollywood-movies-that-were-based-on-based-on-real-stories1400-1506694790_1100x513.jpg");
        movieList.add(movie);

        movie = new Movie("Nirdosh", "Action & Adventurey", "2018");
        movie.setImgUrl("https://viralend.com/wp-content/uploads/2019/04/Nirdosh-2018-1080p-Full-HD-Movie-400x212.jpg");
        movieList.add(movie);


        movie = new Movie("Kick", "Action & Adventurey", "2014");
        movie.setImgUrl("https://www.leisuremartini.com/wp-content/uploads/2014/07/kick-poster.jpg");
        movieList.add(movie);

        movie = new Movie("Azaan", "Action & Adventurey", "2014");
        movie.setImgUrl("https://i.ytimg.com/vi/ocTq8mYEGGE/maxresdefault.jpg");
        movieList.add(movie);

        movie = new Movie("Bhaag-Milkha-Bhaag", "Action & Adventurey", "2014");
        movie.setImgUrl("https://static-bebeautiful-in.unileverservices.com/bhaag-milkha-bhaag-bollywood-movie-based-on-real-life-story.jpg");
        movieList.add(movie);


        movie = new Movie("Devdass", "Romantic", "2008");
        movie.setImgUrl("https://phpnepal.org.np/images/PUBLICATION-NEWS/Featured-Articles/alcohol-bollywood-movie-por.jpg");
        movieList.add(movie);

        movie = new Movie("Marvel-Movies", "Action & Adventure", "2010");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Baahubali", "Action & Adventurey", "2015");
        movie.setImgUrl("https://data1.ibtimes.co.in/cache-img-1200-675/en/full/671991/1512784860_top-ten-tamil-movies-chennai-box-office-baahubali-2.jpg");
        movieList.add(movie);

        movie = new Movie("Misson Instaanbul", "Action & Adventurey", "2015");
        movie.setImgUrl("https://s3.scoopwhoop.com/aka/worstbolly/14.jpg");
        movieList.add(movie);


        movie = new Movie("Saheb Bibi Aur Gangaster", "Action & Adventurey", "2016");
        movie.setImgUrl("https://im.rediff.com/movies/2013/mar/07royals-in-bollywood1.jpg");
        movieList.add(movie);


        movie = new Movie("Piku", "love & family", "2017");
        movie.setImgUrl("https://d3de4ohto533o1.cloudfront.net/wp-content/uploads/2017/04/netflix-bollywood-movie.jpg");
        movieList.add(movie);

        return movieList;
    }

}
