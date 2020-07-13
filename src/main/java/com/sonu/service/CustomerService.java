package com.sonu.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sonu.beans.Customer;
import com.sonu.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer getCustomer(Integer customer_id)
	{
		return customerRepository.findById(customer_id).get();
	}
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	public String getJSONObject(Integer keyValue)
	{
		String obj=new RestTemplate().getForObject("https://jsonplaceholder.typicode.com/users", String.class);
		JSONArray jsonObject = new JSONArray(obj);
		String output=null;
		for (int i = 0; i < jsonObject.length(); i++)
		{
			JSONObject item = jsonObject.getJSONObject(i);
			if(item.keySet().contains("id") && item.keySet().contains("address"))
			{
				if((int)(item.get("id"))==keyValue)
				{
					output = item.getJSONObject("address").get("geo").toString();//.get("lat");
					break;
				}
			}
		}
		return output;
	}
	public int deleteCustomer(Integer customer_id)
	{
		return customerRepository.deleteCustomer(customer_id);
	}
}