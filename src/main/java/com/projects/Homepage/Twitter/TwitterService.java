package com.projects.Homepage.Twitter;


import com.projects.Homepage.Twitter.List.Data;
import com.projects.Homepage.Twitter.List.TweetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.persistence.OrderBy;
import java.util.LinkedList;
import java.util.List;

@Service
public class TwitterService {

    String bearer = System.getenv("TWITTER_BEARER_TOKEN");

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    TweetRepository tweetRepository;

    //@Scheduled(fixedRate = 60000)
    public void getTweets(){

        System.out.println("Getting new tweets");

        TweetList list = webClientBuilder.build()
                .get()
                .uri("https://api.twitter.com/2/lists/1364893823852240896/tweets?user.fields=username&max_results=3&expansions=author_id")
                .header("Authorization", String.format("Bearer %s", this.bearer))
                .retrieve()
                .bodyToMono(TweetList.class)
                .block();

        List<Tweet> tweets = new LinkedList<>();

        for(Data data : list.getData()){


            //If text begins with "RT" its a retweet and will be discarded
            if(data.getText().startsWith("RT")) {
                continue;
            }

            Tweet result = new Tweet();
            result.setAuthorId(data.getAuthorId());
            result.setTweetId(data.getId());

            for(com.projects.Homepage.Twitter.List.User user : list.getIncludes().getUsers()){
                if(user.getId().equals(result.getAuthorId())){
                    result.setUsername(user.getUsername());
                }
            }
            tweets.add(result);
        }

        tweetRepository.saveAll(tweets);
    }

    public void get100Tweets(){

        System.out.println("Getting 100 new tweets");

        TweetList list = webClientBuilder.build()
                .get()
                .uri("https://api.twitter.com/2/lists/1364893823852240896/tweets?user.fields=username&max_results=100&expansions=author_id")
                .header("Authorization", String.format("Bearer %s", this.bearer))
                .retrieve()
                .bodyToMono(TweetList.class)
                .block();

        List<Tweet> tweets = new LinkedList<>();

        for(Data data : list.getData()){


            //If text begins with "RT" its a retweet and will be discarded
            if(data.getText().startsWith("RT")) {
                continue;
            }

            Tweet result = new Tweet();
            result.setAuthorId(data.getAuthorId());
            result.setTweetId(data.getId());

            for(com.projects.Homepage.Twitter.List.User user : list.getIncludes().getUsers()){
                if(user.getId().equals(result.getAuthorId())){
                    result.setUsername(user.getUsername());
                }
            }
            tweets.add(result);
        }

        tweetRepository.saveAll(tweets);
    }

    public List<Tweet> getList(int page){
        page--;
        return tweetRepository.findAll(PageRequest.of(page, 10, Sort.Direction.DESC, "tweetId")).get().toList();
    }

/*    public List<Tweet> getList(){
        int page = 1;
        return (List<Tweet>) tweetRepository.findAllByOrderByTweetIdDesc(PageRequest.of(page, 10));
    }*/

/*    public List<Tweet> getList(){
        return (List<Tweet>) tweetRepository.findFirst10ByOrderByTweetIdDesc();
    }*/


}
