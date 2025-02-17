package pl.gda.jp.rdl.elementsbooks.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BookCreationDTO {
    private String nazwa;
    private int rok_wydania;
    private UUID bookshopId;
}