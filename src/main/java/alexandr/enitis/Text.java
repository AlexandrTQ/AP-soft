package alexandr.enitis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Getter
public class Text {
    private @Id @GeneratedValue(strategy = AUTO) Long text_id;
    private String[] text;

    public Text(String structure, String[] text) {
        this.text = text;
    }
    public Text() {}
}
