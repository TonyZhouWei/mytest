package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.BaseDictMapper;
import cn.itcast.pojo.BaseDict;
import cn.itcast.service.BasicDictService;

@Service
public class BasicDictServiceImpl implements BasicDictService {
	@Autowired
	private BaseDictMapper bdm;

	@Override
	public List<BaseDict> queryBasicDictByDictTypeCode(String code) {
		return this.bdm.queryBasicDictByDictTypeCode(code);
	}

	
}
