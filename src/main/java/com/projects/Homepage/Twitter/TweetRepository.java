package com.projects.Homepage.Twitter;

import com.projects.Homepage.Todos.Todo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, String>, PagingAndSortingRepository<Tweet, String> {

    Iterable<Tweet> findAllByOrderByTweetIdDesc();
    Iterable<Tweet> findFirst10ByOrderByTweetIdDesc(PageRequest of);
}
