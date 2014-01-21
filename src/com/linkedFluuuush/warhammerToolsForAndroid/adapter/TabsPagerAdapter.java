package com.linkedFluuuush.warhammerToolsForAndroid.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.linkedFluuuush.warhammerToolsForAndroid.fragment.DisplayFragment;
import com.linkedFluuuush.warhammerToolsForAndroid.fragment.DisplayMainFragment;
import com.linkedFluuuush.warhammerToolsForAndroid.fragment.UtilsFragment;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: linked
 * Date: 07/01/14
 * Time: 15:26
 *
 * @author Jean-Baptiste Louvet jbaptiste.louvet@gmail.com
 * @version 1.0
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    LinkedList<Fragment> displayFragmentLinkedList;
    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
        displayFragmentLinkedList = new LinkedList<Fragment>();
    }

    @Override
    public Fragment getItem(int position) {
        return displayFragmentLinkedList.get(position);
    }

    @Override
    public int getCount() {
        return displayFragmentLinkedList.size();
    }

    public void addFragment(){
        displayFragmentLinkedList.add(new DisplayFragment());
        notifyDataSetChanged();
    }

    public void addUtilsFragment(){
        displayFragmentLinkedList.add(new UtilsFragment());
        notifyDataSetChanged();
    }
}
