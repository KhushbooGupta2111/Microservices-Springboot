package com.lcwd.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating)
	{
		ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating); 
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings()
	{
		 List<Rating> ratings = ratingService.getRatings();
		 return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId)
	{
		 List<Rating> ratings = ratingService.getRatingByUserId(userId);
		 return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId)
	{
		 List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
		 return ResponseEntity.ok(ratings);
	}	
}
