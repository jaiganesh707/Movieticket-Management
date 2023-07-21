package com.example.MovieTicket.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieTicket.Dao.MovieTicketDao;
import com.example.MovieTicket.Entity.MovieTicketBooking;
import com.example.MovieTicket.Model.MovieTicketBookingDto;
@Service
public class MovieTicketServiceImpl implements MovieTicketService{

	@Autowired
	private MovieTicketDao movieTicketRepository;
	
	@Override
	public void insertTicket(MovieTicketBookingDto bookingDto) throws Exception {
		// TODO Auto-generated method stub
		MovieTicketBooking booking=MovieTicketBookingDto.movieTicketBooking(bookingDto);
		movieTicketRepository.save(booking);

		
	}

	@Override
	public MovieTicketBookingDto getTicket(String ticketNo) throws Exception {
		// TODO Auto-generated method stub
		MovieTicketBookingDto bookingDto = null;

	
			Optional<MovieTicketBooking> optional=movieTicketRepository.findById(ticketNo);
			if(optional.isEmpty()) {
				throw new Exception("Pls Insert The Values");
			}
			else {
				MovieTicketBooking booking=optional.get();
				bookingDto=MovieTicketBooking.bookingDto(booking);		
			}
			return bookingDto;
		
	}

	@Override
	public void updateTicket(MovieTicketBookingDto bookingDto) throws Exception {
		// TODO Auto-generated method stub
		Optional<MovieTicketBooking> optional=movieTicketRepository.findById(bookingDto.getTicketNo());
		MovieTicketBooking booking=optional.get();
		booking.setTicketNo(bookingDto.getTicketNo());
		booking.setSeatNo(bookingDto.getSeatNo());
		booking.setMovieName(bookingDto.getMovieName());
		booking.setCustomerName(bookingDto.getCustomerName());
		booking.setBookingDate(bookingDto.getBookingDate());
		booking.setTicketPrice(bookingDto.getTicketPrice());
		movieTicketRepository.save(booking);
		
	}

	@Override
	public void deleteTicket(String ticketNo) throws Exception {
		// TODO Auto-generated method stub
		Optional<MovieTicketBooking> optional=movieTicketRepository.findById(ticketNo);
		MovieTicketBooking booking=optional.get();
		movieTicketRepository.delete(booking);
		
	}

	@Override
	public List<MovieTicketBookingDto> getallTicket() throws Exception {
		// TODO Auto-generated method stub
		List<MovieTicketBookingDto> list=new ArrayList<>();
		Iterable<MovieTicketBooking> iterable=movieTicketRepository.findAll();
		for(MovieTicketBooking addall:iterable) {
			list.add(MovieTicketBooking.bookingDto(addall));
		}
		return list;
	}

	@Override
	public MovieTicketBookingDto getMovienameticket(String movieName) throws Exception {
		// TODO Auto-generated method stub
		Optional<MovieTicketBooking> optional=movieTicketRepository.findBymovieName(movieName);
		if (optional.isEmpty()) {
			throw new Exception("Not Avilable In Movie");
		}
		MovieTicketBooking booking=optional.get();
		MovieTicketBookingDto bookingDto = MovieTicketBooking.bookingDto(booking);		
		return bookingDto;
	}

	@Override
	public MovieTicketBookingDto getcustomerName(String customerName) throws Exception {
		
		Optional<MovieTicketBooking> optional=movieTicketRepository.findBycustomerName(customerName);
		if (optional.isEmpty()) {
			throw new Exception("Not Avilable In this Person");
		}
		
		MovieTicketBooking booking=optional.get();
		MovieTicketBookingDto bookingDto=MovieTicketBooking.bookingDto(booking);
		return bookingDto;
	}

	
}
