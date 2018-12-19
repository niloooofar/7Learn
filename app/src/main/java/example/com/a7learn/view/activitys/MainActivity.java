package example.com.a7learn.view.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import example.com.a7learn.DataFakeGenerator;
import example.com.a7learn.R;
import example.com.a7learn.adapters.AppFeaturesAdapter;

public class MainActivity extends AppCompatActivity {

    private AppFeaturesAdapter appFeaturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        setUpRecyclerView();
        setupToolbar();
        setupNavigationView();

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordiantor_layout);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "fab clicked!", Snackbar.LENGTH_LONG)
                        .setAction("retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Retry Button Clicked!",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

    }

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_menu_profile:
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        break;
                    case R.id.navigation_menu_store:
                        startActivity(new Intent(MainActivity.this, BotikActivity.class));

                }
                return true;
            }
        });
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        appFeaturesAdapter = new AppFeaturesAdapter(this);
        recyclerView.setAdapter(appFeaturesAdapter);
        appFeaturesAdapter.setAppFeatures(DataFakeGenerator.getAppFeatures(this));
    }

    private void setupToolbar() {
        DrawerLayout drawerLayout = findViewById(R.id.drawyer_layout);
        setUpRecyclerView();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }
}
