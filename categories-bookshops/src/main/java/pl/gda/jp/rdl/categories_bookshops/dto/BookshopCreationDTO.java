package pl.gda.jp.rdl.categories_bookshops.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookshopCreationDTO {
    private String nazwa;
    private int liczbaPracownikow;
}
