package pl.gda.jp.rdl.categories_bookshops.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "bookshops")
@Setter
@Getter
public class Bookshop implements Comparable<Bookshop>, Serializable {
    @Id
    private UUID id;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    @Column(name = "liczba_pracownikow", nullable = false)
    private int liczbaPracownikow;

    @Override
    public int compareTo(Bookshop o) {
        return this.nazwa.compareTo(o.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nazwa, this.liczbaPracownikow);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookshop that = (Bookshop) o;
        return liczbaPracownikow == that.liczbaPracownikow && Objects.equals(nazwa, that.nazwa);
    }

    @Override
    public String toString() {
        return "ksiegarnia {nazwa='" + nazwa + "', liczba pracowników=" + liczbaPracownikow + "}";
    }
}
