package com.example.projectdicoding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSingerAdapter extends RecyclerView.Adapter<ListSingerAdapter.ListViewHolder> {

    @NonNull
    private ArrayList<Singer> listSinger;
    private static final String TAG = "ListSingerAdapter";

    public ListSingerAdapter(ArrayList<Singer>list){
        this.listSinger=list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_singer,parent,false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Singer singer = listSinger.get(position);
        Glide.with(holder.itemView.getContext())
                .load(singer.getFoto())
                .apply(new RequestOptions().override(400, 600))
                .into(holder.imgPhoto);
        holder.tvName.setText(singer.getNama());
        holder.tvJudul.setText(singer.getJudulLagu());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listSinger.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSinger.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvJudul;
        RelativeLayout parentLayout;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_name);
            tvJudul = itemView.findViewById(R.id.tv_judulLagu);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Singer data);
    }


}
