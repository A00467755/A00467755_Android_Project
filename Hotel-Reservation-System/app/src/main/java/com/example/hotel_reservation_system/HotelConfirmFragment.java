package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HotelConfirmFragment extends Fragment {

    View view;

    Confirmation confirmationResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_confirm_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelSuccessTextView = view.findViewById(R.id.hotel_success_text_view );

        String confirmationNumber = getArguments().getString("confirmation number");

        hotelSuccessTextView.setText("Thank you for your reservation, your reservation number is " + confirmationNumber);

    }
}
