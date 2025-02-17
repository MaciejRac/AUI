package pl.gda.jp.rdl.elementsbooks.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.gda.jp.rdl.elementsbooks.dto.BookshopDTO;
import pl.gda.jp.rdl.elementsbooks.entity.Bookshop;
import pl.gda.jp.rdl.elementsbooks.repository.BookshopRepository;

@Service
public class BookshopService {

    private final BookshopRepository bookshopRepository;

    @Autowired
    public BookshopService(BookshopRepository bookshopRepository) {
        this.bookshopRepository = bookshopRepository;
    }

    private BookshopDTO convertToDto(Bookshop bookshop) {
        return BookshopDTO.builder()
            .nazwa(bookshop.getNazwa())
            .build();
    }

    public BookshopDTO createBookshop(BookshopDTO bookshopDTO) {
        Bookshop bookshop = Bookshop.builder()
            .id(bookshopDTO.getId())
            .nazwa(bookshopDTO.getNazwa())
            .build();

        Bookshop savedBookshop = bookshopRepository.save(bookshop);
        return convertToDto(savedBookshop);
    }

    public BookshopDTO updateBookshop(UUID id, BookshopDTO bookshopDTO) {
        Bookshop bookshop = bookshopRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Bookshop not found"));

        bookshop.setNazwa(bookshopDTO.getNazwa());

        Bookshop updatedBookshop = bookshopRepository.save(bookshop);
        return convertToDto(updatedBookshop);
    }

    public boolean deleteBookshop(UUID id) {
        if (bookshopRepository.existsById(id)) {
            bookshopRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Bookshop getBookshop(UUID id) {
        return bookshopRepository.findById(id).orElse(null);
    }

    public Bookshop saveBookshop(Bookshop bookshop) {
        return bookshopRepository.save(bookshop);
    }
}

