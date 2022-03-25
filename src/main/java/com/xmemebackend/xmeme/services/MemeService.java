package com.xmemebackend.xmeme.services;

import com.xmemebackend.xmeme.exchanges.GetMemesResponse;
import com.xmemebackend.xmeme.exchanges.PostMemeRequest;
import com.xmemebackend.xmeme.models.MemeEntity;


public interface MemeService {

    public GetMemesResponse getMemes();

    public MemeEntity getMemeById(Integer id);

    public MemeEntity postMeme(PostMemeRequest postMemeRequest);
}
