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

import com.corylab.citatum.MainActivity;
import com.corylab.citatum.R;
import com.corylab.citatum.databinding.RepositoryFragmentBinding;

public class RepositoryFragment extends Fragment {

    FragmentManager fragmentManager;
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
        fragmentManager = getParentFragmentManager();

        fragmentManager.setFragmentResultListener("change to RepositoryFragment", this, (requestKey, result) -> {
            String results = result.getString("resultText");
            binding.transmissionText.setText(results);
        });
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

        binding.returnButton.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString("resultText", binding.quoteEditText.getText().toString());
            fragmentManager.setFragmentResult("change to HubFragment", result);
            mainActivity.changeFragment(view1);
        });
    }

    private void initIt() {
        binding.pageName.setText(R.string.repository_page);
        binding.quoteEditText.setHint(R.string.write_text_request);
        binding.returnButton.setText(R.string.return_button);
    }
}
