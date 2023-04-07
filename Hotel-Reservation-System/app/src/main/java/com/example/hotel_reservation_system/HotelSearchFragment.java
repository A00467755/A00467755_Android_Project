package com.example.hotel_reservation_system;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HotelSearchFragment extends Fragment {

    // UI Control Objects
    View view;
    ConstraintLayout mainLayout;

    TextView searchTextConfirmationTextView;
    EditText guestNameEditText,guestCountEditText;
    DatePicker checkInDatePicker, checkOutDatePicker;
    Button searchButton, confirmSearchButton;

    // Variable to store values from UI
    String guestName, guestCount, checkInDate, checkOutDate ;

    // Declaration of shared preferences keys
    SharedPreferences sharedPreferences;
    public static final String myPreference = "myPref";
    public static final String sharedPrefGuestName = "nameKey";
    public static final String sharedPrefGuestCount = "guestsCount";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_search_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get Layout Object
        mainLayout = view.findViewById(R.id.main_layout);

        // Get UI Control Object
        searchTextConfirmationTextView = view.findViewById(R.id.search_confirm_text_view);

        guestNameEditText = view.findViewById(R.id.guest_name_edit_text);
        guestCountEditText = view.findViewById(R.id.guest_count_edit_text);
        checkInDatePicker = view.findViewById(R.id.checkin_date_picker_view);
        checkOutDatePicker = view.findViewById(R.id.checkout_date_picker_view);

        searchButton = view.findViewById(R.id.search_button);
        confirmSearchButton = view.findViewById(R.id.confirm_search_button);

        //Search Button click Listener
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Load value from UI Object
                guestName = guestNameEditText.getText().toString();
                guestCount = guestCountEditText.getText().toString();
                checkInDate = getDateFromCalendar(checkInDatePicker);
                checkOutDate = getDateFromCalendar(checkOutDatePicker);

                // Set up bundle
                Bundle bundle = new Bundle();
                bundle.putString("guestName", guestName);
                bundle.putString("guestCount", guestCount);
                bundle.putString("checkInDate", checkInDate);
                bundle.putString("checkOutDate", checkOutDate);

                // set Fragment class Arguments
                HotelsListFragment hotelsListFragment = new HotelsListFragment();
                hotelsListFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, hotelsListFragment);
                fragmentTransaction.remove(HotelSearchFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        //Set up the text of confirm text box
        confirmSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInDate = getDateFromCalendar(checkInDatePicker);
                checkOutDate = getDateFromCalendar(checkOutDatePicker);
                //Get input of guests info
                guestName = guestNameEditText.getText().toString();
                guestCount = guestCountEditText.getText().toString();

                // Saving into shared preferences
                sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(sharedPrefGuestName, guestName);
                editor.putString(sharedPrefGuestCount, guestCount);
                editor.commit();

                searchTextConfirmationTextView.setText("Dear Customer, Your check in date is " + checkInDate + ", " +
                        "your checkout date is " + checkOutDate + ".The number of guests are " + guestCount);
            }
        });
    }

    // Function to get the date object
    private String getDateFromCalendar(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = simpleDateFormat.format(calendar.getTime());

        return formattedDate;
    }

}
