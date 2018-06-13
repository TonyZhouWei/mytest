package cn.itcast.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.crm.utils.Page;
import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.BasicDictService;
import cn.itcast.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private BasicDictService bdsi;
	@Autowired
	private CustomerService cs;

	@Value("${FROM_TYPE_CODE}")
	private String FROM_TYPE_CODE;
	@Value("${INDUSTRY_TYPE_CODE}")
	private String INDUSTRY_TYPE_CODE;
	@Value("${LEVEL_TYPE_CODE}")
	private String LEVEL_TYPE_CODE;

	/**
	 * 显示顾客列表
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String queryCustomerList(Model m, QueryVo qv) {
		// 解决get请求乱码问题
		try {
			if(qv!=null){
				String str = new String(qv.getCustName().getBytes("iso-8859-1"), "utf-8");
				qv.setCustName(str);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 获取初始化下拉框数据
		List<BaseDict> fromType = this.bdsi.queryBasicDictByDictTypeCode(FROM_TYPE_CODE);
		List<BaseDict> industryType = this.bdsi.queryBasicDictByDictTypeCode(INDUSTRY_TYPE_CODE);
		List<BaseDict> levelType = this.bdsi.queryBasicDictByDictTypeCode(LEVEL_TYPE_CODE);

		m.addAttribute("fromType", fromType);
		m.addAttribute("industryType", industryType);
		m.addAttribute("levelType", levelType);

		// 分页、条件查询列表
		Page<Customer> page = this.cs.queryCustomerByQueryVo(qv);
		m.addAttribute("page", page);

		// 设置下拉框回显
		m.addAttribute("custSource", qv.getCustSource());
		m.addAttribute("custIndustry", qv.getCustIndustry());
		m.addAttribute("custLevel", qv.getCustLevel());
		m.addAttribute("cust_name", qv.getCustName());

		return "customer";
	}
	
	/**
	 * 数据回显,按ID查询数据
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Customer queryCustomerByID(Long id){
		Customer cm=this.cs.queryCustomerByID(id);
		return cm;
	}
	
	/**
	 * 更新数据
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateCustomer(Customer cm){
		this.cs.updateCustomer(cm);
		return "ok";
	}
	
	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteCustomer(Long id){
		this.cs.deleteCustomer(id);
		return "ok";
	}
}
