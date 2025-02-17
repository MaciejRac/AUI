package pl.gda.jp.rdl.elementsbooks.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.gda.jp.rdl.elementsbooks.entity.Book;
import pl.gda.jp.rdl.elementsbooks.entity.Bookshop;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByKsiegarnia(Bookshop ksiegarnia);
    List<Book> findByKsiegarniaId(UUID bookshopId);
}
