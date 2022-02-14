package alexandr.enitis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Chapter {
    private List<Chapter> chapters = new ArrayList<>();
    @JsonIgnore
    private final int level;
    private final String text;
    @JsonIgnore
    private Chapter prev;

    public Chapter(int level, String text) {
        this.level = level;
        this.text = text;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }
}