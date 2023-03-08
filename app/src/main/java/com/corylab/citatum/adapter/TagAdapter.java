package com.corylab.citatum.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.corylab.citatum.R;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder> {

    Context context;
    List<Tag> tags;

    public TagAdapter(Context context, List<Tag> tags) {
        this.context = context;
        this.tags = tags;
    }

    public final static class TagViewHolder extends RecyclerView.ViewHolder {

        CardView backgroundColor;
        TextView tagText;

        public TagViewHolder(@NonNull View itemView) {
            super(itemView);
            backgroundColor = itemView.findViewById(R.id.rectangle_of_tag);
            tagText = itemView.findViewById(R.id.tag_text);
        }
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tagItems = LayoutInflater.from(context).inflate(R.layout.tag_item, parent, false);
        return new TagViewHolder(tagItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        holder.tagText.setText(tags.get(position).getTag());
        holder.backgroundColor.setCardBackgroundColor(Color.parseColor("#C4C4C4"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("RecyclerView","List click!");
                Toast toast = Toast.makeText(context, "Recycler click!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() { return tags.size(); }

}