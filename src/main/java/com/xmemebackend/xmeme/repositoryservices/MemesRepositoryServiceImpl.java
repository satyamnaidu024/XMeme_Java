package com.xmemebackend.xmeme.repositoryservices;

import com.xmemebackend.xmeme.exchanges.PostMemeRequest;
import com.xmemebackend.xmeme.models.MemeEntity;
import com.xmemebackend.xmeme.repositories.MemeRepository;
import com.xmemebackend.xmeme.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.xmemebackend.xmeme.models.MemeEntity.SEQUENCE_NAME;

@Service
public class MemesRepositoryServiceImpl implements  MemesRepositoryService{

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private SequenceGeneratorService service;

    @Override
    public List<MemeEntity> findAllMemes() {

        return memeRepository.findAll();
    }

    @Override
    public MemeEntity saveMeme(PostMemeRequest postMemeRequest) {
        MemeEntity memeEntity = new MemeEntity();
        memeEntity.setName(postMemeRequest.getName());
        memeEntity.setCaption(postMemeRequest.getCaption());
        memeEntity.setUrl(postMemeRequest.getUrl());

        //generate sequence
        memeEntity.setId(service.getSequenceNumber(SEQUENCE_NAME));

        return memeRepository.save(memeEntity);
    }

    @Override
    public MemeEntity findMemeById(Integer id) {
        Optional<MemeEntity> optionalMemeEntity =  memeRepository.findById(id);
        if (optionalMemeEntity.isEmpty()) {
            return null;
        }
        else
        {
            return optionalMemeEntity.get();
        }
    }
}
