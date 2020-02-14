package com.e.loaddata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvCardAdapter extends RecyclerView.Adapter<RvCardAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<DataDiri> dataDiri;

    public RvCardAdapter(Context context, ArrayList<DataDiri> dataDiri){
        this.context = context;
        this.dataDiri = dataDiri;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.data_diri_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvNama.setText(dataDiri.get(position).getNama());
        holder.tvPhone.setText(dataDiri.get(position).getPhone());
        holder.tvEmail.setText(dataDiri.get(position).getEmail());
        holder.tvCity.setText(dataDiri.get(position).getCity());
        holder.tvAlamat.setText(dataDiri.get(position).getAlamat());

    }

    @Override
    public int getItemCount() {
        return dataDiri.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvNama, tvPhone, tvEmail, tvCity, tvAlamat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvCity = itemView.findViewById(R.id.tv_city);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
        }
    }
}
