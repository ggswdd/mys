package com.example.finalfantasy.mys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<List<com.example.finalfantasy.mys.model.List>> posts;

    public PostsAdapter(List<List<com.example.finalfantasy.mys.model.List>> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listr, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<com.example.finalfantasy.mys.model.List> mf= posts.get(position);
        holder.setViev(mf);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView dat;
        RecyclerView mRc;
        List<com.example.finalfantasy.mys.model.List> mV;

        public ViewHolder(View itemView) {
            super(itemView);
            dat=itemView.findViewById(R.id.dat);
            mRc=itemView.findViewById(R.id.res);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            mRc.setLayoutManager(layoutManager);

        }

            public void setViev(List<com.example.finalfantasy.mys.model.List> v)
        {
         dat.setText(v.get(0).getDtTxt().substring(0,10));
            if(v==null)
                return;
            else
            mV=v;

            RcAdapter adapter = new RcAdapter(mV);
            mRc.setAdapter(adapter);
            mRc.getAdapter().notifyDataSetChanged();
        }
    }
}