package com.lalit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalit.entity.ActorEntity;

public interface IActorRepository extends JpaRepository<ActorEntity, Integer> {

}
