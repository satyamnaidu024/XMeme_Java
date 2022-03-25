package com.xmemebackend.xmeme.exchanges;

import com.xmemebackend.xmeme.dto.Meme;
import java.util.List;

public class GetMemesResponse {
    List<Meme> memes;

    public List<Meme> getMemes() {
        return memes;
    }

    public void setMemes(List<Meme> memes) {
        this.memes = memes;
    }
}
