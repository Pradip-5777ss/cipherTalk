package com.PradipSahoo7722.ciphertalk.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PradipSahoo7722.ciphertalk.Model.UserInfoModel;
import com.PradipSahoo7722.ciphertalk.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.myViewHolder>{

    ArrayList<UserInfoModel> infoModel;

    public UsersAdapter(ArrayList<UserInfoModel> infoModel) {
        this.infoModel = infoModel;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_user, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        holder.imageView.setImageResource(infoModel.get(position).getImage());
        holder.name.setText(infoModel.get(position).getName());
        holder.desc.setText(infoModel.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return infoModel.size();
    }

    static class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView name, desc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.userProfile_photo);
            name = itemView.findViewById(R.id.userName);
            desc = itemView.findViewById(R.id.lastMessage);
        }
    }
}
