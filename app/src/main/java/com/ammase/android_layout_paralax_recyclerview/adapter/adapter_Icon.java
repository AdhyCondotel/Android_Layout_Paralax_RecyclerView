package com.ammase.android_layout_paralax_recyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ammase.android_layout_paralax_recyclerview.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gd on 7/19/2016.
 */
public class adapter_Icon extends RecyclerView.Adapter<adapter_Icon.ViewHolder> {
private List<String> listGambar;
private Activity activity;
    private Context mContext;

    public adapter_Icon(Activity activity, List<String> listGambar) {
        this.listGambar = listGambar;
        this.activity = activity;
        this.mContext = activity;
    }


    @Override
    public int getItemCount() {
        return listGambar.size();
    }

    @Override
    public adapter_Icon.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_icon, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txt_nama.setText(listGambar.get(position));
        AssetManager assetManager = activity.getAssets();
        InputStream is;
        try {
            is = assetManager.open(listGambar.get(position) + ".png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.image_Icon.setImageBitmap(bitmap);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.textView_namaIcon) TextView txt_nama;
        @BindView(R.id.ImageView_Icon) ImageView image_Icon;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
