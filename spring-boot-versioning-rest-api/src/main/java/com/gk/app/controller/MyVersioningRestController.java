package com.gk.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.app.dto.Name;
import com.gk.app.dto.PersonV1;
import com.gk.app.dto.PersonV2;
/**
 * 
 * @author gangadhar.
 */
@RestController
public class MyVersioningRestController {
/**
 * 
 * this below two methods are two versions, first one gives name of personv1 and second one gives name of personv2
 * This is called as URI versioning
 */
	@GetMapping(value="/v1/name")
	public PersonV1 personV1() {
		return new PersonV1("Gangadhar");
	}
	@GetMapping(value="/v2/name")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Gangadhar", "Kasturi"));
	}
	/**
	 * 
	 * this below two methods are versioned based on request paramaters.
	 * This is called as Request parameter versioning OR parameter versioning.
	 */
	@GetMapping(value="/person/param",params="version1") //http://localhost:8081/person/param?version1
	public PersonV1 usingParamsPersonV1() {
		return new PersonV1("Gangadhar");
	}
	@GetMapping(value="/person/param",params="version2") //http://localhost:8081/person/param?version2
	public PersonV2 usingParamsPersonV2() {
		return new PersonV2(new Name("Gangadhar", "Kasturi"));
	}
	
	/**
	 * 
	 * @This below two methods are versioned based on request headers.
	 * This is called as Header versioning.
	 * you have to pass key value pairs of X-API-VERSION=1 or X-API-VERSION=2 in request headers.
	 */
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 usingHeadersPersonV1() {
		return new PersonV1("Gangadhar");
	}
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 usingHeadersPersonV2() {
		return new PersonV2(new Name("Gangadhar", "Kasturi"));
	}
	
	/**
	 * 
	 * @the below two methods are versioned based on MIME types OR produces.
	 * This is called as MIME type versioning.
	 * This is also called as content-negotiation versioning.
	 * produces is sent to rest api using ACCEPT key in request header.
	 */
	@GetMapping(value="/person/produces",produces="application/com.gangadhar.app-v1+json")
	public PersonV1 usingProducesPersonV1() {
		return new PersonV1("Gangadhar");
	}
	@GetMapping(value="/person/produces",produces="application/com.gangadhar.app-v2+json")
	public PersonV2 usingProducessPersonV2() {
		return new PersonV2(new Name("Gangadhar", "Kasturi"));
	}
	
	/**
	 * in case of URI versioning type or parameter versioning , we are polluting the URI space.
	 * but for these two types, caching is implemeted easily.
	 * and any browser can send this type of requests directly as the URL consists of everything.
	 * 
	 * But in case of MIME type and Header versioning , caching is not possible/difficult to implement as
	 * we have to look for the headers everytime.
	 * and this requests can never be sent by a normal web browser as request headers/mime types has to be sent
	 * to rest API. So user should have a bit of technical knowledge for this.
	 * 
	 *  So there is not a way to define what is the best one to implement.
	 *  You have to look on it based on the need
	 * 
	 */
	
}
