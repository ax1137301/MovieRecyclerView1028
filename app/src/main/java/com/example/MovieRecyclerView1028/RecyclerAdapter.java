package com.example.MovieRecyclerView1028;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder> {
    public ArrayList<Movie> movie_lis;
    Bundle bag = new Bundle();

    // adapter的建構子，
    public RecyclerAdapter(ArrayList<Movie> movie_lis) {
        this.movie_lis = movie_lis;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //對應子畫面，宣告viewholder與回傳值vh
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        Viewholder vh = new Viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        //對應資料結構到moviedat
        holder.img_movie.setImageResource(movie_lis.get(position).img);
        holder.name_movie.setText(movie_lis.get(position).getName());
        holder.date_movie.setText(movie_lis.get(position).getDate());
        holder.plot_movie.setText(movie_lis.get(position).getPlot());
    }

    @Override
    public int getItemCount() {
        return movie_lis.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView img_movie;
        private TextView name_movie,date_movie,plot_movie;
        private Button btn_Buy;

        public Viewholder(@NonNull final View itemView) {
            super(itemView);

            img_movie = itemView.findViewById(R.id.movie_img);
            name_movie = itemView.findViewById(R.id.movie_name);
            date_movie = itemView.findViewById(R.id.movie_date);
            plot_movie = itemView.findViewById(R.id.movie_plot);
            btn_Buy = itemView.findViewById(R.id.btnBuy);

            btn_Buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(itemView.getContext(),"已購票",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(v.getContext(),Movie_list.class);//用內建的View"v"來抓 context (連結)

                    int i= movie_lis.get(getAdapterPosition()).getImg();
                    String n = movie_lis.get(getAdapterPosition()).getName()
                          ,d = movie_lis.get(getAdapterPosition()).getDate()
                          ,p = movie_lis.get(getAdapterPosition()).getPlot();

                    bag.putInt("img",i);
                    bag.putString("name",n);
                    bag.putString("date",d);
                    bag.putString("plot",p);
                    intent.putExtras(bag);
                    v.getContext().startActivity(intent); // 將指定執行位置，現在的intent在建構子的onClick(View v)裡
                    ((Activity)v.getContext()).finish(); // 將v.getContext轉型為Activity
            }
        });
       }
    }
}
