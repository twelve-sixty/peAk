package com.twelvesixty.peak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twelvesixty.peak.R;
import com.twelvesixty.peak.model.User;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private List<User> mDataset;

    // Provide a reference to the views for each data item
    public  class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView usernameText;
        public TextView bioText;
        public MyViewHolder(View v) {
            super(v);
            //Set pointers to specific parts of the viewHolder
            usernameText = v.findViewById(R.id.lineOne);
            bioText = v.findViewById(R.id.lineTwo);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public UserAdapter(List<User> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view from the provided layout file
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.two_line_list_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.usernameText.setText(mDataset.get(position).getUsername());
        holder.bioText.setText(mDataset.get(position).getBio());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

