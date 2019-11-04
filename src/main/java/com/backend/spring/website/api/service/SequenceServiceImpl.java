package com.backend.spring.website.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.backend.spring.website.api.exception.SequenceException;
import com.backend.spring.website.api.model.Sequence;

@Repository
public class SequenceServiceImpl implements SequenceService{

	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public long getNextSequenceId(String key) throws SequenceException {
		
		//get sequence id
		Query query = new Query(Criteria.where("_id").is(key));
		
		//increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);
		
		//return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		
		Sequence seqId = mongoOperation.findAndModify(query, update, options, Sequence.class);
		//if no id, throw Sequence Exception	
		if (seqId == null) {
			seqId = new Sequence();
			seqId.setId(key);
			seqId.setSeq((long) 1);
			mongoOperation.insert(seqId);
			return 1;
		}else {
			return seqId.getSeq();
		}
	}

}
