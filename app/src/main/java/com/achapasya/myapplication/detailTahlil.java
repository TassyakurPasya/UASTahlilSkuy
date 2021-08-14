package com.achapasya.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.achapasya.myapplication.R;
import com.achapasya.myapplication.R;
import com.achapasya.myapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class detailTahlil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tahlil);

        //hide the default action bar
        getSupportActionBar().hide();

        //receive data
        String id = getIntent().getExtras().getString("id");
        String judul = getIntent().getExtras().getString("title");
        String arab = getIntent().getExtras().getString("arabic");
        String artinya = getIntent().getExtras().getString("translation");

        //ini views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_id = findViewById(R.id.listangka);
        TextView tv_judul = findViewById(R.id.txtjudulDetail);
        TextView tv_arab = findViewById(R.id.txtdetailArabic);
        TextView tv_artinya = findViewById(R.id.txtdetailTranslation);

        // set to each view

        tv_id.setText(id);
        tv_judul.setText(judul);
        tv_arab.setText(arab);
        tv_artinya.setText(artinya);
        collapsingToolbarLayout.setTitle(judul);
    }
}