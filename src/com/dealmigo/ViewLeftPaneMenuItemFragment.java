package com.dealmigo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewLeftPaneMenuItemFragment extends Fragment {


        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                        Bundle savedInstanceState) {
        	// TODO Create Selected Menu Item UI in Right Pane
                
                View v = inflater.inflate(R.layout.userhubmenuitem_layout, container, false);
                setHasOptionsMenu(true);
                return v;
        }
        
        
        
        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                inflater.inflate(R.menu.right_menu, menu);
        }



        public void createSelectedMenuItemUI(String link) {
                if (link != null) {
                   // TODO Create Selected Menu Item UI in Right Pane    
                }
        }
        
}
