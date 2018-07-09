package com.adaptavist.tm4j.jenkis;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.adaptavist.tm4j.jenkins.RestClient;

@Ignore
public class RestClientTest {

	private static final String PROJECT_KEY = "JP";
	private static final String SERVER_ADDRESS = "http://localhost:2990/jira";
	private String username = "admin";
	private String password = "admin";
	private List<File> files = new ArrayList<File>();
	
	@Test
	public void shouldLoadTm4JReporter() throws Exception {
		files.add(new File("src/test/resources/result.json"));
		RestClient restClient = new RestClient();
		int response = restClient.sendFiles(SERVER_ADDRESS, PROJECT_KEY, username , password, files);
		assertEquals(201, response);
	}

	@Test
	public void shouldValidateCredentials() throws Exception {
		RestClient restClient = new RestClient();
		assertEquals(true, restClient.isValidCredentials(SERVER_ADDRESS, username, password));
	}
}
