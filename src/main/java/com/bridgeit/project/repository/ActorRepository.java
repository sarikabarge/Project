package com.bridgeit.project.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgeit.project.model.Actor;


@Repository
public interface ActorRepository extends JpaRepository<Actor,Long>{

	Optional<Actor> findByName(String name);

	Optional<Actor> findByActorId(String string);

}
