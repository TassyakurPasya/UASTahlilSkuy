package com.achapasya.myapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.achapasya.myapplication.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    List<DataModel> listData;
    LayoutInflater inflater;
    Context context;

    public AdapterData(Context context, List<DataModel> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent, false);
        HolderData holderData = new HolderData(view);
        holderData.lcontainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, detailTahlil.class);
                i.putExtra("id",listData.get(holderData.getAdapterPosition()).getId());
                i.putExtra("title",listData.get(holderData.getAdapterPosition()).getTitle());
                i.putExtra("arabic",listData.get(holderData.getAdapterPosition()).getArabic());
                i.putExtra("translation",listData.get(holderData.getAdapterPosition()).getTranslation());
                context.startActivity(i);
            }
        });
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txtId.setText(listData.get(position).getId());
        holder.txtTitle.setText(listData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView txtTitle, txtId;
        LinearLayout lcontainer;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            lcontainer = itemView.findViewById(R.id.container);
            txtId = itemView.findViewById(R.id.listangka);
            txtTitle = itemView.findViewById(R.id.txtJudul);
        }
    }
}
