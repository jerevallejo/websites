package com.backend.spring.website.api.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    headers = {"token=123456789"}, consumes = "application/json")
	public WebSite save(@RequestBody WebSite webSite) throws SecurityException {
    	Long id = null;
    	List<WebSite> webSites = webSiteRepository.findAll();
    	id = nextId(webSites);
		WebSite webSiteNew = new WebSite();
		webSiteNew.setId(id);
		webSiteNew.setDomain(webSite.getDomain());
		webSiteNew.setLabels(webSite.getLabels());
		webSiteNew.setOwnerId(webSite.getOwnerId());
		webSiteNew.setLeadCount(webSite.getLeadCount());
		webSiteNew.setPlan(webSite.getPlan());
		
		return webSiteRepository.save(webSiteNew);
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
	public ResponseEntity<?> show(@PathVariable int id)
	{
		Optional<WebSite> webSite = null;
		
		webSite = webSiteRepository.findById(id);

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
	public String deleteBook(@PathVariable int id) {
		webSiteRepository.deleteById(id);
		return "web site deleted with id : " + id;
	}

	private long nextId(List<WebSite> webSites) {
		  long cantId = 0;
		  
		  for(WebSite web : webSites)
			  if(web.getId()> cantId) {
				  cantId = web.getId();
			  }
		  cantId ++;
		return cantId;
	}
}
