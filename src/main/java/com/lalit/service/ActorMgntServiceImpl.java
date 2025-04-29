package com.lalit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalit.entity.ActorEntity;
import com.lalit.repository.IActorRepository;
import com.lalit.vo.ActorVO;

@Service("actor-service")
public class ActorMgntServiceImpl implements IActorMgntService {

	@Autowired
	private IActorRepository actorRepo;

	@Override
	public String insertActorData(ActorVO actorVO) {
		ActorEntity aEntity = new ActorEntity();
		BeanUtils.copyProperties(actorVO, aEntity);
		aEntity.setCreatedBy(System.getProperty("user.name"));
		Integer aid = actorRepo.save(aEntity).getAid();
		return " Actor Data Registered with Id :: " + aid;
	}
	
	@Override
	public String insertActorsData(Iterable<ActorVO> actorsVO) {
		
		List<ActorEntity> actorEntities=new ArrayList<>();
		actorsVO.forEach((vo)->
		{
			ActorEntity aEntity=new ActorEntity();
			BeanUtils.copyProperties(vo, aEntity);
			aEntity.setCreatedBy(System.getProperty("user.name"));
			actorEntities.add(aEntity);
		});
		List<ActorEntity> saveAll = actorRepo.saveAll(actorEntities);
		List<Integer> allId = StreamSupport.stream(saveAll.spliterator(), false).map(ActorEntity::getAid)
        .collect(Collectors.toList());
		return allId.size()+" Actors Data Stored successfully... with Id's :: "+allId;
	}

	@Override
	public Iterable<ActorVO> getAllActorsData() {
		
		List<ActorEntity> all = actorRepo.findAll();
		List<ActorVO> actorsList=new ArrayList<>();
		all.forEach((a)->
		{
			ActorVO actorVo=new ActorVO();
			BeanUtils.copyProperties(a,actorVo);
			actorsList.add(actorVo);
		});
		return actorsList;
	}
	
	

}
