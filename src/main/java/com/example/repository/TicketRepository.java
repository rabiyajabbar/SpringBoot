package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Ticket;


@Repository
public interface TicketRepository extends MongoRepository<Ticket, Long>{

}