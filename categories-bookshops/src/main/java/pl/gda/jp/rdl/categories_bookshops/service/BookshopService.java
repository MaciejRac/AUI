package pl.gda.jp.rdl.categories_bookshops.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pl.gda.jp.rdl.categories_bookshops.dto.BookshopCollectionDTO;
import pl.gda.jp.rdl.categories_bookshops.dto.BookshopCreationDTO;
import pl.gda.jp.rdl.categories_bookshops.dto.BookshopDTO;
import pl.gda.jp.rdl.categories_bookshops.entity.Bookshop;
import pl.gda.jp.rdl.categories_bookshops.repository.BookshopRepository;

@Service
public class BookshopService {

    private final BookshopRepository bookshopRepository;

    @Autowired
    public BookshopService(BookshopRepository bookshopRepository) {
        this.bookshopRepository = bookshopRepository;
    }

    private BookshopCollectionDTO convertToCollectionDto(Bookshop bookshop) {
        return new BookshopCollectionDTO(bookshop.getId(), bookshop.getNazwa());
    }

    private BookshopDTO convertToDTOfromCollection(BookshopCollectionDTO bookshopCollection) {
        Bookshop bookshop=bookshopRepository.findById(bookshopCollection.getId())
            .orElseThrow(()->new EntityNotFoundException("Bookshop not found for ID: "+bookshopCollection.getId()));
            //.orElseThrow(() -> new EntityNotFoundException("Bookshop not found for ID: " + bookshopCollection.getId()));
        return new BookshopDTO(bookshop.getId(), bookshop.getNazwa(),bookshop.getLiczbaPracownikow());
    }

    private BookshopDTO convertToDto(Bookshop bookshop) {
        return BookshopDTO.builder()
            .nazwa(bookshop.getNazwa())
            .liczbaPracownikow(bookshop.getLiczbaPracownikow())
            .id(bookshop.getId())
            .build();
    }

    public BookshopDTO createBookshop(BookshopCreationDTO bookshopCreationDTO) {
        Bookshop bookshop = Bookshop.builder()
            .id(UUID.randomUUID())
            .nazwa(bookshopCreationDTO.getNazwa())
            .liczbaPracownikow(bookshopCreationDTO.getLiczbaPracownikow())
            .build();

        Bookshop savedBookshop = bookshopRepository.save(bookshop);
        return convertToDto(savedBookshop);
    }

    public BookshopDTO updateBookshop(UUID id, BookshopCreationDTO bookCreationDTO) {
        Bookshop bookshop = bookshopRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Bookshop not found"));

        bookshop.setNazwa(bookCreationDTO.getNazwa());
        bookshop.setLiczbaPracownikow(bookCreationDTO.getLiczbaPracownikow());

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

    public List<BookshopCollectionDTO> findAllBookshops() {
        return bookshopRepository.findAll().stream()
            .map(this::convertToCollectionDto)
            .collect(Collectors.toList());
    }

    public Bookshop findBookshopById(UUID id) {
        return bookshopRepository.findById(id).orElse(null);
    }
}