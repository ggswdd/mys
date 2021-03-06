package com.example.finalfantasy.mys.fragmentClases;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.finalfantasy.mys.adapters.FavoritesAdapter;
import com.example.finalfantasy.mys.database.DBhealper;
import com.example.finalfantasy.mys.FavoritesActivity;
import com.example.finalfantasy.mys.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavorites extends Fragment {
    private View view;
    private static RecyclerView mFav;
    private static DBhealper mDB;
    private static List<String> mList;
    public static View.OnClickListener mCll;

    public static FragmentFavorites getInstace() {
        Bundle x = new Bundle();
        FragmentFavorites fragment = new FragmentFavorites();
        fragment.setArguments(x);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorites_fragment, container, false);
        mCll = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mA = (TextView) view;
                Intent mInt = new Intent(getContext(), FavoritesActivity.class);
                mInt.putExtra("name", mA.getText());
                startActivity(mInt);
            }
        };
        mFav = view.findViewById(R.id.fav);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mFav.setLayoutManager(layoutManager);
        mDB = new DBhealper(getContext());
        SQLiteDatabase mDatabase = mDB.getReadableDatabase();
        Cursor mCursor = mDatabase.query(mDB.TABLE_CONTACTS, null, null, null, null, null, null);
        mList = new ArrayList<String>();
        if (mCursor.moveToFirst()) {
            int mNameIndex = mCursor.getColumnIndex(mDB.KEY_NAME);
            do {
                mList.add(mCursor.getString(mNameIndex));
            }
            while (mCursor.moveToNext());
        }
        mCursor.close();
        FavoritesAdapter mAdapt = new FavoritesAdapter(mList);
        mFav.setAdapter(mAdapt);
        mFav.getAdapter().notifyDataSetChanged();
        mDB.close();
        return view;
    }


    public static void UpdateList() {


        SQLiteDatabase mDatabase = mDB.getWritableDatabase();
        Cursor mCursor = mDatabase.query(mDB.TABLE_CONTACTS, null, null, null, null, null, null);
        List<String> mList = new ArrayList<String>();
        if (mCursor.moveToFirst()) {
            int mNameIndex = mCursor.getColumnIndex(mDB.KEY_NAME);
            do {
                mList.add(mCursor.getString(mNameIndex));
            }
            while (mCursor.moveToNext());
        }
        mCursor.close();
        FavoritesAdapter mAdapt = new FavoritesAdapter(mList);
        mFav.setAdapter(mAdapt);
        mFav.getAdapter().notifyDataSetChanged();
    }

    static public List<String> getList() {
        return mList;
    }


}
