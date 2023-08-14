package com.example.lesson_2_3month;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private TextView num;
    private Button btn_minus1, btn_plus1, btn_next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

        btn_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num.setText(Integer.toString(Integer.parseInt(num.getText().toString()) + 1));
            }
        });

        btn_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num.setText(Integer.toString(Integer.parseInt(num.getText().toString()) - 1));
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Bundle bundle = new Bundle();
                  bundle.putString("login",num.getText().toString());
                  SecondFragment secondFragment = new SecondFragment();
                  secondFragment.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.conteyner,secondFragment).commit();


            }
        });
    }

    private void initView(){
        num = requireActivity().findViewById(R.id.tv_null);
        btn_plus1 = requireActivity().findViewById(R.id.btn_plus1);
        btn_minus1 = requireActivity().findViewById(R.id.btn_minus1);
        btn_next = requireActivity().findViewById(R.id.btn_next);
    }
}