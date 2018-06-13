package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface CustomerMapper {
	public List<Customer> queryCustomerByQueryVo(QueryVo qv);

	public Integer queryCustomerCount(QueryVo qv);

	public Customer queryCustomerByID(Long id);

	public void updateCustomer(Customer cm);

	public void deleteCustomer(Long id); 

}
