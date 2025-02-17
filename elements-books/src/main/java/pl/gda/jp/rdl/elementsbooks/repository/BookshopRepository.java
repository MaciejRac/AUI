package pl.gda.jp.rdl.elementsbooks.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.gda.jp.rdl.elementsbooks.entity.Bookshop;

@Repository
public interface BookshopRepository extends JpaRepository<Bookshop, UUID>{
   
}
