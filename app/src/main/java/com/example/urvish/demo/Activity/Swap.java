package com.example.urvish.demo.Activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.urvish.demo.Helper.DatabaseHelper;
import com.example.urvish.demo.Model.Quote_list;
import com.example.urvish.demo.R;
import com.example.urvish.demo.Adapter.Swap_adapter;

import java.util.ArrayList;
import java.util.Collections;

public class Swap extends AppCompatActivity {

    RecyclerView swaping;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        databaseHelper = new DatabaseHelper(this);
        swaping = findViewById(R.id.swaping);

        databaseHelper.getReadableDatabase().execSQL("delete from " + Quote_list.TABLE_NAME);

        for (int i = 0; i < 5; i++) {
            insert_note("Morning", "The Gävle Goat is a giant version of a traditional Swedish Yule Goat figure made of straw. It has become notable for being a recurring target for vandalism by arson, and has been destroyed several times since the first goat was erected in 1966. ");
        }

        final Swap_adapter swap_adapter = new Swap_adapter(Swap.this, get_quote_list());
        swaping.setAdapter(swap_adapter);
        swaping.setLayoutManager(new GridLayoutManager(Swap.this, 1));


       /* ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            int a, b;

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeFlag(ItemTouchHelper.ANIMATION_TYPE_SWIPE_SUCCESS,
                        ItemTouchHelper.DOWN |
                                ItemTouchHelper.UP |
                                ItemTouchHelper.START |
                                ItemTouchHelper.END);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
               *//* a = source.getAdapterPosition();
                b = target.getAdapterPosition();*//*
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                Collections.swap(num, a, b);
                swap_adapter.notifyItemMoved(a, b);
            }
        });
//        itemTouchHelper.attachToRecyclerView(swaping);*/
    }

    public void insert_note(String note_title, String note_details) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Quote_list.QUOTE_TITLE, note_title);
        contentValues.put(Quote_list.QUOTE_DESCRIPTION, note_details);
        database.insert(Quote_list.TABLE_NAME, null, contentValues);
        database.close();
    }

    public ArrayList<Quote_list> get_quote_list() {

        ArrayList<Quote_list> quote_lists = new ArrayList<>();

        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + Quote_list.TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);

        /*for (int i = 0; i < cursor.getCount(); i++) {
            quote_lists.add(new Quote_list(
                    cursor.getString(cursor.getColumnIndex(Quote_list.QUOTE_TITLE)),
                    cursor.getString(cursor.getColumnIndex(Quote_list.QUOTE_DESCRIPTION))));
        }*/

        if (cursor.moveToFirst()) {
            do {
                quote_lists.add(new Quote_list(
                        cursor.getString(cursor.getColumnIndex(Quote_list.QUOTE_TITLE)),
                        cursor.getString(cursor.getColumnIndex(Quote_list.QUOTE_DESCRIPTION))));
            } while (cursor.moveToNext());
        }

        database.close();

        return quote_lists;

    }

}
