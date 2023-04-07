package com.example.hotel_reservation_system;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HotelGuestListAdapter extends RecyclerView.Adapter<HotelGuestListAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;

    private int numberOfGuests;
    //Data gets passed in the constructor
    HotelGuestListAdapter(Context context, int numberOfGuests) {
        this.layoutInflater = LayoutInflater.from(context);
        this.numberOfGuests = numberOfGuests;
    }

    @NonNull
    @Override
    public HotelGuestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_guest_list_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HotelGuestListAdapter.ViewHolder holder, int position) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView guestName;
        RadioButton genderMaleRadioButton, genderFemaleRadioButton;
        RadioGroup genderRadioGroup;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guestName = itemView.findViewById(R.id.hotel_name_text_view);
            genderRadioGroup = itemView.findViewById(R.id.gender_radio_group );
            genderMaleRadioButton = itemView.findViewById(R.id.gender_male_radio);
            genderFemaleRadioButton = itemView.findViewById(R.id.gender_female_radio );
        }
    }
    @Override
    public int getItemCount() {
            return numberOfGuests;
    }
}