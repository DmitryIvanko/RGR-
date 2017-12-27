import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;
    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        for (Genre genre :
                genreRepository.findAll()) {
            genres.add(genre);
        }
        return genres;
    }
    public Genre findById(Long id) {
        return genreRepository.findById(id);
    }
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
    public List<Genre> findFiveByRandom() {
        return genreRepository.findFiveByRandom();
    }
}
