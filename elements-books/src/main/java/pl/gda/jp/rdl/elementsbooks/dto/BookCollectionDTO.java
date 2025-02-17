package pl.gda.jp.rdl.elementsbooks.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.gda.jp.rdl.elementsbooks.entity.Bookshop;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCollectionDTO {
    private UUID id;
    private String nazwa;
    private String nazwaKsiegarni;
}
