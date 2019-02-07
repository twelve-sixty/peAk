package com.twelvesixty.peak;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ResortAdapter extends RecyclerView.Adapter<ResortAdapter.ResortViewHolder> {
    private Resort[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public  class ResortViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView resortName;
        public ResortViewHolder(View v) {
            super(v);
            //This is where more views get set to be accessed as neeeed
            resortName = v.findViewById(R.id.singleLine);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ResortAdapter(Resort[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ResortViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        // create a new view from the provided layout file
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_line_list_item, parent, false);
        //Sets an on click listener to the layout
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Find what Layout was clicked, get it's info from the dataset, and log it
                RecyclerView parent = (RecyclerView) v.getParent();
                int position = parent.getChildLayoutPosition(v);
                String resortName = mDataset[position].getName();
                Log.i("RESORTCLICKED", resortName);
            }
        });
        ResortViewHolder vh = new ResortViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ResortViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.resortName.setText(mDataset[position].getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
