package pl.gda.jp.rdl.elementsbooks.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
@Builder
@Getter
@Setter
public class Book implements Comparable<Book>, Serializable {
    @Id
    private UUID id;
    @Column(name="nazwa")
    private String nazwa;
    @Column(name="rok_wydania")
    private int rok_wydania;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ksiegarnia", nullable = false)
    private Bookshop ksiegarnia;

    @Override
    public String toString() {
        return "Character{nazwa='" + nazwa + "', rok wydania=" + rok_wydania + "ksiegarnia" + ksiegarnia.getNazwa()+"}";
    }
    @Override 
    public int compareTo(Book o){
        return this.nazwa.compareTo(o.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, rok_wydania, ksiegarnia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return rok_wydania == that.rok_wydania && Objects.equals(nazwa, that.nazwa) && Objects.equals(ksiegarnia, that.ksiegarnia);
    }
}
