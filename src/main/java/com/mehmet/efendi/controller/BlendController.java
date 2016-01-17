package com.mehmet.efendi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.efendi.dto.BlendDto;
import com.mehmet.efendi.service.BlendService;

@RestController
@RequestMapping("/blend")
public class BlendController {
	private static Logger LOGGER = LoggerFactory.getLogger(BlendController.class);

	@Autowired
	private BlendService blendService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
	public ResponseEntity<List<BlendDto>> responselist() {
		try {
			return new ResponseEntity<List<BlendDto>>(getBlendDtoList(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<List<BlendDto>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/blendDtoList", method = RequestMethod.GET)
	public List<BlendDto> blendDtoList() {
		return getBlendDtoList();
	}

	private List<BlendDto> getBlendDtoList() {
		LOGGER.debug("blend list wanted");
		List<BlendDto> blendDtoList = blendService.getAllBlendDtoList();
		LOGGER.debug("blend list given by service");
		return blendDtoList;
	}
}
