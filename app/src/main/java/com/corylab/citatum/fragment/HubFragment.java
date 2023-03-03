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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import com.corylab.citatum.MainActivity;
import com.corylab.citatum.R;
import com.corylab.citatum.databinding.HubFragmentBinding;
import com.corylab.citatum.databinding.RepositoryFragmentBinding;

public class HubFragment extends Fragment {

    FragmentManager fragmentManager;
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
        fragmentManager = getParentFragmentManager();

        fragmentManager.setFragmentResultListener("change to HubFragment", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Log.i("Citatum", "OK");
                String results = result.getString("resultText").toString();
                binding.transmittedText.setText(results);
            }
        });
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

        binding.intentButton.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString("resultText", binding.quoteEditText.getText().toString());
            fragmentManager.setFragmentResult("change to RepositoryFragment", result);
            mainActivity.changeFragment(view1);
        });
    }

    private void initIt() {
        binding.pageName.setText(R.string.home_app_text);
        binding.quoteEditText.setHint(R.string.write_text_request);
        binding.intentButton.setText(R.string.add_button);
    }
}