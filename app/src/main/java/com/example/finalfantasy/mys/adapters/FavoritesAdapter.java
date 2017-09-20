package com.example.finalfantasy.mys.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalfantasy.mys.R;
import com.example.finalfantasy.mys.fragmentClases.FragmentFavorites;

/**
 * Created by FinalFantasy on 19.09.2017.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewFavorit> {

    private java.util.List<String> mPosts;

    public FavoritesAdapter(java.util.List<String> posts) {
        this.mPosts = posts;
    }

    @Override
    public ViewFavorit onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_holder, parent, false);
        return new ViewFavorit(v);
    }

    @Override
    public void onBindViewHolder(ViewFavorit holder, int position) {
        String mf= mPosts.get(position);
        holder.setViev(mf);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }


    class ViewFavorit extends RecyclerView.ViewHolder {
        TextView mDat;

        public ViewFavorit(final View itemView) {
            super(itemView);
            mDat=itemView.findViewById(R.id.favCit);

            mDat.setOnClickListener(FragmentFavorites.mCll);
        }

        public void setViev(String v)
        {
            mDat.setText(v);
        }
    }
}