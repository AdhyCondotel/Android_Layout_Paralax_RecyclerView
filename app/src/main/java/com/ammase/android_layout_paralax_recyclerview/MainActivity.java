package com.ammase.android_layout_paralax_recyclerview;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ammase.android_layout_paralax_recyclerview.adapter.adapter_Icon;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.IconHintView;
import com.jude.rollviewpager.hintview.TextHintView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.roll_view_pager) RollPagerView mRollViewPager;

    @BindView(R.id.navigationMenuUtama_Navigasi) NavigationView navigationView;
    @BindView(R.id.DrawerLayoutMenuUtama_drawer) DrawerLayout drawerLayout;

    private adapter_Icon mAdapterIcon;
    private List<String> listIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        InitComponent();
        InitBanner();
    }

    private void InitBanner() {

        mRollViewPager.setPlayDelay(5000);
        mRollViewPager.setAnimationDurtion(2000);
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.RED,Color.WHITE));

        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager));


    }

    private class TestLoopAdapter extends LoopPagerAdapter{
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }

    private void InitComponent() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadIcon();
        mAdapterIcon = new adapter_Icon (this,listIcon);
        recyclerView.setAdapter(mAdapterIcon);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) menuItem.setChecked(false); else menuItem.setChecked(true); drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.akun:
                        //
                        return true;

                    case R.id.favorit:
                        //
                        return true;

                    default:
                        Toast.makeText(getApplication(), "Tidak ada yang terpilih", Toast.LENGTH_SHORT).show();
                        return true;

                }

            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }

    private void loadIcon() {
        listIcon= new ArrayList<String>();
        listIcon.add("Bakery");
        listIcon.add("Bolu");
        listIcon.add("Brownis");
        listIcon.add("Burger");
        listIcon.add("Cupcake");
        listIcon.add("Donut");
        listIcon.add("Kebab");
        listIcon.add("Krepes");
        listIcon.add("Pancake");
        listIcon.add("Puding");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
