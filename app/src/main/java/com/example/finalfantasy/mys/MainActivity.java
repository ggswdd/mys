package com.example.finalfantasy.mys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.finalfantasy.mys.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static CityApi mCityApi;
    RecyclerView mRecyclerView;
     List<List<com.example.finalfantasy.mys.model.List>> mL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCityApi = Controller.getApi();
//
//


        mRecyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

//        final PostsAdapter adapter = new PostsAdapter(posts);
//        mRecyclerView.setAdapter(adapter);


//        try {
//            Response response =  mCityApi.getData("d2a6b21c943e38d9e44edcc03c9912ad","Moscow").execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        mCityApi.getData("d2a6b21c943e38d9e44edcc03c9912ad","Moscow").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {


                mL=response.body().getFillLists();
                final PostsAdapter adapter = new PostsAdapter(mL);
                mRecyclerView.setAdapter(adapter);
                mRecyclerView.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("TAGD",toString());
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
