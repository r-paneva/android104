package com.example.rumy.android104.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rumy.android104.views.SuperheroCreate.SuperheroCreateActivity;
import com.example.rumy.android104.views.superheroesList.SuperheroesListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class BaseDrawerActivity extends AppCompatActivity {


    private void setupDrawer() {
        //if you want to update the items at a later time it is recommended to keep it in a variable

//create the drawer and remember the `Drawer` result object
        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(SuperheroCreateActivity.IDENTIFIER).withName("Create superhero").withIcon(android.R.drawable.btn_radio),
                        new PrimaryDrawerItem().withIdentifier(SuperheroesListActivity.IDENTIFIER).withName("Superheroes").withIcon(android.R.drawable.progress_horizontal)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) return false;

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) return false;

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier==SuperheroesListActivity.IDENTIFIER) {
            return new Intent(BaseDrawerActivity.this, SuperheroesListActivity.class);
        }else if(identifier==SuperheroCreateActivity.IDENTIFIER){
            return new Intent(BaseDrawerActivity.this, SuperheroCreateActivity.class);        }

        return null;
    }


    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected  void onStart(){
        super.onStart();
        setupDrawer();
    }

}
