package com.lalit.service;

import com.lalit.vo.ActorVO;

public interface IActorMgntService {

	public String insertActorData(ActorVO actorVO);

	public String insertActorsData(Iterable<ActorVO> actorsVO);
	
	public Iterable<ActorVO> getAllActorsData();
}
