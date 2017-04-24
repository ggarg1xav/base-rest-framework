package com.neustar.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.neustar.util.ApiWrapper;
import com.neustar.util.ClientException;

public class DemoTest {
	
	@Test
	public void validateApiRequest() throws IOException, ClientException
	{
		ApiWrapper api = new ApiWrapper("https://testrail.charter.com", "p2338703", "Xav@123_123");
		System.out.println(api.invokeHttpGet("/get_results/6406279"));
	}

}
