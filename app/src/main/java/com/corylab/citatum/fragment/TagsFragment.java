package com.corylab.citatum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.corylab.citatum.MainActivity;
import com.corylab.citatum.R;
import com.corylab.citatum.adapter.Tag;
import com.corylab.citatum.adapter.TagAdapter;
import com.corylab.citatum.databinding.TagsFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class TagsFragment extends Fragment {

    TagsFragmentBinding binding;
    MainActivity mainActivity;

    public TagsFragment() {
        super(R.layout.tags_fragment);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TagsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateItems();
        initIt();
    }

    private void initIt() {
        binding.pageName.setText(R.string.tags_page);
    }

    private void generateItems() {
        List<Tag> list = new ArrayList<>();
        for (int i = 0; i < 210; i++) {
            Tag temp = new Tag("Tag " + i);
            list.add(temp);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        TagAdapter tagAdapter = new TagAdapter(mainActivity, list);
        binding.recyclerView.setAdapter(tagAdapter);
    }
}