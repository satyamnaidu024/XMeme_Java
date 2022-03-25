package com.xmemebackend.xmeme.repositories;

import com.xmemebackend.xmeme.models.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MemeRepository extends MongoRepository<MemeEntity,Integer> {

    @Query("{ 'name' : ?0 , 'caption' : ?1 , 'url' : ?2}")
    List<MemeEntity> getMemesByNameAndCaptionAndUrl(String name, String caption, String url);
}
