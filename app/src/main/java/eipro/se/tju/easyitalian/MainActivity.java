package eipro.se.tju.easyitalian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.youngkaaa.ycircleview.CircleView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        CircleView profile = headerView.findViewById(R.id.profile_picture);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"call 个人资料 activity", Toast.LENGTH_SHORT).show();

                // personal info TODO
                Intent changeToPersonalInfoActivity=new Intent(MainActivity.this,PersonalInfoActivity.class);
                startActivity(changeToPersonalInfoActivity);

                //close the nav_view
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageView searchWordButton = findViewById(R.id.searchWordButton);
        searchWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"call 查单词 activity", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonForLearn = findViewById(R.id.button_learn);
        buttonForLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"call 背单词 activity", Toast.LENGTH_SHORT).show();
                Intent changeToRecitePage = new Intent(MainActivity.this,RecitePage.class);
                startActivity(changeToRecitePage);
            }
        });

        Button buttonForRead = findViewById(R.id.button_read);
        buttonForRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"call 读美文 activity", Toast.LENGTH_SHORT).show();
                //Intent changeToReadPage = new Intent(MainActivity.this,ReadPage.class);
               // startActivity(changeToReadPage);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_new_word) {
            Toast.makeText(MainActivity.this,"call 生词本 activity", Toast.LENGTH_SHORT).show();
            Intent changeToNewWord = new Intent(MainActivity.this,NewWords.class);
            startActivity(changeToNewWord);
        } else if (id == R.id.nav_finished_word) {
            Toast.makeText(MainActivity.this,"call 已完成单词 activity", Toast.LENGTH_SHORT).show();
            Intent changeToFinishedWord = new Intent(MainActivity.this,NewWords.class);
            startActivity(changeToFinishedWord);
        } else if (id == R.id.nav_coming_word) {
            Toast.makeText(MainActivity.this,"call 未背单词 activity", Toast.LENGTH_SHORT).show();
            Intent changeToComingWord = new Intent(MainActivity.this,NewWords.class);
            startActivity(changeToComingWord);
        } else if (id == R.id.nav_setting) {
            Toast.makeText(MainActivity.this,"call 未背单词 activity", Toast.LENGTH_SHORT).show();
            Intent changeToSettingPage = new Intent(MainActivity.this,Setting.class);
            startActivity(changeToSettingPage);
        } else if (id == R.id.nav_about) {
            Toast.makeText(MainActivity.this,"call 关于 activity", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
