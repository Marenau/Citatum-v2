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
import androidx.navigation.Navigation;
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
        initIt();
    }

    private void initIt() {
        binding.pageName.setText(R.string.tags_page);
        binding.button.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("text", binding.editText.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_tagsFragment_to_repositoryFragment, bundle);
        });
    }
}