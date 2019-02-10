package com.twelvesixty.peak.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twelvesixty.peak.R;
import com.twelvesixty.peak.activity.GroupDetailsActivity;
import com.twelvesixty.peak.model.Team;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TeamAdapterMain extends RecyclerView.Adapter<TeamAdapterMain.MainTeamViewHolder> {
    private List<Team> mDataset;

    // Provide a reference to the views for each data item
    public  class MainTeamViewHolder extends RecyclerView.ViewHolder {
        public TextView teamName;
        public TextView teamCapactiy;
        public TextView teamDescription;
        public MainTeamViewHolder(View v) {
            super(v);
            //Set pointers to specific parts of the viewHolder
            teamName = v.findViewById(R.id.groupName);
            teamCapactiy = v.findViewById(R.id.groupCapacity);
            teamDescription = v.findViewById(R.id.secondLine);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TeamAdapterMain(List<Team> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainTeamViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        // create a new view from the provided layout file
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_list_item, parent, false);
        //Sets an on click listener to the layout
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Find what team was clicked, start groupDetailActivity with that teams id as data
                RecyclerView parent = (RecyclerView) v.getParent();
                int position = parent.getChildLayoutPosition(v);
                Intent goToGroupDetail = new Intent(parent.getContext(), GroupDetailsActivity.class);
                goToGroupDetail.putExtra("teamId", mDataset.get(position).getId());
                parent.getContext().startActivity(goToGroupDetail);
            }
        });
        MainTeamViewHolder vh = new MainTeamViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MainTeamViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Team t = mDataset.get(position);
        holder.teamName.setText(t.getName());
        holder.teamCapactiy.setText(t.getCurrentCapacity() + "/" +  t.getMaxCapacity());
        holder.teamDescription.setText(t.getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
