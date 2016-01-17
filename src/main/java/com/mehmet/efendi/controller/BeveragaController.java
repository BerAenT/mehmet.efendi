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

import com.mehmet.efendi.dto.BeverageDto;
import com.mehmet.efendi.service.BeverageService;

@RestController
@RequestMapping("/beverage")
public class BeveragaController {
	private static Logger LOGGER = LoggerFactory.getLogger(BeveragaController.class);

	@Autowired
	private BeverageService beverageService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
	public ResponseEntity<List<BeverageDto>> responselist() {
		try {
			return new ResponseEntity<List<BeverageDto>>(getBeverageDtoList(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<List<BeverageDto>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/beverageDtoList", method = RequestMethod.GET)
	public List<BeverageDto> beverageDtoList() {
		return getBeverageDtoList();
	}

	private List<BeverageDto> getBeverageDtoList() {
		LOGGER.debug("beverage list wanted");
		List<BeverageDto> beverageDtoList = beverageService.getAllBeverageDtoList();
		LOGGER.debug("beverage list given by service");
		return beverageDtoList;
	}
}
