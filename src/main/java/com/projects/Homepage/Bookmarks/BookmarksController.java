package com.projects.Homepage.Bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookmarksController {

    @Autowired
    BookmarksRepository bookmarksRepository;

    @GetMapping("/bookmarks/allBookmarks")
    public Iterable<Bookmark> getAllBookmarks(){
        return this.bookmarksRepository.findAll();
    }

    @GetMapping("/bookmarks/{id}")
    public Bookmark getBookmark(@PathVariable int id){
        return bookmarksRepository.findById(id).get();
    }

    @DeleteMapping("/bookmarks/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable int id){
        bookmarksRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("bookmarks/{id}")
    public Bookmark updateBookmark(@PathVariable int id, @RequestBody Bookmark newBookmark){
        Bookmark result = bookmarksRepository.save(newBookmark);
        return result;
    }

    @PostMapping("bookmarks/{id}")
    public Bookmark createBookmark(@PathVariable int id, @RequestBody Bookmark newBookmark){
        Bookmark result = bookmarksRepository.save(newBookmark);
        return result;
    }
}
