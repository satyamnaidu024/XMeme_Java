package com.xmemebackend.xmeme.repositoryservices;

import com.xmemebackend.xmeme.exchanges.PostMemeRequest;
import com.xmemebackend.xmeme.models.MemeEntity;

import java.util.List;

public interface MemesRepositoryService {

 List<MemeEntity> findAllMemes();

 MemeEntity saveMeme(PostMemeRequest postMemeRequest);

    MemeEntity findMemeById(Integer id);
}
