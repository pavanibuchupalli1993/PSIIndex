package com.example.psiindex.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psiindex.R;
import com.example.psiindex.model.psimodel.Reading;

import java.util.ArrayList;

public class DisplayPSIReadingsDialogAdapter extends RecyclerView.Adapter<DisplayPSIReadingsDialogAdapter.DataViewHolder>
{
    private ArrayList<Reading> readingList;

    public DisplayPSIReadingsDialogAdapter(ArrayList<Reading> readingList) {
        this.readingList = readingList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.readings_item, parent, false);

        return new DataViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        holder.itemTv.setText(readingList.get(position).title + " " + readingList.get(position).value);

    }

    @Override
    public int getItemCount() {
        return readingList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        TextView itemTv;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTv = itemView.findViewById(R.id.reading_detail);
        }
    }
}
