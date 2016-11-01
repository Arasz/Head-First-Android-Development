package com.example.raraszkiewicz.wloskieconieco.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.raraszkiewicz.wloskieconieco.Fragments.PastaFragment;
import com.example.raraszkiewicz.wloskieconieco.Fragments.PizzaFragment;
import com.example.raraszkiewicz.wloskieconieco.Fragments.StoresFragment;
import com.example.raraszkiewicz.wloskieconieco.Fragments.TopFragment;
import com.example.raraszkiewicz.wloskieconieco.R;
import com.example.raraszkiewicz.wloskieconieco.Utils.FragmentReplacer;

import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    private Dictionary<String, Class> categoriesDictionary;
    private String[] categories;
    private FragmentReplacer fragmentReplacer;
    int position = 0;

    @BindView(R.id.drawer)
    ListView drawerList;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle drawerToggle;

    private int findPosition(Fragment visibleFragment)
    {
        int categoryPosition = 0;
        if(visibleFragment instanceof PastaFragment)
            categoryPosition = 2;
        if(visibleFragment instanceof PizzaFragment)
            categoryPosition = 1;
        if(visibleFragment instanceof StoresFragment)
            categoryPosition = 3;

        return categoryPosition;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeDictionary();

        configureFragmentManagment();

        enableActionBarButtons();

        configureDrawerList();

        configureDrawerListener();

        initializeSelectedCategory(savedInstanceState);
    }

    private void configureFragmentManagment() {
        final FragmentManager fragmentManager = getFragmentManager();
        fragmentReplacer = new FragmentReplacer(fragmentManager, R.id.content_frame);
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = fragmentManager.findFragmentByTag("visible_fragment");
                position = findPosition(fragment);
                setActionBarTitle(position);
                drawerList.setItemChecked(position, true);
            }
        });
    }

    private void initializeSelectedCategory(Bundle savedInstanceState) {
        if(savedInstanceState == null)
            position = 0;
        else
            position = savedInstanceState.getInt("position");
        selectCategory(position);
    }

    private void configureDrawerListener() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.close_drawer, R.string.close_drawer)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
    }

    private void configureDrawerList() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.titles));
        drawerList.setAdapter(arrayAdapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private void enableActionBarButtons() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_order).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    private void setActionBarTitle(int categoryPosition)
    {
        String title;
        if(categoryPosition == 0)
            title = getResources().getString(R.string.app_name);
        else
            title = categories[categoryPosition];
        getActionBar().setTitle(title);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("position",position);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId())
        {
            case R.id.action_settings:
                return true;
            case R.id.action_order:
                makeOrder();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void makeOrder()
    {
        Intent orderIntent = new Intent(this, OrderActivity.class);
        startActivity(orderIntent);
    }

    private void selectCategory(int position)
    {
        try {
            this.position = position;
            Fragment fragment = (Fragment) categoriesDictionary
                    .get(categories[position])
                    .getConstructor()
                    .newInstance();
            fragmentReplacer.replace(fragment);
            setActionBarTitle(position);
            drawerLayout.closeDrawer(drawerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeDictionary()
    {
        if(categoriesDictionary != null)
            return;
        categories = getResources().getStringArray(R.array.titles);
        categoriesDictionary = new Hashtable<>();
        categoriesDictionary.put(categories[0], TopFragment.class);
        categoriesDictionary.put(categories[1], PizzaFragment.class);
        categoriesDictionary.put(categories[2], PastaFragment.class);
        categoriesDictionary.put(categories[3], StoresFragment.class);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectCategory(position);
        }
    }
}
