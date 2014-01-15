package com.linkedFluuuush.warhammerToolsForAndroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedFluuuush.warhammerToolsForAndroid.R;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 15/01/14
 * Time: 15:00
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class DisplayMainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.display_character, container, false);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (rootView.findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return rootView;
            }

            // Create a new Fragment to be placed in the activity layout
            HelloWorldFragment firstFragment = new HelloWorldFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getActivity().getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

        return rootView;
    }

}
