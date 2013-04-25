package cz.uhk.mte.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.uhk.mte.model.Borrowing;
import cz.uhk.mte.model.Reservation;
import cz.uhk.mte.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value = "admin/reservation", method = RequestMethod.GET)
	public String getReservation(Model model) {
		model.addAttribute("reservations", reservationService.getAllReservations());
		return "admin/reservation";
	}
	
	@RequestMapping(value = "admin/accept", method = RequestMethod.GET)
	public String acceptReservation(@RequestParam("id") int id,Model model) {
		Reservation reservation = reservationService.getReservationByID(id);
		Borrowing bor = new Borrowing(reservation);
		
		model.addAttribute("reservations", reservationService.getAllReservations());
		return "redirect:/admin/borrowing";
	}
	
	@RequestMapping(value = "admin/delete", method = RequestMethod.GET)
	public String deleteReservation(Model model) {
		model.addAttribute("reservations", reservationService.getAllReservations());
		return "redirect:/admin/reservation";
	}
}
