package com.example.kpiandroid2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> showResultFragment());
        return view;
    }

    private void showResultFragment() {
        ResultFragment resultFragment = new ResultFragment();
        // Pass data to ResultFragment if needed using Bundle
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit();
    }
}
