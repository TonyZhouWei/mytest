package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crm.utils.Page;
import cn.itcast.mapper.CustomerMapper;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper cm;

	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo qv) {
		
		Integer start=(qv.getPage()-1)*qv.getRows();
		qv.setStart(start);
		
		List<Customer> rows = this.cm.queryCustomerByQueryVo(qv);
		
		Integer count=this.cm.queryCustomerCount(qv);
		
		return new Page<Customer>(count, qv.getPage(), qv.getRows(), rows);
		
	}

	@Override
	public Customer queryCustomerByID(Long id) {
		return this.cm.queryCustomerByID(id);
	}

	@Override
	public void updateCustomer(Customer cm) {
		this.cm.updateCustomer(cm);
	}

	@Override
	public void deleteCustomer(Long id) {
		this.cm.deleteCustomer(id);
	}

}
