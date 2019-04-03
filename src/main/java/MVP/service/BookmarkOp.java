package MVP.service;

import MVP.model.Bookmarks;

import java.util.List;

public interface BookmarkOp {
    public List<Bookmarks> findIndividualBookmark(int id);
}
