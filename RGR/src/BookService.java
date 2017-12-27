import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }
    public List<Book> findThreeByRandom() {
        return bookRepository.findThreeByRandom();
    }
    public Page<Book> findPageBySpecifications(List<Specification<Book>> specifications, Pageable pageable) {
        SpecificationsBuilder<Book> builder = new SpecificationsBuilder<>(specifications);
        return bookRepository.findAll(builder.buildBySpecsConjunction(), pageable);
    }
    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
