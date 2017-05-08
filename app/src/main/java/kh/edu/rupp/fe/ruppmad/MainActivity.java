package kh.edu.rupp.fe.ruppmad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * RUPPMAD
 * Created by leapkh on 1/3/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    private DocumentsFragment documentsFragment;
    private boolean isFragmentShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        // Navigation View
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);

        // Navigation View Header
        View navigationHeaderView = navigationView.getHeaderView(0);
        navigationHeaderView.findViewById(R.id.txt_edit).setOnClickListener(this);
        navigationHeaderView.findViewById(R.id.txt_logout).setOnClickListener(this);

        // Actionbar Drawer
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Apply username
        String username = getIntent().getStringExtra("username");
        TextView txtUsername = (TextView) navigationHeaderView.findViewById(R.id.txt_username);
        txtUsername.setText(username);

        onDocumentsClick();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_logout:
                doLogout();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (isFragmentShowing) {
            showFragment(null);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("rupp", "onContextItemSelected");
        return true;
    }

    private void doLogout() {
        // Clear username preference
        SharedPreferences preference = getSharedPreferences(LoginActivity.PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(LoginActivity.KEY_USERNAME, null);
        editor.commit();

        // Show login form
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void showFragment(Fragment fragment) {

    }

    private void onDocumentsClick() {
        DocumentsFragment documentsFragment = new DocumentsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.lyt_content, documentsFragment, documentsFragment.getTag()).commit();
    }

    private void onAssignmentClick() {
        AssignmentFragment assignmentFragment = new AssignmentFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.lyt_content, assignmentFragment, assignmentFragment.getTag()).commit();
    }

    private void addFragments() {

    }

    private void showDialogMessage(String title, String message) {
        // Just test with Git
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("rupp", "Menu click");
        switch (item.getItemId()) {
            case R.id.mnu_documents:
                onDocumentsClick();
                break;
            case R.id.mnu_assignment:
                onAssignmentClick();
                break;
            case R.id.mnu_settings:
                SettingsFragment settingsFragment = new SettingsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.lyt_content, settingsFragment, settingsFragment.getTag()).commit();
                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }
}
