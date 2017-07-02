package com.example.gsabev.diceroller.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.gsabev.diceroller.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerNavigatinFragment extends Fragment {

    Fragment fragmentNew;
    public DrawerNavigatinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_drawer_navigatin, container, false);

        return root;


    }

    @Override
    public void onStart() {
        super.onStart();
        this.setupDrawer();
    }

    private void setupDrawer() {
        View root = this.getView();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName(R.string.drawer_item_home);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName(R.string.drawer_item_game);

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.drawer_toolbar);
        Fragment fragment = null;
        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this.getActivity())
                .withToolbar(toolbar)
                .withCloseOnClick(true)
              .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        item1,
                        item2)
                .withOnDrawerItemClickListener((view, position, drawerItem) ->  {
                    switch (view.getId()){
                        case 1:
                            changeToFragment(1);
                            break;
                        case 2:
                            changeToFragment(2);
                            break;
                    }
                    return true;
                })
                .build();
        result.closeDrawer();
    }

    private void changeToFragment(int i) {


        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (i == 1){
           DiceMainFragment diceMain = new DiceMainFragment();
            transaction.replace(R.id.article_fragment, diceMain);
        }else if (i == 2){
            DiceGameFragment diceGame = new DiceGameFragment();
            transaction.replace(R.id.article_fragment, diceGame);
        }
        transaction.commit();
    }
}
