package com.example.finalfantasy.mys.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalfantasy.mys.R;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<List<com.example.finalfantasy.mys.model.List>> mPosts;

    public PostsAdapter(List<List<com.example.finalfantasy.mys.model.List>> posts) {
        this.mPosts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.citys_holder, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<com.example.finalfantasy.mys.model.List> mf = mPosts.get(position);
        holder.setViev(mf);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mDat;
        RecyclerView mRc;
        List<com.example.finalfantasy.mys.model.List> mV;

        public ViewHolder(View itemView) {
            super(itemView);
            mDat = itemView.findViewById(R.id.dat);
            mRc = itemView.findViewById(R.id.rec);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            mRc.setLayoutManager(layoutManager);

        }

        public void setViev(List<com.example.finalfantasy.mys.model.List> v) {
            mDat.setText(v.get(0).getDtTxt().substring(0, 10));
            if (v == null)
                return;
            else
                mV = v;

            TimeAdapter adapter = new TimeAdapter(mV);
            mRc.setAdapter(adapter);
            mRc.getAdapter().notifyDataSetChanged();
        }
    }
}