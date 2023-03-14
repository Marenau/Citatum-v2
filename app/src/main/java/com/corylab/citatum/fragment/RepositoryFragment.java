package com.corylab.citatum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.corylab.citatum.MainActivity;
import com.corylab.citatum.R;
import com.corylab.citatum.databinding.RepositoryFragmentBinding;


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
        binding.button.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("text", binding.editText.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_repositoryFragment_to_tagsFragment, bundle);
        });
    }
}
