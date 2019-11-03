package com.backend.spring.website.api.service;

import com.backend.spring.website.api.exception.SequenceException;

public interface SequenceService {

	long getNextSequenceId(String key) throws SequenceException;
}
