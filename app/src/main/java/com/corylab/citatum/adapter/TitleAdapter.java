package com.corylab.citatum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.corylab.citatum.R;

import java.util.List;

public class TitleAdapter extends ArrayAdapter<Title> {

    private LayoutInflater inflater;
    private int layout;
    private List<Title> titles;

    public TitleAdapter(Context context, int resource, List<Title> states) {
        super(context, resource, states);
        this.titles = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView nameView = view.findViewById(R.id.title_text);
        TextView capitalView = view.findViewById(R.id.author_text);

        Title title = titles.get(position);

        nameView.setText(title.getTitle());
        capitalView.setText(title.getAuthor());

        return view;
    }
}