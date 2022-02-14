package alexandr.dto;

import alexandr.enitis.Chapter;
import alexandr.enitis.Text;
import lombok.Data;

@Data
public class TextDto {
    private final Chapter structure;
    private final String[] text;

    public TextDto(Text text, Chapter structure) {
        this.structure = structure;
        this.text = text.getText();
    }
}