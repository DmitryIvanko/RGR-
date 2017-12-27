import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    @Query(value = "SELECT * FROM `genre` ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Genre> findFiveByRandom();
    Genre findById(Long id);
    Genre findByName(String name);
}
