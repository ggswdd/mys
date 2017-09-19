package com.example.finalfantasy.mys.fragmentClases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalfantasy.mys.Adapters.PostsAdapter;
import com.example.finalfantasy.mys.Controllers.Controller;
import com.example.finalfantasy.mys.DB.DBhealper;
import com.example.finalfantasy.mys.R;
import com.example.finalfantasy.mys.interfaces.CityApi;
import com.example.finalfantasy.mys.model.Example;
import com.example.finalfantasy.mys.model.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Citys extends Fragment implements View.OnClickListener {
    private View view;
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private Button mBtn;
    private static CityApi mCityApi;
    private Button mToTav;
    private TextView mSit;
    private java.util.List<java.util.List<List>> mL;
    private DBhealper mDB;

    public static Citys getInstace() {
        Bundle x = new Bundle();
        Citys fragment = new Citys();
        fragment.setArguments(x);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.citys, container, false);
        mEditText = view.findViewById(R.id.land);
        mBtn = view.findViewById(R.id.Sumbit);
        mToTav = view.findViewById(R.id.to);
        mSit = view.findViewById(R.id.SIt);
        mRecyclerView = view.findViewById(R.id.RV);
        mDB = new DBhealper(getContext());

        mBtn.setOnClickListener(this);
        mToTav.setOnClickListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mCityApi = Controller.getApi();
        mDB.close();
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Sumbit:
                mCityApi.getData("d2a6b21c943e38d9e44edcc03c9912ad", mEditText.getText().toString()).enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.body() == null) {
                            Toast.makeText(getContext(),
                                    "Nothing found", Toast.LENGTH_LONG).show();
                            return;
                        }
                        mL = response.body().getFillLists();
                        mSit.setText(response.body().getCity().getName());
                        mSit.setVisibility(View.VISIBLE);
                        final PostsAdapter adapter = new PostsAdapter(mL);
                        mRecyclerView.setAdapter(adapter);
                        mRecyclerView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.d("TAGD", toString());
                        Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.to:
                for (int i = 0; i < Favorits.getList().size(); i++) {
                    if (mSit.getText().toString().equals(Favorits.getList().get(i))) {
                        Toast.makeText(getContext(), "already added", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                if (mSit.getText().toString().equals("defaut")) {
                    Toast.makeText(getContext(), "First make a request", Toast.LENGTH_LONG).show();
                    return;
                }

                SQLiteDatabase mDataBase = mDB.getWritableDatabase();

                ContentValues mСv = new ContentValues();
                mСv.put("name", mSit.getText().toString());
                mDataBase.insert(mDB.TABLE_CONTACTS, null, mСv);
                Favorits.UpdateList();
                break;
        }
    }
}
