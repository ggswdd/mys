package com.example.finalfantasy.mys.adapters;

/**
 * Created by FinalFantasy on 17.09.2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.finalfantasy.mys.R;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.RcHolder> {

    private List<com.example.finalfantasy.mys.model.List> mPosts;

    public TimeAdapter(List<com.example.finalfantasy.mys.model.List> posts) {
        this.mPosts = posts;
    }

    @Override
    public RcHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_holder, parent, false);
        return new RcHolder(v);
    }

    @Override
    public void onBindViewHolder(RcHolder holder, int position) {
        com.example.finalfantasy.mys.model.List mf = mPosts.get(position);
        holder.setVievRc(mf);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    class RcHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView hh;
        TextView res;
        TextView t;
        TextView wind;
        ImageView img;
        Context mContext;

        public RcHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            hh = itemView.findViewById(R.id.Hh);
            res = itemView.findViewById(R.id.res);
            t = itemView.findViewById(R.id.t);
            wind = itemView.findViewById(R.id.wind);
            img = itemView.findViewById(R.id.imageView4);
            mContext = itemView.getContext();
        }

        public void setVievRc(com.example.finalfantasy.mys.model.List v) {


            String pres = String.valueOf(v.getMain().getPressure());
            time.setText(v.getDtTxt().substring(10, 16));
            if (v.getMain().getHumidity().toString().length() == 3)
                hh.setText(v.getMain().getHumidity().toString() + "%");
            else if (v.getMain().getHumidity().toString().length() == 2)
                hh.setText(v.getMain().getHumidity().toString() + "%  ");
            else if (v.getMain().getHumidity().toString().length() == 1)
                hh.setText(v.getMain().getHumidity().toString() + "%   ");

            res.setText(String.valueOf(v.getMain().getPressure()) + "mm");

            if (String.valueOf(v.getMain().getTemp()).length() == 2)
                t.setText(v.getMain().getTemp() + "°");
            else
                t.setText(v.getMain().getTemp() + "  °");

            wind.setText(v.getWind().getSpeed().toString() + "m/s");
            Glide.with(mContext)
                    .load("http://openweathermap.org/img/w/" + v.getWeather().get(0).getIcon() + ".png")
                    .into(img);

        }
    }
}

