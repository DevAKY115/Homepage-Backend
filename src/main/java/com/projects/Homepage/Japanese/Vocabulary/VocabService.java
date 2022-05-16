package com.projects.Homepage.Japanese.Vocabulary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class VocabService {

    @Autowired
    VocabRepository vocabRepository;

    void addVocabsFromFile(String path){

        List<Vocab> vocabList;
        try {
/*            String path = "C:\\Users\\berka\\Documents\\Uni\\Japanisch\\vokabeln.txt";*/
            FileInputStream fis = new FileInputStream(path);
            Scanner sc = new Scanner(fis);

            vocabList = new ArrayList<>();
            int chapter = -1;
            String line = "";
            String[] temp;

            String japanese = "";
            List<String> translations = new ArrayList<>();
            while (sc.hasNextLine()) {
                Vocab vocab = new Vocab();
                line = sc.nextLine();
                if (line.length() == 1) {
                    chapter = Integer.parseInt(line);
                    continue;
                }
                if (!line.isEmpty()) {
                    temp = line.split(" - ");
                    japanese = temp[0];
                    translations = Arrays.stream(temp[1].split(",")).toList();
                    vocab.setJapanese(japanese);
                    vocab.setTranslations(translations);
                    vocab.setChapter(chapter);
                    vocabList.add(vocab);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        vocabRepository.saveAll(vocabList);
    }
}
