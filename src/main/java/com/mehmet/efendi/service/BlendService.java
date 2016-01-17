package com.mehmet.efendi.service;

import java.util.List;

import com.mehmet.efendi.dto.BlendDto;
import com.mehmet.efendi.entity.Blend;

public interface BlendService extends BaseService<Blend, Long> {
	public List<BlendDto> getAllBlendDtoList();
}
