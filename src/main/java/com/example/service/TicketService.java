package com.example.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.example.model.Ticket;


@Service
public class TicketService {

    private MongoOperations mongoOperations;

    @Autowired
    public TicketService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String TicketId) {

        Ticket counter = mongoOperations.findAndModify(query(where("_id").is(TicketId)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Ticket.class);
        return !Objects.isNull(counter) ? counter.getId() : 1;

    }
}

