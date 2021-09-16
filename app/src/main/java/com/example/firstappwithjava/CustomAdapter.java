package com.example.firstappwithjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList teamid, name, title, email,phone;

    CustomAdapter(Context context, ArrayList teamid, ArrayList name, ArrayList title, ArrayList email, ArrayList phone) {
        this.context = context;
        this.teamid = teamid;
        this.name = name;
        this.title = title;
        this.email = email;
        this.phone = phone;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.myrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.teamidTxt.setText(String.valueOf(teamid.get(position)));
        holder.nameTxt.setText(String.valueOf(name.get(position)));
        holder.titleTxt.setText(String.valueOf(title.get(position)));
        holder.emailTxt.setText(String.valueOf(email.get(position)));
        holder.phoneTxt.setText(String.valueOf(phone.get(position)));
    }

    @Override
    public int getItemCount() {
        return teamid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView teamidTxt, nameTxt, titleTxt,emailTxt, phoneTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            teamidTxt = itemView.findViewById(R.id.teamIdTxt);
            nameTxt = itemView.findViewById(R.id.teamName);
            titleTxt = itemView.findViewById(R.id.teamTitle);
            emailTxt = itemView.findViewById(R.id.teamEmail);
            phoneTxt = itemView.findViewById(R.id.teamPhone);
        }
    }
}
