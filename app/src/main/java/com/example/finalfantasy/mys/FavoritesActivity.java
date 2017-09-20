package com.example.finalfantasy.mys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.finalfantasy.mys.adapters.PostsAdapter;
import com.example.finalfantasy.mys.apiControllers.ApiController;
import com.example.finalfantasy.mys.interfaces.CityApi;
import com.example.finalfantasy.mys.model.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritesActivity extends Activity {
    RecyclerView mRc;
    CityApi mCApi;
    String mS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        mRc = (RecyclerView) findViewById(R.id.posts_recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRc.setLayoutManager(layoutManager);
        mCApi = ApiController.getApi();
        Intent mIntent = getIntent();
        mS = mIntent.getStringExtra("name");

        mCApi.getData("d2a6b21c943e38d9e44edcc03c9912ad", mS).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                final PostsAdapter adapter = new PostsAdapter(response.body().getFillLists());
                mRc.setAdapter(adapter);
                mRc.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("TAGD", toString());
            }
        });
    }


}
