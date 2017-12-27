import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserDetailsService implements UserDetailsService {
    @Autowired
    AuthorService authorService;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Author author = authorService.findById(Long.parseLong(login));
        Set<GrantedAuthority> authorities = new HashSet();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new User(login, author.getName(), authorities);
    }
}
