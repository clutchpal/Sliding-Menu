package com.dealmigo;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.Menu;
import android.view.View;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTabHost;

import com.dealmigo.LeftPaneMenuItemListFragment.UserHubMenuListener;

public class UserHubActivity extends FragmentActivity implements UserHubMenuListener{
        SlidingPaneLayout pane;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.userhub_activity);
                pane = (SlidingPaneLayout) findViewById(R.id.sp);
                pane.setPanelSlideListener(new PaneListener());
                
                if (!pane.isSlideable()) {
                        getSupportFragmentManager().findFragmentById(R.id.leftpane).setHasOptionsMenu(false);
                        getSupportFragmentManager().findFragmentById(R.id.rightpane).setHasOptionsMenu(true);
                }
        }


        
        private class PaneListener implements SlidingPaneLayout.PanelSlideListener {

                @Override
                public void onPanelClosed(View view) {
                        System.out.println("Panel closed");
                        
                        getSupportFragmentManager().findFragmentById(R.id.leftpane).setHasOptionsMenu(false);
                        getSupportFragmentManager().findFragmentById(R.id.rightpane).setHasOptionsMenu(true);
                }

                @Override
                public void onPanelOpened(View view) {
                        System.out.println("Panel opened");        
                        getSupportFragmentManager().findFragmentById(R.id.leftpane).setHasOptionsMenu(true);
                        getSupportFragmentManager().findFragmentById(R.id.rightpane).setHasOptionsMenu(false);
                }

                @Override
                public void onPanelSlide(View view, float arg1) {
                        System.out.println("Panel sliding"); 
                }
                
        }



        @Override
        public void onLeftPaneMenuItemClick(String bookmark) {
                // We get notified when user clicks on a bookmark in the ListBookmarkFragment
                System.out.println("Bookmark ["+bookmark+"]");
                ViewLeftPaneMenuItemFragment f = (ViewLeftPaneMenuItemFragment) getSupportFragmentManager().findFragmentById(R.id.rightpane);
                f.createSelectedMenuItemUI(bookmark);
                
        }

}
