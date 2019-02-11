package com.twelvesixty.peak.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twelvesixty.peak.R;
import com.twelvesixty.peak.activity.GroupDetailsActivity;
import com.twelvesixty.peak.model.Team;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyGroupAdapter extends RecyclerView.Adapter<MyGroupAdapter.MyViewHolder> {
    private Team[] mDataset;

    // Provide a reference to the views for each data item
    public  class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView teamName;
        public TextView teamCapactiy;
        public TextView resortName;
        public MyViewHolder(View v) {
            super(v);
            //Set pointers to specific parts of the viewHolder
            teamName = v.findViewById(R.id.groupName);
            teamCapactiy = v.findViewById(R.id.groupCapacity);
            resortName = v.findViewById(R.id.secondLine);;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyGroupAdapter(Team[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyGroupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view from the provided layout file
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_list_item, parent, false);
        //Sets an on click listener to the layout
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Find what group was clicked, start groupDetailActivity with that groups id as data
                RecyclerView parent = (RecyclerView) v.getParent();
                int position = parent.getChildLayoutPosition(v);
                Intent goToGroupDetail = new Intent(parent.getContext(), GroupDetailsActivity.class);
                goToGroupDetail.putExtra("teamId", mDataset[position].getId());
                parent.getContext().startActivity(goToGroupDetail);
            }
        });
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Team t = mDataset[position];
        holder.teamName.setText(t.getName());
        holder.teamCapactiy.setText(0 + "/" +  t.getMaxCapacity());
        holder.resortName.setText("Resort Name");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

