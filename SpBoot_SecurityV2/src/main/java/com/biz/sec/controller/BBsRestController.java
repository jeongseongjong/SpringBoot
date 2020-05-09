package com.biz.sec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.sec.domain.BBsVO;
import com.biz.sec.service.BBsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * REST controller
 * spring RESTful Api를 만들기 위한 Controller
 * view 없는 형태로
 * json 데이터를 보내주는 컨트롤러 역할
 */
@RequestMapping(value="/bbs/api")
@RestController
@Slf4j
@RequiredArgsConstructor
public class BBsRestController {

	private final BBsService bService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public List<BBsVO> getBBsList(){
		
		List<BBsVO> bbsList = bService.getBBsList();
		return bbsList;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(BBsVO bbsVO) {
		
		log.debug(bbsVO.toString());
		bService.save(bbsVO);
		return "OK";
	}
}
