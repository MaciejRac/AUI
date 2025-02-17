package pl.gda.jp.rdl.elementsbooks.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.gda.jp.rdl.elementsbooks.dto.BookCollectionDTO;
import pl.gda.jp.rdl.elementsbooks.dto.BookCreationDTO;
import pl.gda.jp.rdl.elementsbooks.dto.BookDTO;
import pl.gda.jp.rdl.elementsbooks.entity.Book;
import pl.gda.jp.rdl.elementsbooks.entity.Bookshop;
import pl.gda.jp.rdl.elementsbooks.repository.BookRepository;
import pl.gda.jp.rdl.elementsbooks.repository.BookshopRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookshopRepository bookshopRepository;
    @Autowired
    public BookService(BookRepository bookRepository,BookshopRepository bookshopRepository) {
        this.bookRepository = bookRepository;
        this.bookshopRepository=bookshopRepository;
    }

    private BookDTO convertToDto(Book book) {
        return BookDTO.builder()
            .nazwa(book.getNazwa())
            .rok_wydania(book.getRok_wydania())
            .ksiegarnia(book.getKsiegarnia().getNazwa())
            .build();
    }

    private BookCollectionDTO convertToCollectionDto(Book book) {
        return new BookCollectionDTO(book.getId(), book.getNazwa(),book.getKsiegarnia().getNazwa());
    }

    public BookDTO createBook(BookCreationDTO bookCreationDTO) {
        Bookshop ksiegarnia = bookshopRepository.findById(bookCreationDTO.getBookshopId())
            .orElseThrow(() -> new IllegalArgumentException("Bookshop not found"));
        Book book = Book.builder()
            .id(UUID.randomUUID())
            .nazwa(bookCreationDTO.getNazwa())
            .rok_wydania(bookCreationDTO.getRok_wydania())
            .ksiegarnia(ksiegarnia)
            .build();

        Book savedBook = bookRepository.save(book);
        return convertToDto(savedBook);
    }

    public BookDTO updateBook(UUID id, BookCreationDTO bookCreationDTO) {
        Bookshop ksiegarnia = bookshopRepository.findById(bookCreationDTO.getBookshopId())
            .orElseThrow(() -> new IllegalArgumentException("Bookshop not found"));

        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        book.setNazwa(bookCreationDTO.getNazwa());
        book.setRok_wydania(bookCreationDTO.getRok_wydania());
        book.setKsiegarnia(ksiegarnia);

        Book updatedBook = bookRepository.save(book);
        return convertToDto(updatedBook);
    }

    public List<BookCollectionDTO> findAllBooks() {
        return bookRepository.findAll().stream()
            .map(this::convertToCollectionDto)
            .collect(Collectors.toList());
    }

    public List<BookCollectionDTO> findBooksByBookshop(UUID bookshopId) {
        return bookRepository.findByKsiegarniaId(bookshopId).stream()
            .map(this::convertToCollectionDto)
            .collect(Collectors.toList());
    }
    
    public boolean deleteBook(UUID id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> findByKsiegarnia(Bookshop ksiegarnia) {
        return bookRepository.findByKsiegarnia(ksiegarnia);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }
}
