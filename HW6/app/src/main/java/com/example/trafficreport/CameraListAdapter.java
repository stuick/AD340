package com.example.trafficreport;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class CameraListAdapter extends
        RecyclerView.Adapter<CameraListAdapter.CameraViewHolder>{

    private final LinkedList<String> mCameraList;
    private final LinkedList<String> mCameraLink;
    private LayoutInflater mInflater;
    private String LOG_TAG = "CAM LIST ADAPT: ";



    public CameraListAdapter(Context context, LinkedList<String>cameraList, LinkedList<String>cameraLink){
        mInflater = LayoutInflater.from(context);
        this.mCameraList = cameraList;
        this.mCameraLink = cameraLink;
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
            Intent intent = new Intent(view.getContext(),ImageDisplay.class);
            intent.putExtra("cameralink",mCameraLink.get(mPosition));

//            Log.d(LOG_TAG, "GOOOOOOOOOOD");
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
