package com.xmemebackend.xmeme.controller;

import java.util.List;
import java.util.Optional;

import com.xmemebackend.xmeme.dto.Meme;
import com.xmemebackend.xmeme.exchanges.GetMemesResponse;
import com.xmemebackend.xmeme.exchanges.PostMemeRequest;
import com.xmemebackend.xmeme.models.MemeEntity;
import com.xmemebackend.xmeme.repositories.MemeRepository;
import com.xmemebackend.xmeme.services.MemeService;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemeController {

    @Autowired
    MemeService memeService;

    @Autowired
    MemeRepository memeRepository;

    @GetMapping("/memes")
    public ResponseEntity<List<Meme>> getMemes()
    {
        GetMemesResponse getMemesResponse;
        getMemesResponse = memeService.getMemes();
        if(getMemesResponse.getMemes().size()<=0)
        {
            return ResponseEntity.status(HttpStatus.OK).body(getMemesResponse.getMemes());
        }
        return ResponseEntity.of(Optional.of(getMemesResponse.getMemes()));
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<MemeEntity> getMemeById(@PathVariable Integer id)
    {
        MemeEntity memeEntity = memeService.getMemeById(id);
        if(memeEntity == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.of(Optional.of(memeEntity));
        }

    }

    @PostMapping("/memes")
    public ResponseEntity postMeme(@RequestBody PostMemeRequest postMemeRequest)
    {
        if(postMemeRequest.getName()==null && postMemeRequest.getCaption()==null && postMemeRequest.getUrl()==null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String name = postMemeRequest.getName();
        String caption = postMemeRequest.getCaption();
        String url = postMemeRequest.getUrl();
        List<MemeEntity> ans =  memeRepository.getMemesByNameAndCaptionAndUrl(name,caption,url);
        if(ans.size()>0)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
       MemeEntity postedMeme =  memeService.postMeme(postMemeRequest);
       if(postedMeme !=null)
       {
        JSONObject jo = new JSONObject();
        jo.put("id", postedMeme.getId().toString());
        
           return ResponseEntity.status(HttpStatus.CREATED).body(jo.toString());
       }
       else
       {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }



}