package com.projects.Homepage.Japanese.Vocabulary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabRepository extends CrudRepository<Vocab, String> {

    List<Vocab> findByChapter(int chapter);
}
