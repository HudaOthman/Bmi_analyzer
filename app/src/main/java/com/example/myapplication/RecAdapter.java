package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecAdapter extends  RecyclerView.Adapter<RecAdapter.ViewHolder> {

private List<String> mData;
private  Context context ;

        RecAdapter(Context context, List<String> data) {
            this.context=context;
            this.mData = data;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.old_status, parent,false);
        return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String info = mData.get(position);
        holder.date.setText(mData.get(position));
    }




    // total number of rows
@Override
public int getItemCount() {
        return mData.size();
        }


// stores and recycles views as they are scrolled off screen
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView date,size,length,status;

    ViewHolder(View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.date);
        size = itemView.findViewById(R.id.size);
        status = itemView.findViewById(R.id.status);
        length = itemView.findViewById(R.id.length);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "position : " , Toast.LENGTH_SHORT).show();
    }
}

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }


// parent activity will implement this method to respond to click events
public interface ItemClickListener {
    void onItemClick(View view, int position);
}
}