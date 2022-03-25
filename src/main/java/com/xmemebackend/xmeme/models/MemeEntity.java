package com.xmemebackend.xmeme.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "memes")
public class MemeEntity {

    @Transient
    public static final String  SEQUENCE_NAME ="meme_sequence";


    @Id
    private Integer id;
    private String name;
    private String caption;
    private String url;

}
