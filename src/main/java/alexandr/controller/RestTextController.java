package alexandr.controller;

import alexandr.dto.SuccessDto;
import alexandr.dto.TextDto;
import alexandr.service.TextService;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/text")
public class RestTextController {

    private final TextService textService;

    public RestTextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public long loadText (@RequestBody MultipartFile textFile) {
        return textService.loadText(textFile);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TextDto> getById(@PathVariable long id) {
        return new ResponseEntity<>(textService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<SuccessDto> delete (@PathVariable long id) {
        textService.deleteById(id);
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }
}
