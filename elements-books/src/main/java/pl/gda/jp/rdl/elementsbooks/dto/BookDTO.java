package pl.gda.jp.rdl.elementsbooks.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {
    private UUID id;
    private String nazwa;
    private int rok_wydania;
    private String ksiegarnia;

    @Override
    public String toString() {
        return "Book{nazwa='" + nazwa + "', rok wydania=" + rok_wydania + ", ksiegarnia='" + ksiegarnia + "'}";
    }
}