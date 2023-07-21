package com.example.MovieTicket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.Model.MovieTicketBookingDto;
import com.example.MovieTicket.Service.MovieTicketService;

@RestController
@RequestMapping("/ticketbot")
public class MovieticketController {
	
	@Autowired
	private MovieTicketService movieTicketService;
	
	@GetMapping("/getticket")
	public ResponseEntity<MovieTicketBookingDto> entity(@RequestParam ("ticketNo")String ticketNo)throws Exception{
		ResponseEntity<MovieTicketBookingDto> responseEntity = null;
		try {
		MovieTicketBookingDto bookingDto=movieTicketService.getTicket(ticketNo);
		responseEntity=new ResponseEntity<>(bookingDto, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	
		return responseEntity;
	}
	
	@PostMapping("/insertticket")
	public ResponseEntity<String> entity1(@RequestBody MovieTicketBookingDto bookingDto)throws Exception{
		ResponseEntity<String> responseEntity=null;	
		try {
		movieTicketService.insertTicket(bookingDto);
		String message="successfully Inserted";
		responseEntity=new ResponseEntity<>(message, HttpStatus.OK);	
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return responseEntity;
	}
	
	@PutMapping("/updateticket")
	public ResponseEntity<String> entity3(@RequestBody MovieTicketBookingDto bookingDto)throws Exception{
		movieTicketService.updateTicket(bookingDto);
		String message="Successfully Updated";
		ResponseEntity<String> responseEntity=new ResponseEntity<>(message, HttpStatus.OK);
		return responseEntity;		
	}
	
	@DeleteMapping("/deletetticket")
	public ResponseEntity<String> entity4(@RequestParam ("ticketNo")String ticketNo)throws Exception{
		movieTicketService.deleteTicket(ticketNo);
		String message="Successfully Deleted!!!";
		ResponseEntity<String> responseEntity=new ResponseEntity<>(message,HttpStatus.OK);
		return responseEntity;	
	}
	
	@GetMapping("/getallticket")
	public ResponseEntity<List<MovieTicketBookingDto>> entity()throws Exception{
		List<MovieTicketBookingDto> bookingDto=movieTicketService.getallTicket();
		ResponseEntity<List<MovieTicketBookingDto>> responseEntity=new ResponseEntity<>(bookingDto, HttpStatus.OK);
		return responseEntity;		
	}
	
	@GetMapping("/movienameusedgetdetail")
	public ResponseEntity<MovieTicketBookingDto> entity1(@RequestParam ("movieName")String movieName)throws Exception{
		ResponseEntity<MovieTicketBookingDto> responseEntity=null;
		try {		
		MovieTicketBookingDto bookingDto=movieTicketService.getMovienameticket(movieName);
		responseEntity=new ResponseEntity<>(bookingDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		return responseEntity;
	}
	
	@GetMapping("/getcustomerusedmovieticketdetail/{customerName}")
	ResponseEntity<MovieTicketBookingDto> entity5(@PathVariable String customerName)throws Exception{
		ResponseEntity<MovieTicketBookingDto> responseEntity = null;
		try {
		MovieTicketBookingDto bookingDto=movieTicketService.getcustomerName(customerName);
		responseEntity=new ResponseEntity<>(bookingDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}	
		return responseEntity;		
	}
	
	
}
