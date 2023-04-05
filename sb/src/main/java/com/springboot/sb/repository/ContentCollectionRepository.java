package com.springboot.sb.repository;

import com.springboot.sb.model.Content;
import com.springboot.sb.model.Status;
import com.springboot.sb.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(i -> i.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content(1, "First blog", "Fist post", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null,"");
        contentList.add(c);
    }

    public void save(Content content){
        contentList.add(content);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(i -> i.id().equals(id)).count() == 1;
    }
}
