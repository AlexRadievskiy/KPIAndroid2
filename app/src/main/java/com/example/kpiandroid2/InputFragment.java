package com.example.kpiandroid2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        Button okButton = view.findViewById(R.id.okButton);
        EditText phoneTypeEditText = view.findViewById(R.id.phoneTypeEditText);

        okButton.setOnClickListener(v -> {
            String phoneType = phoneTypeEditText.getText().toString().trim();
            if (!phoneType.isEmpty()) {
                showResultFragment(phoneType);
            } else {
                Toast.makeText(getActivity(), "Please enter a phone type", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void showResultFragment(String phoneType) {
        RadioGroup brandRadioGroup = getView().findViewById(R.id.brandRadioGroup);
        int selectedBrandId = brandRadioGroup.getCheckedRadioButtonId();
        String brand = "";
        if (selectedBrandId == R.id.samsungRadioButton) {
            brand = "Samsung";
        } else if (selectedBrandId == R.id.appleRadioButton) {
            brand = "Apple";
        }

        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString("phoneType", phoneType);
        bundle.putString("brand", brand);
        resultFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit();
    }
}
