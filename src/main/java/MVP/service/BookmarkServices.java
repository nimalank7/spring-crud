package MVP.service;

import MVP.model.Bookmarks;
import MVP.repository.BookmarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServices implements BookmarkOp {
    @Autowired
    BookmarksRepository bookmarksRepository;

    public List<Bookmarks> findIndividualBookmark(int id) {
        return bookmarksRepository.findbookmark(id);
    }
}
