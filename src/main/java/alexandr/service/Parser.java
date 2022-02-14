package alexandr.service;

import alexandr.enitis.Chapter;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class Parser {

    public Chapter getStructure(String[] input) {
        List<Chapter> chapters = Arrays.stream(input).filter(s -> s.matches("#.+"))
                .map(i -> new Chapter(getNesting(i), i))
                .collect(Collectors.toList());
        Chapter mainStructure = new Chapter(0, "Structure");
        Chapter currentChapter = mainStructure;

        for (int i = 0; i < chapters.size(); i++) {
            addChapter(currentChapter, chapters.get(i));
            currentChapter = chapters.get(i);
        }
        return mainStructure;
    }

    private void addChapter(Chapter currentChapter, Chapter newChapter) {
        if (newChapter.getLevel() -1 == currentChapter.getLevel()) {
            newChapter.setPrev(currentChapter);
            currentChapter.addChapter(newChapter);
            return;
        } else {
            addChapter(currentChapter.getPrev(), newChapter);
        }
    }

    private int getNesting(String str) {
        return (str.length() - str.replace("#", "").length());
    }
}
