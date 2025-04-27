package com.lalit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.entity.ActorEntity;
import com.lalit.repository.IActorRepository;

@Service
public class ActorServiceManagementImpl implements IActorServiceManagement {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public String registerActorData(ActorEntity actor) {

		if (actor != null) {
			Integer aid = actorRepo.save(actor).getAid();
			return "Actor Data Registered with ID " + aid;
		}
		throw new IllegalArgumentException("Illegal Argument...");
	}

}
