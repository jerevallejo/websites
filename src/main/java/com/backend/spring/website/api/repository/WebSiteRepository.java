package com.backend.spring.website.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.spring.website.api.model.WebSite;

public interface WebSiteRepository extends MongoRepository<WebSite, Integer>{

}
