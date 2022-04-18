package com.projects.Homepage.Twitter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tweet {

    @Id
    private String tweetId;
    private String authorId;
    private String username;

    public Tweet(){}

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId='" + tweetId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
