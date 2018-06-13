package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface BaseDictMapper {

	public List<BaseDict> queryBasicDictByDictTypeCode(String code);

	
	
	
}
