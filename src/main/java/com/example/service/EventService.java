package com.example.service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.model.Event;


@Service
public class EventService {

    private MongoOperations mongoOperations;

    @Autowired
    public EventService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String EventName) {

        Event counter = mongoOperations.findAndModify(query(where("_id").is(EventName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Event.class);
        return !Objects.isNull(counter) ? counter.getId() : 1;

    }
}

