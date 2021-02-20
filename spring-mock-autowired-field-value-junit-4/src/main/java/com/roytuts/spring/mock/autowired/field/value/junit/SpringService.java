package com.roytuts.spring.mock.autowired.field.value.junit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SpringService {

	@Value("${security.key}")
	private String securityKey;

	public void updateValue() {
		System.out.println(securityKey);
	}

}
