package com.mehmet.efendi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehmet.efendi.dto.BlendDto;
import com.mehmet.efendi.entity.Blend;

@Service("blendService")
public class BlendServiceImp extends BaseServiceImp<Blend, Long> implements BlendService {

	@Override
	@Transactional(readOnly = true)
	public List<BlendDto> getAllBlendDtoList() {
		List<BlendDto> blendDtoList = new ArrayList<BlendDto>();
		for(Blend blend : findAll()){
			blendDtoList.add(new BlendDto(blend));
		}
		return blendDtoList;
	}

}
