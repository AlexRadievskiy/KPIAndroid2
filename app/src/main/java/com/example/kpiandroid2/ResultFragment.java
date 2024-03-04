package com.example.kpiandroid2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView resultTextView = view.findViewById(R.id.resultTextView);
        Button cancelButton = view.findViewById(R.id.cancelButton);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String phoneType = bundle.getString("phoneType", "");
            String brand = bundle.getString("brand", "");
            resultTextView.setText("Type: " + phoneType + "\nBrand: " + brand);
        }

        cancelButton.setOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());
        return view;
    }

}
