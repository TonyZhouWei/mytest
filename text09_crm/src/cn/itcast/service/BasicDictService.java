package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface BasicDictService {
	/**
	 * 根据typecode，查询BasicDict列表
	 * @param string
	 * @return
	 */
	List<BaseDict> queryBasicDictByDictTypeCode(String code);
	

}
