package com.example.demo.webservice;

import com.example.demo.data.Reservation;
import com.example.demo.data.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationRepository reservationRepository;

	
	@PostMapping public ReservationConfirmation makeReservation(@RequestBody Reservation reservation) {
	    Reservation savedReservation = reservationRepository.save(reservation);
	    Long id = savedReservation.getId();
	    String confirmationNumber = "R" + String.format("%09d", id); // Format Reference Number
	    
	    return new ReservationConfirmation(confirmationNumber);
	}

	public class ReservationConfirmation {
	    private String confirmation_number;

	    public ReservationConfirmation(String confirmation_number) {
	        this.confirmation_number = confirmation_number;
	    }

	    public String getConfirmation_number() {
	        return confirmation_number;
	    }

	    public void setConfirmation_number(String confirmation_number) {
	        this.confirmation_number = confirmation_number;
	    }
	}
}