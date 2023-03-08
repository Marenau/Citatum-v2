package com.corylab.citatum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.corylab.citatum.MainActivity;
import com.corylab.citatum.R;
import com.corylab.citatum.adapter.Title;
import com.corylab.citatum.adapter.TitleAdapter;
import com.corylab.citatum.databinding.RepositoryFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFragment extends Fragment {

    RepositoryFragmentBinding binding;
    MainActivity mainActivity;

    public RepositoryFragment() {
        super(R.layout.repository_fragment);
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
        binding = RepositoryFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initIt();
    }

    private void initIt() {
        binding.pageName.setText(R.string.repository_page);
        generateList();
    }

    private void generateList() {
        List<Title> list = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            Title temp = new Title("Title " + i, "Author " + i);
            list.add(temp);
        }
        TitleAdapter arrayAdapter = new TitleAdapter(mainActivity, R.layout.title_item, list);
        binding.listView.setAdapter(arrayAdapter);
    }
}
