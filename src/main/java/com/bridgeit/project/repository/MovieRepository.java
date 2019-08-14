package com.bridgeit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgeit.project.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

	//public Optional<User> findByEmailId(String emailId);
//	public Optional<Actor> findByActorId(long actorId);

}