package com.example.MovieTicket.Service;

import java.util.List;

import com.example.MovieTicket.Model.MovieTicketBookingDto;

public interface MovieTicketService {
	
	public void insertTicket(MovieTicketBookingDto bookingDto)throws Exception;
	public MovieTicketBookingDto getTicket(String ticketNo)throws Exception;
	public void updateTicket(MovieTicketBookingDto bookingDto)throws Exception;
	public void deleteTicket(String ticketNo)throws Exception;
	public List<MovieTicketBookingDto> getallTicket()throws Exception;
	public MovieTicketBookingDto getMovienameticket(String movieName)throws Exception;
	public MovieTicketBookingDto getcustomerName(String customerName)throws Exception;

}
