package alexandr.service;

import alexandr.dto.TextDto;
import alexandr.enitis.Text;
import alexandr.exeptions.ProblemsWithFileException;
import alexandr.exeptions.TextDoesNotFindException;
import alexandr.repository.TextRepo;
import lombok.Data;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@Service
@Data
public class TextService {
    private final TextRepo textRepo;
    private final Parser parser;

    public long loadText(MultipartFile text) {
        try(InputStream stream = text.getInputStream()) {
            return textRepo.save(new Text("13",
                    new String(stream.readAllBytes()).split(System.lineSeparator()))).getText_id();
        } catch (IOException e) {
            throw new ProblemsWithFileException("Problems with file");
        }
    }

    public TextDto getById (long id) {
        Text text;
        try {
            text = textRepo.getById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new TextDoesNotFindException("does not find");
        }
        return new TextDto(text, parser.getStructure(text.getText()));
    }

    public void deleteById (long id) {
        try {
            textRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new TextDoesNotFindException("does not find");
        }
    }
}
