package com.PradipSahoo7722.ciphertalk.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.PradipSahoo7722.ciphertalk.Fragments.ChatsFragment;
import com.PradipSahoo7722.ciphertalk.Fragments.GroupsFragment;
import com.PradipSahoo7722.ciphertalk.Fragments.StoriesFragment;

public class FragmentsAdapter extends FragmentStateAdapter {


    public FragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new GroupsFragment();

            case 2:
                return new StoriesFragment();
        }
        return new ChatsFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
