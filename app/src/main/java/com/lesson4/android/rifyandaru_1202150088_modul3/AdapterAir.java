package com.lesson4.android.rifyandaru_1202150088_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by User on 25/02/2018.
 */

public class AdapterAir extends RecyclerView.Adapter<AdapterAir.WordViewHolder> {
    private GradientDrawable mGradientDrawable;
    private ArrayList<Air> mArray;
    private Context mContext;

    // membuat array, kontainer gambar dan kontex aktivitas untuk konstruktor
    AdapterAir(Context mContext, ArrayList<Air> mArray) {
        this.mArray = mArray;
        this.mContext = mContext;
//        set conatainer untuk gambar
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.ades);
        if (drawable!=null){
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    // mengemmbalikan menuviewholder
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WordViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.activity_wordlist, parent, false), mGradientDrawable);
    }

    //    mengisi item recycler view
    @Override
    public void onBindViewHolder(AdapterAir.WordViewHolder holder, int position) {
        Air current = mArray.get(position);
        holder.bindTo(current);
        Glide.with(mContext).load(current.getImage()).into(holder.mAirImage);
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mAirImage;
        private TextView mTitle;
        private TextView mInfo;
        private Context mContext;
        private Air mCurrentAir;
        private GradientDrawable mGradient;
        private String txtTitle;

        // mencari id pada layout activity_wordlist
        WordViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mAirImage = (ImageView) itemView.findViewById(R.id.airImage);
            mTitle = (TextView) itemView.findViewById(R.id.labelTitle);
            mInfo = (TextView) itemView.findViewById(R.id.infoTitle);

            mContext = context;
            mGradient = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        //        set semua layout dengan nilai string dan gambar dari objek menu
        public void bindTo(Air current) {
            mTitle.setText(current.getTitle());
            mInfo.setText(current.getInfo());

            mCurrentAir = current;
            txtTitle = mTitle.getText().toString();

            //            load gambar dengan glide menggunkan id gambar ke layout
            Glide.with(mContext).load(current.getImage()).placeholder(mGradient).into(mAirImage);

        }

        // membuka menu kepilih dengan intent dari menu.
        public void onClick(View view) {
            Intent detail = Air.starter(mContext, mCurrentAir.getTitle(), mCurrentAir.getImage());
            detail.putExtra("title", txtTitle);
            mContext.startActivity(detail);
        }

    }
}
