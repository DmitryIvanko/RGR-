@Service
public class AuthorService {
    private static final int PER_PAGE = 5;
    @Autowired
    AuthorRepository authorRepository;
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        for (Author author :
                authorRepository.findAll()) {
            authors.add(author);
        }
        return authors;
    }
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }
    public List<Author> findThreeByRandom() {
        return authorRepository.findThreeByRandom();
    }
    public Page<Author> findAllOrderByNameAsc(Integer page) {
        return authorRepository.findAll(new PageRequest(page, PER_PAGE, Sort.Direction.ASC, "name"));
    }
    public Page<Author> findPageByNameContaining(String name, Integer page) {
        Pageable pageable = new PageRequest(page, PER_PAGE, Sort.Direction.ASC, "name");
        return authorRepository.findByNameContaining(name, pageable);
    }
}
