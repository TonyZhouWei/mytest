package cn.itcast.service;

import java.util.List;

import cn.itcast.crm.utils.Page;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface CustomerService {
	/**
	 * 根据条件，分页查询顾客列表
	 * @param qv
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo qv);
	/**
	 * 根据ID查询客户信息
	 * @param id
	 * @return
	 */
	Customer queryCustomerByID(Long id);
	/**
	 * 更新客户数据
	 * @param cm
	 */
	
	void updateCustomer(Customer cm);
	/**
	 * 删除数据
	 * @param id
	 */
	
	void deleteCustomer(Long id);


}
