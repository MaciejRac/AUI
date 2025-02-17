package pl.gda.jp.rdl.categories_bookshops.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.gda.jp.rdl.categories_bookshops.dto.BookshopDTO;


@Slf4j
@Service
@AllArgsConstructor
public class BookService {

    private final String bookServiceUrl = "http://localhost:8081";

    private final RestTemplate restTemplate;

    public void deleteBookshop(UUID bookshopId) {
        try {
            restTemplate.delete(bookServiceUrl + "/api/books/bookshops/" + bookshopId);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void addBookshop(BookshopDTO bookshopDTO) {//UUID bookshopId
        try {
            if (bookshopDTO == null ) {
                throw new IllegalArgumentException("BookshopDTO is invalid");
            }
            if ( bookshopDTO.getNazwa() == null) {
                throw new IllegalArgumentException("BookshopDTO NAME is invalid");
            }
            if ( bookshopDTO.getId() == null ) {
                throw new IllegalArgumentException("BookshopDTO ID is invalid");
            }
            
            restTemplate.postForLocation(bookServiceUrl + "/api/books/bookshops",bookshopDTO);//bookshopID
        } catch (Exception e) {
            log.error("Error during POST request to book service", e);
            throw new RuntimeException("Failed to notify book service", e);
        }
    }
    public void updateBookshop(UUID bookshopID, BookshopDTO bookshopDTO){
        try {
            if (bookshopDTO == null ) {
                throw new IllegalArgumentException("BookshopDTO is invalid");
            }
            if ( bookshopDTO.getNazwa() == null) {
                throw new IllegalArgumentException("BookshopDTO NAME is invalid");
            }
            if ( bookshopDTO.getId() == null ) {
                throw new IllegalArgumentException("BookshopDTO ID is invalid");
            }
            restTemplate.put(bookServiceUrl+"/api/books/bookshops/"+ bookshopID, bookshopDTO);
        } catch (Exception e) {
            log.error("Error during PUT request to book service", e);
            throw new RuntimeException("Failed to notify book service", e);
        }
    }
 
}
