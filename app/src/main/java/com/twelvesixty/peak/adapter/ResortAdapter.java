package com.twelvesixty.peak.adapter;

import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.twelvesixty.peak.R;
import com.twelvesixty.peak.activity.MainActivity;
import com.twelvesixty.peak.model.Resort;
import com.twelvesixty.peak.model.Team;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Entire class is borrowed heavily from https://developer.android.com/guide/topics/ui/layout/recyclerview without citation
public class ResortAdapter extends RecyclerView.Adapter<ResortAdapter.ResortViewHolder> {
    Gson gson = new Gson();
    private Resort[] mDataset;

    // Provide a reference to the views for each data item
    public  class ResortViewHolder extends RecyclerView.ViewHolder {
        public TextView resortName;
        public ResortViewHolder(View v) {
            super(v);
            //Set pointers to specific parts of the viewHolder
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
                //Find what Layout was clicked
                RecyclerView parent = (RecyclerView) v.getParent();
                int position = parent.getChildLayoutPosition(v);
                View root = v.getRootView();

                //Update shared prefs so the map will be updated
                root.getContext().getSharedPreferences("preferences", 0).edit().putFloat("latitude", (float) mDataset[position].getLatitude()).putFloat("longitude", (float) mDataset[position].getLongitude()).apply();
                RecyclerView teamList = root.findViewById(R.id.filteredList);

                //Let MainActivity know what resort is now being displayed.
                MainActivity.resortId = mDataset[position].getId();

                //Create a new AsyncTask to get selected resorts teams.
                //Passing in the selected Resort and a pointer to the teamList Recycler
                getTeams().execute(mDataset[position], teamList);

                //Get and set data about resort on textViews
                String name = mDataset[position].getName();
                String address = mDataset[position].getAddress();
                String website = mDataset[position].getWebsiteUrl();

                TextView resortName = root.findViewById(R.id.resortName);
                TextView resortAddress = root.findViewById(R.id.resortAddress);
                TextView resortWebsite = root.findViewById(R.id.resortWebsite);

                resortName.setText(name);
                resortAddress.setText(address);
                resortWebsite.setText(website);
            }
        });
        // could just return new ResortViewHolder(v);
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

    //method to create an asynctask to be run for getting a resorts teams
    private AsyncTask getTeams() {
        //Task used to get teams whenever a new resort is selected.
        return new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {

                //Setup get request to server, just like in MainActivity
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("http://ec2-54-186-185-206.us-west-2.compute.amazonaws.com/api/v1/resort/" + ((Resort) objects[0]).getId())
                        .get()
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    Resort r = gson.fromJson(response.body().string(), Resort.class);
                    HashMap<String, Object> map = new HashMap<>();
                    //Need a way to reference the list of teams returned and the recyclerview
                    map.put("teamsList", objects[1]);
                    map.put("teams", r.getTeams());
                    return map;
                } catch (IOException e) {
                    Log.e("GETTEAMS", e.toString());
                    //This would probably also ideally do something to notify the user the list couldn't be retrieved
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                //Cast everything back
                HashMap<String, Object> map = (HashMap<String, Object>) o;
                RecyclerView teamList = (RecyclerView) map.get("teamsList");
                List<Team> teams = (List<Team>) map.get("teams");
                //Voila!
                teamList.setAdapter(new TeamAdapterMain(teams));
            }
        };
    }
}
