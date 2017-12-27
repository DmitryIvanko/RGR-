import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.sun.istack.internal.NotNull;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private short recommendedAge;
    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();
    public Genre() {
    }
    public Genre(String name, short recommendedAge) {
        this.name = name;
        this.recommendedAge = recommendedAge;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public short getRecommendedAge() {
        return recommendedAge;
    }
    public void setRecommendedAge(short recommendedAge) {
        this.recommendedAge = recommendedAge;
    }
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
