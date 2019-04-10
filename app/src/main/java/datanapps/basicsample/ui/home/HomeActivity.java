package datanapps.basicsample.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import datanapps.basicsample.R;
import datanapps.basicsample.ui.BaseActivity;
import datanapps.basicsample.ui.aboutus.AboutUsActivity;
import datanapps.basicsample.ui.gallery.GalleryActivity;
import datanapps.basicsample.ui.login.LoginActivity;
import datanapps.basicsample.ui.splash.SplashActivity;
import datanapps.basicsample.utils.Constants;
import datanapps.basicsample.utils.DNASharedPreferenceUtils;
import datanapps.basicsample.utils.DNASnackBar;
import datanapps.basicsample.utils.Utils;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.sendMail(HomeActivity.this, getString(R.string.contact_us));
            }
        });

        setToolsAndNavigationDrawer();
        setMoviewList();
    }


    private void setToolsAndNavigationDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void setMoviewList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MoviesAdapter(this, getMoviesData()));

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            onBackDoubleClick();
        }
    }


    public void onBackDoubleClick() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        DNASnackBar.show(this, "Please click BACK again to exit");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            DNASharedPreferenceUtils.remove(Constants.IS_USER_LOGIN);
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            openCamera();
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(HomeActivity.this, GalleryActivity.class));
        } else if (id == R.id.nav_slideshow) {
            DNASnackBar.show(this, "create slide show page according to your application");
        } else if (id == R.id.nav_manage) {
            DNASnackBar.show(this, "create tools page according to your application");

        } else if (id == R.id.nav_share) {
            Utils.shareAppDetail(this);

        } else if (id == R.id.nav_send) {
            Utils.sendMail(this, getString(R.string.contact_us));

        } else if (id == R.id.nav_about_us) {
            startActivity(new Intent(HomeActivity.this, AboutUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void openCamera() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // only for gingerbread and newer versions

            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            } else {
                DNASnackBar.show(getBaseContext(), "Allow camera permission");
                Intent myAppSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                myAppSettings.addCategory(Intent.CATEGORY_DEFAULT);
                myAppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(myAppSettings);

            }
        } else {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);
        }

    }
}
