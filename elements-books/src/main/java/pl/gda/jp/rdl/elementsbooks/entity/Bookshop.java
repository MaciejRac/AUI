package pl.gda.jp.rdl.elementsbooks.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name="bookshops")
@Getter
@Setter
public class Bookshop {
    @Id
    private UUID id;
    @Column(name="nazwa")
    private String nazwa;

    @OneToMany(mappedBy = "ksiegarnia", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    List<Book> ksiazki;
}
