package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.email like ?1%")
    List<Author> findAuthorsByEmailBeginningFrom(String text);

    @Query("select a from Author a where a.pesel like ?1%")
    List<Author> findAuthorsByPeselBeginningFrom(String text);

}
