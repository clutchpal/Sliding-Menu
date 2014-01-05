package com.dealmigo;


import java.util.ArrayList;
import java.util.List;

import com.dealmigo.LinkAdapter;

import android.R;
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
                if (! (activity instanceof BookmarkListener) )
                        throw new ClassCastException();
                
                super.onAttach(activity);

        }





        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                        Bundle savedInstanceState) {                
                
                View v = inflater.inflate(R.layout.leftside_layout, container, true);
                ListView lView = (ListView) v.findViewById(R.id.bookList);
                LinkAdapter la = new LinkAdapter(new ArrayAdapter<String>(), getActivity());
                lView.setAdapter(la);
                lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                                ( (BookmarkListener) getActivity()).onLeftPaneMenuItemClick( bookmarkList.get(position).description );
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
        
        public interface BookmarkListener {
                public void onLeftPaneMenuItemClick(String bookmark);
        }
}
