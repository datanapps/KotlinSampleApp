package datanapps.basicsample.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import datanapps.basicsample.ui.aboutus.AboutUsActivity;
import datanapps.basicsample.ui.login.LoginActivity;
import datanapps.basicsample.ui.splash.SplashActivity;
import datanapps.basicsample.utils.DNASnackBar;
import datanapps.basicsample.utils.Utils;

public class HomeActivity extends AppCompatActivity
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
        Toolbar toolbar =  findViewById(R.id.toolbar);
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

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movie.setImgUrl("https://media.wired.com/photos/59323a795c4fbd732b55153a/master/w_1000,c_limit/marvel-movies-inline.jpg");
        movieList.add(movie);

        return movieList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
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
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {


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
}
