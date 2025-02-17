package pl.gda.jp.rdl.categories_bookshops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.gda.jp.rdl.categories_bookshops.entity.Bookshop;

@Repository
public interface BookshopRepository extends JpaRepository<Bookshop, UUID>{
    Bookshop findByNazwaAndLiczbaPracownikow(String nazwa,int liczbaPracownikow);
}
