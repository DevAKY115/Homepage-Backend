package com.projects.Homepage.Japanese.Vocabulary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VocabController {

    @Autowired
    VocabRepository vocabRepository;
    @Autowired
    VocabService vocabService;
    public static final String DIRECTORY = "C:\\Users\\berka\\Pictures\\Test";


    @GetMapping("/japanese/vocabs/allVocabs")
    public Iterable<Vocab> getAllVocabs(){
        return this.vocabRepository.findAll();
    }

    @GetMapping("/japanese/vocabs/{chapter}")
    public Iterable<Vocab> getVocabsByChapter(@PathVariable int chapter){
        return this.vocabRepository.findByChapter(chapter);
    }

    @PutMapping("/japanese/vocabs/updateVocab")
    public Vocab updateVocab(@RequestBody Vocab newVocab){
        this.vocabRepository.save(newVocab);
        return newVocab;
    }

    @PostMapping("/japanese/vocabs/createVocab")
    public Vocab createVocab(@RequestBody Vocab newVocab){
        this.vocabRepository.save(newVocab);
        return newVocab;
    }

    @PostMapping("/japanese/vocabs/saveList")
    public String saveList(@RequestParam("file") MultipartFile file) throws IOException {

        if(file != null) {
            String filename = file.getOriginalFilename();
            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            vocabService.addVocabsFromFile(fileStorage.toString());
            return filename;
        }

        return "Error";
    }


}
