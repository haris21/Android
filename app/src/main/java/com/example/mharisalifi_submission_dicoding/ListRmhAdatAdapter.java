package com.example.mharisalifi_submission_dicoding;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListRmhAdatAdapter extends RecyclerView.Adapter<ListRmhAdatAdapter.ListViewHolder> {
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<rmh_adat> listRmhAdat;

    public ListRmhAdatAdapter(ArrayList<rmh_adat> list) {
        this.listRmhAdat = list;
    }


    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_rmadat, viewGroup, false);
        return new ListViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int i) {
        rmh_adat rmhadat = listRmhAdat.get(i);

        Glide.with(listViewHolder.itemView.getContext())
                .load(rmhadat.getPhoto())
                .apply(new RequestOptions().override(100, 100))
                .into(listViewHolder.imgPhoto);
        listViewHolder.tvName.setText(rmhadat.getName());
//        listViewHolder.tvFrom.setText(rmhadat.getFrom());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listRmhAdat.get(listViewHolder.getAdapterPosition()));
            }
        });

    }

    public interface OnItemClickCallback {
        void onItemClicked(rmh_adat data);
    }

    @Override
    public int getItemCount() {
        return listRmhAdat.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_rmadat);
            tvName = itemView.findViewById(R.id.tv_item_name);
        }
    }
}
