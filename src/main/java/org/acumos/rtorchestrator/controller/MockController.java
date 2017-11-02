package org.acumos.rtorchestrator.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.acumos.rtorchestrator.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.io.IOUtils;


import io.swagger.annotations.ApiParam;

@RestController
public class MockController {
	private static final Logger logger = LoggerFactory.getLogger(MockController.class);

	private static Blueprint blueprint = null;
	private static DockerInfoList dockerlist = null;

	@RequestMapping(value = "/aggregate", consumes = { "application/octet-stream" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> aggregate(
			@ApiParam(value = "For testing purpose. This method will just spit out the input binary stream", required = true) @Valid @RequestBody byte[] request) {
		logger.info("Receiving /aggregate request: ");
		

		return new ResponseEntity<byte[]>(request, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/generate", consumes = { "application/octet-stream" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> generate(
			@ApiParam(value = "For testing purpose. This method will just spit out the input binary stream", required = true) @Valid @RequestBody byte[] request) {
		logger.info("Receiving /generate request: ");
		

		return new ResponseEntity<byte[]>(request, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/predict", consumes = { "application/octet-stream" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> predict(
			@ApiParam(value = "For testing purpose. This method will just spit out the input binary stream", required = true) @Valid @RequestBody byte[] request) {
		logger.info("Receiving /predict request: ");
		

		return new ResponseEntity<byte[]>(request, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transform", consumes = { "application/octet-stream" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> transform(
			@ApiParam(value = "For testing purpose. This method will just spit out the input binary stream.", required = true) @Valid @RequestBody byte[] request) {
		logger.info("Receiving /transform request: ");
		

		return new ResponseEntity<byte[]>(request, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/classify", consumes = { "application/octet-stream" }, method = RequestMethod.POST)
	public ResponseEntity<byte[]> classify(
			@ApiParam(value = "For testing purpose. This method will just spit out the input binary stream.", required = true) @Valid @RequestBody byte[] request) {
		logger.info("Receiving /classify request: ");
		

		return new ResponseEntity<byte[]>(request, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/putBlueprint", consumes = { "application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Void> putBlueprint(
			@ApiParam(value = "Blueprint JSON", required = true) @Valid @RequestBody Blueprint blueprint) {
		logger.info("Receiving /putBlueprint request: " + blueprint.toString());
		this.blueprint = blueprint;

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/putDockerInfo", consumes = { "application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Void> putDockerInfo(
			@ApiParam(value = "Docker Info JSON", required = true) @Valid @RequestBody DockerInfoList dockerlist) {
		logger.info("Receiving /putDockerInfo request: " + dockerlist.toString());
		this.dockerlist = dockerlist;

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	private byte[]  httpPost(String url, byte[] binary_stream) throws Exception {
		
		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/octet-stream;");
		con.setDoOutput(true);
		OutputStream out = con.getOutputStream();
		out.write(binary_stream);
		out.flush();
		out.close();
		logger.info("HTTPS POST Request Sent ::" + url);
		String responseMessage = con.getResponseMessage();
		logger.info("GOT RESPONSE Message " + responseMessage);
		int responseCode = con.getResponseCode();
		logger.info("GOT RESPONSE CODE " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			byte[] outputbytes = IOUtils.toByteArray(con.getInputStream());
			return outputbytes;
			
		} else {
			logger.error("ERROR:::::::POST request did not work. " + url);
		}

		return null;

	}

	private Map<String, Object> httpGet(String url) throws Exception {
		URL obj = new URL(url);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		// con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			responseMap.put("ResponseContents", response.toString());
			responseMap.put("status", "ok");

			logger.info("HTTPS GET Response Received ::" + response.toString());

		} else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
			responseMap.put("status", "ok");
		} else {
			logger.error("GET request not worked");
		}
		responseMap.put("HTTPResponseCode", responseCode);

		return responseMap;

	}

}
