package com.example.MovieTicket.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieTicket.Entity.MovieTicketBooking;
@Repository
public interface MovieTicketDao extends CrudRepository<MovieTicketBooking, String>{
	Optional<MovieTicketBooking> findBymovieName(String movieName);
	Optional<MovieTicketBooking> findBycustomerName(String customerName);
	
}
