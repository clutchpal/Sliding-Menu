package com.dealmigo;


import java.util.ArrayList;
import java.util.List;

import com.dealmigo.LinkAdapter;



import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class LeftPaneMenuItemListFragment extends Fragment {
        
        @Override
        public void onAttach(Activity activity) {                
                
                // It's time we check if our activity implements the right inteface
                if (! (activity instanceof UserHubMenuListener) )
                        throw new ClassCastException();
                
                super.onAttach(activity);

        }





        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                        Bundle savedInstanceState) {                
                
                View v = inflater.inflate(R.layout.leftpane_layout,container, true);
                ListView lView = (ListView) v.findViewById(R.id.userhub);
                LinkAdapter la = new LinkAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_1, userhubmenulist);
                lView.setAdapter(la);
                lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                                ( (UserHubMenuListener) getActivity()).onLeftPaneMenuItemClick( userhubmenulist );
                        }
                });
                setHasOptionsMenu(true);
                return v;
        }

        

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                //super.onCreateOptionsMenu(menu, inflater);
                inflater.inflate(R.menu.left_menu, menu);
        }
        
        public interface UserHubMenuListener {
                public void onLeftPaneMenuItemClick(String bookmark);
        }
}
