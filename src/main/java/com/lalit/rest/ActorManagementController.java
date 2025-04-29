package com.lalit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.service.IActorMgntService;
import com.lalit.vo.ActorVO;

@RestController
@RequestMapping("/actor-api")
public class ActorManagementController {

	@Autowired
	private IActorMgntService actorService;

	@PostMapping("/register")
	public ResponseEntity<String> regiterActorData(@RequestBody ActorVO actorVO) {
		try {
			String msg = actorService.insertActorData(actorVO);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/register-all-actors")
	public ResponseEntity<String> registerActorsData(@RequestBody List<ActorVO> actorsVO)
	{
		try
		{
			  String msg=actorService.insertActorsData(actorsVO);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Illegal Arguments",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-all-actors")
	public ResponseEntity<?>  showAllActorsData()
	{
	  try
	  {
		  Iterable<ActorVO> allActorsData = actorService.getAllActorsData();
			return new ResponseEntity(allActorsData,HttpStatus.OK);
	  }
	  catch (Exception e) {
		  return new ResponseEntity("Illegal Response",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

}
