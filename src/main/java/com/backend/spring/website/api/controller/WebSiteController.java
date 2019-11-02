package com.backend.spring.website.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.spring.website.api.model.WebSite;
import com.backend.spring.website.api.repository.WebSiteRepository;

@RestController
@RequestMapping("/api")
public class WebSiteController {

	@Autowired
	private WebSiteRepository webSiteRepository;

	  /**
     * metodo para guardar un Web Site.
     * 
     * @param 
     * @return  WebSite
     */
    @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/websites", method = RequestMethod.POST,
    headers = {"token=123456789"})
	public WebSite save(@RequestBody WebSite webSite) {
	 
		WebSite webSiteNew = null;
		webSiteNew = webSiteRepository.save(webSite);
		
		return webSiteNew;
	}

	  /**
     * metodo para listar los Web Sites.
     * @param
     * @return  List WebSite
     */
	@RequestMapping(value = "/websites", method = RequestMethod.GET,
		    headers = {"token=123456789"})
	public List<WebSite> list() {
		return webSiteRepository.findAll();
	}

	  /**
     * metodo para buscar un Web Site por Id.
     * @param id
     * @return WebSite
     */
	@RequestMapping(value = "/websites/{id}", method = RequestMethod.GET,
    headers = {"token=123456789"})
	public ResponseEntity<?> show(@PathVariable long id,
			@RequestHeader(name = "token", defaultValue = "123456789"  ) int token)
	                 throws Exception{
		Optional<WebSite> webSite = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			webSite = webSiteRepository.findById(id);
			if(webSite.get().getOwnerId()== id) {
				return new ResponseEntity<Optional<WebSite>>(webSite, HttpStatus.OK);
			}
		}catch(Exception e) {
			response.put("mensaje", "El web site no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<WebSite>>(webSite, HttpStatus.OK);
	}

	  /**
     * metodo para eliminar un Web Site indicando su Id.
     * 
     * @param id
     * @return
     */
	@RequestMapping(value = "/websites/{id}", method = RequestMethod.DELETE,
	headers = {"token=123456789"})
	public String deleteBook(@PathVariable long id) {
		webSiteRepository.deleteById(id);
		return "web site deleted with id : " + id;
	}

}
