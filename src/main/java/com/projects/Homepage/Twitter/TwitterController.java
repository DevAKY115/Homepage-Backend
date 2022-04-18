package com.projects.Homepage.Twitter;

import com.projects.Homepage.Twitter.List.TweetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TwitterController {

    @Autowired
    TwitterService service;

    @GetMapping("/twitter/getTweets")
    public void getTweets(){
        service.getTweets();
    }

    @GetMapping("/twitter/get100Tweets")
    public void get100Tweets(){
        service.get100Tweets();
    }

    @GetMapping("/twitter/list/{page}")
    public List<Tweet> list(@PathVariable int page){
        return service.getList(page);
    }


}
