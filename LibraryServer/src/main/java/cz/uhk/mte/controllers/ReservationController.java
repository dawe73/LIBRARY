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

import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Borrowing;
import cz.uhk.mte.model.Reservation;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.BorrowingService;
import cz.uhk.mte.service.ReservationService;
import cz.uhk.mte.service.StudentService;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	BorrowingService borrowingService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "admin/reservation", method = RequestMethod.GET)
	public String getReservation(Model model) {
		model.addAttribute("reservations", reservationService.getAllReservations());
		return "admin/reservation";
	}
	
	@RequestMapping(value = "admin/reservation.accept", method = RequestMethod.GET)
	public String acceptReservation(@RequestParam("id") int id,Model model) {
		Reservation reservation = reservationService.getReservationByID(id);
		Borrowing bor = new Borrowing(reservation);
		reservation.setActive(true);
		reservationService.update(reservation);
		borrowingService.insertBorrowing(bor);
		Book b = reservation.getBook();
		int ava = b.getAvailableCount()-1;
		b.setAvailableCount(ava);
		bookService.update(b);
		model.addAttribute("reservations", reservationService.getAllReservations());
		return "redirect:/admin/borrowing";
	}
	
	@RequestMapping(value = "admin/reservation.delete", method = RequestMethod.GET)
	public String deleteReservation(@RequestParam("id") int id,Model model) {
		model.addAttribute("reservations", reservationService.getAllReservations());
		reservationService.delete(reservationService.getReservationByID(id));
		return "redirect:/admin/reservation";
	}
	
	@RequestMapping(value = "admin/student.info", method = RequestMethod.GET)
	public String getStudent(@RequestParam("id") int id,Model model) {
		model.addAttribute("student",studentService.getStudentByID(id));
		System.out.println("res"+studentService.getStudentByID(id).getReservations());
		System.out.println("bor"+studentService.getStudentByID(id).getBorrowings());
		return "admin/studentInfo";
	}
	
	
}
