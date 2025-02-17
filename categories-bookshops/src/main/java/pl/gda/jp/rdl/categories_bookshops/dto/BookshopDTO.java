package pl.gda.jp.rdl.categories_bookshops.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookshopDTO {
    private UUID id;
    private String nazwa;
    private int liczbaPracownikow;
}
