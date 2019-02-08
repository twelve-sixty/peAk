package com.twelvesixty.peak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class MyGroupAdapter extends RecyclerView.Adapter<MyGroupAdapter.MyViewHolder> {
    private Team[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public  class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView teamName;
        public TextView teamCapactiy;
        public TextView resortName;
        public MyViewHolder(View v) {
            super(v);
            //This is where more views get set to be accessed as neeeed
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
                //Find what LinearLayout was clicked, get it's info from the dataset, and log it
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

