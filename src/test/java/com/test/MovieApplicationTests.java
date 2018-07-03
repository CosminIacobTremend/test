package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.test.dto.Response;
import com.test.model.Movie;
import java.util.HashMap;
import java.util.Map;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${api.usage.limit}")
	private Integer usageLimit;


	private HttpHeaders headers;;
	private Map<String, String> parameters;
	private String validEncoding1;
	private String validEncoding2;
	private String wrongEncoding;

	@Before
	public void init() {
		headers = new HttpHeaders();
		Base64 base64 = new Base64();
		parameters = new HashMap<>();
		validEncoding1 = base64.encodeAsString("test1:test1".getBytes());
		validEncoding2 = base64.encodeAsString("test2:test2".getBytes());
		wrongEncoding = base64.encodeAsString("test1:test2".getBytes());
	}

	@Test
	public void contextLoads() {
	}


	@Test
	public void badRequest() {

		ResponseEntity<Response<Movie>> responseEntity = createMovieRequest(validEncoding1);

		assertNotNull(responseEntity.getBody());
		assertEquals(responseEntity.getBody().getStatusCode(), 400);
	}

	@Test
	public void unAuthorizedRequest() {
		ResponseEntity<Response<Movie>> responseEntity = createMovieRequest(wrongEncoding);

		assertNull(responseEntity.getBody());
		assertEquals(responseEntity.getStatusCode().value(), 401);
	}

	@Test
	public void testValidRequest() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/movies")
				.queryParam("genre", "Crime");

		ResponseEntity<Response<Movie>> responseEntity = createMovieRequest(builder.toUriString(), validEncoding1);

		assertEquals(responseEntity.getStatusCode().value(), 200);

	}

	@Test
	public void testThrottling() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/movies")
				.queryParam("genre", "Comedy");

		for (int i = 1; i<= usageLimit; i++) {
			ResponseEntity<Response<Movie>> responseEntity = createMovieRequest(builder.toUriString(), validEncoding2);
			assertEquals(responseEntity.getStatusCode().value(), 200);
		}

		ResponseEntity<Response<Movie>> responseEntity = createMovieRequest(builder.toUriString(), validEncoding2);
		assertEquals(responseEntity.getStatusCode().value(), 429);

	}




	private ResponseEntity<Response<Movie>> createMovieRequest(String encoding) {
		return createMovieRequest("/movies", encoding);
	}

	private ResponseEntity<Response<Movie>> createMovieRequest(String url, String encoding) {
		headers.set("Authorization", "Basic " + encoding);
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		return 	restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<Response<Movie>>(){}, parameters);
	}


}
