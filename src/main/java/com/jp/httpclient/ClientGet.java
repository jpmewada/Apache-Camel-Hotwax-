/*package com.jp.httpclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientGet {

  public static void main(String[] args) {
	try {
		System.out.println("-------Start of Program-----------\n");
		Client client = Client.create();

		WebResource webResource = client
		   .resource("https://hc-qa.hotwax.co/api/getAuthenticationToken?USERNAME=admin&PASSWORD=hotwax@786");

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output + "\n");

	  } catch (Exception e) {

		e.printStackTrace();

	  }
	System.out.println("-------End of Program-----------");
	}
}*/