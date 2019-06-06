package com.example.locationmap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class CameraListAdapter extends
        RecyclerView.Adapter<CameraListAdapter.CameraViewHolder>{

    private final LinkedList<String> mCameraList;
    private final LinkedList<String> mCameraLink;
    private LayoutInflater mInflater;
    private String LOG_TAG = "CAM LIST ADAPT: ";
    private Listener listener;
    private ArrayList<Double> cameraLatitude = new ArrayList<>();
    private ArrayList<Double>cameraLongitude = new ArrayList<>();

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onClick(int position);
    }



    public CameraListAdapter(Context context, LinkedList<String>cameraList, LinkedList<String>cameraLink, ArrayList<Double>cameraLatitude,
                             ArrayList<Double>cameraLongitude){
        mInflater = LayoutInflater.from(context);
        this.mCameraList = cameraList;
        this.mCameraLink = cameraLink;
        this.cameraLatitude = cameraLatitude;
        this.cameraLongitude = cameraLongitude;
    }

    class CameraViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView cameraItemView;
        final CameraListAdapter mAdapter;


        public CameraViewHolder(@NonNull View itemView, CameraListAdapter adapter) {
            super(itemView);
            cameraItemView = itemView.findViewById(R.id.txt_camera);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String element = mCameraList.get(mPosition);
            mCameraList.set(mPosition, "Clicked! " + element);
            Intent intent = new Intent(view.getContext(),MapsActivity.class);
            Bundle cameraData = new Bundle();
            cameraData.putString("description", mCameraList.get(mPosition));
            cameraData.putDouble("latitude", cameraLatitude.get(mPosition));
            cameraData.putDouble("longitude", cameraLongitude.get(mPosition));

            Log.d(LOG_TAG, Double.toString(cameraLongitude.get(mPosition)));
            intent.putExtras(cameraData);

            view.getContext().startActivity(intent);
            mAdapter.notifyDataSetChanged();




        }
    }
    @NonNull
    @Override
    public CameraListAdapter.CameraViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater
                .inflate(R.layout.cameralist_item, parent, false);

        return new CameraViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CameraViewHolder
                                             holder, int position) {
        String mCurrent = mCameraList.get(position);
        holder.cameraItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCameraList.size();
    }
}
