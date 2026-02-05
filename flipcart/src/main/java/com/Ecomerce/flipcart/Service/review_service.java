package com.Ecomerce.flipcart.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Ecomerce.flipcart.DTO.review_dto;
import com.Ecomerce.flipcart.Entity.review;
import com.Ecomerce.flipcart.Repository.review_repository;

@Service
public class review_service {
	
	private review_repository repo;
	
	public review_service(review_repository repo) {
		this.repo=repo;
	}
	
	
	public review addreviewservice(review review) {
		return repo.save(review);
	}
	
	
	public List<review_dto> getallreviewservice(){
		return repo.findAll().stream()
				.map((review)->
				{review_dto rd = new review_dto();
				rd.setRating(review.getRating());
				rd.setItemname(review.getOrder().getItemname());
				rd.setUserid(review.getUser().getUserid());
				rd.setOrderid(review.getOrder().getOrderid());
				return rd;})
				.collect(Collectors.toList());
	}

}
