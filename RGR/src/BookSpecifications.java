public final class BookSpecifications {
    private static final int PAGE_SIZE = 5;
    private BookSpecifications() {
    }
    public static Specification<Book> containsInName(String name) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(Book_.name), "%" + name + "%");
    }
    public static Specification<Book> containsInAuthorName(String name) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(Book_.author).get(Author_.name), "%" + name + "%");
    }
    public static Specification<Book> hasOneOfGenres(List<String> genres) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            //use to disable getting duplicates, when more then 1 book's genre is in genres list of criteria search
            criteriaQuery.distinct(true);
            SetJoin<Book, Genre> bookGenres = root.join(Book_.genres);
            return bookGenres.get(Genre_.name).in(genres);
        };
    }
    public static Specification<Book> ratioInBorders(Short l, Short r) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get(Book_.ratio), l, r);
    }
    public static Sort sortBy(String chosenField, boolean asc) {
        return new Sort((asc ? Sort.Direction.ASC : Sort.Direction.DESC), chosenField);
    }
    public static PageRequest paginate(Integer page, Sort sort) {
        return new PageRequest(page, PAGE_SIZE, sort);
    }
}
