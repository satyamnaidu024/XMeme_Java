package com.xmemebackend.xmeme.services;

import com.xmemebackend.xmeme.dto.Meme;
import com.xmemebackend.xmeme.exchanges.GetMemesResponse;
import com.xmemebackend.xmeme.exchanges.PostMemeRequest;
import com.xmemebackend.xmeme.models.MemeEntity;
import com.xmemebackend.xmeme.repositoryservices.MemesRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemeServiceImpl implements MemeService {

    @Autowired
    MemesRepositoryService memesRepositoryService;

    private Meme convertEntityToDto(MemeEntity memeEntity) {
        Meme memeDto = new Meme();
        memeDto.setId(memeEntity.getId());
        memeDto.setName(memeEntity.getName());
        memeDto.setCaption(memeEntity.getCaption());
        memeDto.setUrl(memeEntity.getUrl());

        return memeDto;
    }

    public static Comparator<MemeEntity> memeComparator = new Comparator<MemeEntity>() {

        public int compare(MemeEntity m1, MemeEntity m2)
        {

            Integer id1
                    = m1.getId();
            Integer id2
                    = m2.getId();

            // ascending order
            return id2 - id1;
        }
    };


    @Override
    public GetMemesResponse getMemes() {

        List<MemeEntity> memesEntities =  memesRepositoryService.findAllMemes();
        List<Meme> memeDtoList = new ArrayList<>();
        Collections.sort(memesEntities,memeComparator);
        int count = 0;
        for(MemeEntity memeEntity : memesEntities)
        {
            if(count>99)
            {
                break;
            }
            Meme currentMeme = convertEntityToDto(memeEntity);
            memeDtoList.add(currentMeme);
            count++;
        }
        GetMemesResponse memesResponse = new GetMemesResponse();
        memesResponse.setMemes(memeDtoList);
        return memesResponse;
    }

    @Override
    public MemeEntity getMemeById(Integer id) {

         return memesRepositoryService.findMemeById(id);

    }

    @Override
    public MemeEntity postMeme(PostMemeRequest postMemeRequest) {

        return memesRepositoryService.saveMeme(postMemeRequest);
    }
}
