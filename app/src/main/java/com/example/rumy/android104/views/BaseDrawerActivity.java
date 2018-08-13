package com.example.rumy.android104.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.rumy.android104.R;
import com.example.rumy.android104.views.superheroCreate.SuperheroCreateActivity;
import com.example.rumy.android104.views.superheroesList.SuperheroesListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class BaseDrawerActivity extends AppCompatActivity {

    private void setupDrawer() {
        //if you want to update the items at a later time it is recommended to keep it in a variable
        @SuppressLint("ResourceAsColor") PrimaryDrawerItem listSuperheroesItem = new PrimaryDrawerItem()
                .withIdentifier(SuperheroesListActivity.IDENTIFIER)
                .withIcon(R.drawable.common_google_signin_btn_icon_dark)
                .withIconColor(R.color.material_drawer_dark_primary_icon)
                .withName("Superheroes");
        @SuppressLint("ResourceAsColor") PrimaryDrawerItem createSuperheroItem = new PrimaryDrawerItem()
                .withIdentifier(SuperheroCreateActivity.IDENTIFIER)
                .withIcon(R.drawable.common_google_signin_btn_icon_dark)
                .withIconColor(R.color.material_drawer_dark_primary_icon)
                .withName("Create superhero");

//create the drawer and remember the `Drawer` result object
        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .addDrawerItems(
                        listSuperheroesItem,
                        new DividerDrawerItem(),
                        createSuperheroItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();
                        if(getIdentifier() == identifier){
                            return false;
                        }
                        Class<AppCompatActivity> activityClass;

                        if (identifier==SuperheroesListActivity.IDENTIFIER){
                            Intent intent = new Intent(BaseDrawerActivity.this, SuperheroesListActivity.class);
                            startActivity(intent);
                        } else if (identifier==SuperheroCreateActivity.IDENTIFIER){
                            Intent intent = new Intent(BaseDrawerActivity.this, SuperheroCreateActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        return false;
                    }
                })
                .build();
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected  void onStart(){
        super.onStart();
        setupDrawer();
    }

}
