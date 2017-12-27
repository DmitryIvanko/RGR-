import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Query(value = "SELECT * FROM `book` ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Book> findThreeByRandom();
    Book findById(Long id);
}
