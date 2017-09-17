package com.example.finalfantasy.mys;

/**
 * Created by FinalFantasy on 17.09.2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RcAdapter extends RecyclerView.Adapter<RcAdapter.RcHolder> {

    private List<com.example.finalfantasy.mys.model.List> posts;

    public RcAdapter(List<com.example.finalfantasy.mys.model.List> posts) {
        this.posts = posts;
    }

    @Override
    public RcHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc, parent, false);
        return new RcHolder(v);
    }

    @Override
    public void onBindViewHolder(RcHolder holder, int position) {
        com.example.finalfantasy.mys.model.List mf = posts.get(position);
        holder.setVievRc(mf);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class RcHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView hh;
        TextView res;
        TextView t;
        TextView dss;
        TextView wind;

        public RcHolder(View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.time);
            hh=itemView.findViewById(R.id.Hh);
            res=itemView.findViewById(R.id.res);
            t=itemView.findViewById(R.id.t);
            dss=itemView.findViewById(R.id.dss);
            wind=itemView.findViewById(R.id.wind);

        }

        public void setVievRc(com.example.finalfantasy.mys.model.List v)
        {
            time.setText(v.getDtTxt().substring(10,15));
            hh.setText(v.getMain().getHumidity().toString());
            res.setText(v.getMain().getPressure().toString());
            t.setText(v.getMain().getTempKf().toString());
            dss.setText(v.getWeather().get(0).getDescription());
            wind.setText(v.getWind().getSpeed().toString());

        }
    }
}

