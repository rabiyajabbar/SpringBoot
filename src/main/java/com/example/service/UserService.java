package com.example.service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.model.User;


@Service
public class UserService {

    private MongoOperations mongoOperations;

    @Autowired
    public UserService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(Long UserId ) {

        User counter = mongoOperations.findAndModify(query(where("_id").is(UserId)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                User.class);
        return !Objects.isNull(counter) ? counter.getId() : 1;

    }
}

