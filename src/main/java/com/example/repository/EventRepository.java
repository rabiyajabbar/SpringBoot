package com.example.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Event;


@Repository
public interface EventRepository extends MongoRepository<Event, Long>{

}