package com.example.MovieTicket.Model;

import java.time.LocalDate;

import com.example.MovieTicket.Entity.MovieTicketBooking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieTicketBookingDto {
	
	private String ticketNo;
	private String seatNo;
	private String movieName;
	private String customerName;
	private LocalDate bookingDate;
	private Double ticketPrice;
	
	public static MovieTicketBooking movieTicketBooking(MovieTicketBookingDto dto)throws Exception{
		
		MovieTicketBooking booking=new MovieTicketBooking();
		booking.setTicketNo(dto.getTicketNo());
		booking.setSeatNo(dto.getSeatNo());
		booking.setMovieName(dto.getMovieName());
		booking.setCustomerName(dto.getCustomerName());
		booking.setBookingDate(dto.getBookingDate());
		booking.setTicketPrice(dto.getTicketPrice());
		return booking;
		
	}

}
