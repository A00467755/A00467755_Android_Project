package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelGuestListFragment extends Fragment {

    View view;
    String hotelName;
    String hotelPrice;
    String hotelAvailability;
    String checkinDate;
    String checkoutDate;
    String guestCount;
    Confirmation confirmationResponse;
    Button confirmButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Gather information
        TextView hotelNameTextView = view.findViewById(R.id.hotel_name_text_view);
        TextView checkinTextView = view.findViewById(R.id.checkin_text_view);
        TextView checkoutTextView = view.findViewById(R.id.checkout_text_view);
        TextView priceTextView = view.findViewById(R.id.price_text_view);

        confirmButton = view.findViewById(R.id.confirm_button);

        hotelName = getArguments().getString("hotel name");
        hotelPrice = getArguments().getString("hotel price");
        hotelAvailability = getArguments().getString("hotel availability");

        checkinDate = getArguments().getString("checkInDate");
        checkoutDate = getArguments().getString("checkOutDate");
        guestCount = getArguments().getString("guestCount");

        // Setup UI
        hotelNameTextView.setText("Hotel Name: " + hotelName);
        checkinTextView.setText("Check In: " +checkinDate);
        checkoutTextView.setText("Check Out: " + checkoutDate);
        priceTextView.setText("Price: " + hotelPrice);

        // Load RecyclerView with guestCount
        RecyclerView recyclerView = view.findViewById(R.id.hotel_guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HotelGuestListAdapter hotelGuestListAdapter = new HotelGuestListAdapter(getActivity(), Integer.parseInt(guestCount));
        recyclerView.setAdapter(hotelGuestListAdapter);

        //Confirm Button click Listener
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Gather information from recyclerView
                List<Guest> list = new ArrayList<>();
                for (int i = 0; i < hotelGuestListAdapter.getItemCount(); i++) {
                    View view = recyclerView.getChildAt(i);
                    EditText nameEditText = (EditText) view.findViewById(R.id.guest_name_edit_text);
                    RadioGroup genderRadioGroup = (RadioGroup) view.findViewById(R.id.gender_radio_group);

                    int selectedId = genderRadioGroup.getCheckedRadioButtonId();
                    String gender= "";
                    RadioButton genderRadioButton = (RadioButton) view.findViewById(selectedId);
                    if(selectedId!=-1){
                        gender = (String) genderRadioButton.getText();
                    }
                    String name = nameEditText.getText().toString();
                    Guest data = new Guest(name,gender);
                    list.add(data);
                   // Toast.makeText(getActivity(), data.getGuest_name()+ data.getGender(), Toast.LENGTH_LONG).show();
                }

                // Setup object for POST request
                Reservation reservation = new Reservation(hotelName, checkinDate, checkoutDate, list);

                // Send a POST request to the REST API for Reservation
                Api.getClient().createReservation(reservation,new Callback<Confirmation>() {
                    @Override
                    public void success(Confirmation confirmation, Response response) {
                        // in this method we will get the response from API
                        confirmationResponse = confirmation;
                        //Toast.makeText(getActivity(), confirmationResponse.getConfirmation_number(), Toast.LENGTH_LONG).show();

                        // Set up bundle
                        Bundle bundle = new Bundle();
                        bundle.putString("confirmation number", confirmationResponse.getConfirmation_number());

                        // set Fragment class Arguments
                        HotelConfirmFragment hotelConfirmFragment = new HotelConfirmFragment();
                        hotelConfirmFragment.setArguments(bundle);

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_layout, hotelConfirmFragment);
                        fragmentTransaction.remove(HotelGuestListFragment.this);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        // if error occurs in network transaction then we can get the error in this method.
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
