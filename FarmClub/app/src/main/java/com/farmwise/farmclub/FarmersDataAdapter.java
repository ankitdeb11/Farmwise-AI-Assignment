package com.farmwise.farmclub;

// FarmersDataAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FarmersDataAdapter extends RecyclerView.Adapter<FarmersDataAdapter.ViewHolder> {

    private ArrayList<Farmer> farmersList;

    public FarmersDataAdapter(ArrayList<Farmer> farmersList) {
        this.farmersList = farmersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Farmer farmer = farmersList.get(position);

        holder.txtName.setText(farmer.getName());
        holder.txtAddress.setText(farmer.getAddress());
        holder.txtDob.setText(farmer.getDob());
        holder.txtGender.setText(farmer.getGender());
        holder.txtLandArea.setText(farmer.getLandArea());



        //update farmer class as well
        holder.txtLatitude.setText("Latitude: " + farmer.getLatitude());
        holder.txtLongitude.setText("Longitude: " + farmer.getLongitude());
    }

    @Override
    public int getItemCount() {
        return farmersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress, txtDob, txtGender, txtLandArea, txtLatitude, txtLongitude;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtDob = itemView.findViewById(R.id.txtDob);
            txtGender = itemView.findViewById(R.id.txtGender);
            txtLandArea = itemView.findViewById(R.id.txtLandArea);
            txtLatitude = itemView.findViewById(R.id.txtLatitude);
            txtLongitude = itemView.findViewById(R.id.txtLongitude);
        }
    }
}
