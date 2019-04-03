package MVP.repository;

import MVP.model.Bookmarks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookmarksRepository extends CrudRepository<Bookmarks, Integer> {
    @Query(value = "SELECT * FROM bookmarks WHERE id=?1", nativeQuery = true)
    List<Bookmarks> findbookmark(int id);
}
