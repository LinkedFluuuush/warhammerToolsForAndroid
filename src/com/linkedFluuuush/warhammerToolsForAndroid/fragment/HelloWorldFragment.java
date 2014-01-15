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
 * Time: 15:18
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class HelloWorldFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.utils_display, container, false);

        return rootView;
    }
}
