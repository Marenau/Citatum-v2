package com.corylab.citatum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import com.corylab.citatum.MainActivity;
import com.corylab.citatum.R;
import com.corylab.citatum.databinding.HubFragmentBinding;

public class HubFragment extends Fragment {

    HubFragmentBinding binding;
    MainActivity mainActivity;

    public HubFragment() {
        super(R.layout.hub_fragment);
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
        binding = HubFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initIt();
    }

    private void initIt() {
        binding.pageName.setText(R.string.home_app_text);

        binding.firstIntentButton.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_hubFragment_to_repositoryFragment));
        binding.secondIntentButton.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_hubFragment_to_tagsFragment));
    }
}