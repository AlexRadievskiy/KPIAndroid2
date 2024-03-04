package com.example.kpiandroid2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private EditText phoneTypeEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        phoneTypeEditText = view.findViewById(R.id.phoneTypeEditText); // Ініціалізація EditText
        Button okButton = view.findViewById(R.id.okButton);

        okButton.setOnClickListener(v -> {
            String phoneType = phoneTypeEditText.getText().toString().trim();
            if (!phoneType.isEmpty()) {
                showResultFragment(phoneType);
            } else {
                phoneTypeEditText.setError("Please enter a phone type"); // Встановити помилку, якщо поле порожнє
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        phoneTypeEditText.setText(""); // Очистити поле при поверненні до фрагмента
    }

    private void showResultFragment(String phoneType) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString("phoneType", phoneType);
        resultFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit();
    }
}
