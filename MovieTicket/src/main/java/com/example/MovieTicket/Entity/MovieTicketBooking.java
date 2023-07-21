package com.example.MovieTicket.Entity;

import java.time.LocalDate;

import com.example.MovieTicket.Model.MovieTicketBookingDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class MovieTicketBooking {
	@Id
	private String ticketNo;
	private String seatNo;
	private String movieName;
	private String customerName;
	private LocalDate bookingDate;
	private Double ticketPrice;

	
	public static MovieTicketBookingDto bookingDto(MovieTicketBooking booking)throws Exception{
		
		MovieTicketBookingDto bookingDto=new MovieTicketBookingDto();
		bookingDto.setTicketNo(booking.getTicketNo());
		bookingDto.setSeatNo(booking.getSeatNo());
		bookingDto.setMovieName(booking.getMovieName());
		bookingDto.setCustomerName(booking.getCustomerName());
		bookingDto.setBookingDate(booking.getBookingDate());
		bookingDto.setTicketPrice(booking.getTicketPrice());
		return bookingDto;
		
	}
}
