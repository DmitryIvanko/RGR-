import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    @Query(value = "SELECT * FROM `author` ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Author> findThreeByRandom();
    Author findById(Long id);
    Page<Author> findByNameContaining(String notFullName, Pageable pageable);
}
