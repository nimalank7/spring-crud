package MVP.controller;

import MVP.model.Bookmarks;
import MVP.repository.BookmarksRepository;
import MVP.service.BookmarkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final BookmarksRepository bookmarksRepository;

    @Autowired
    public HomeController(BookmarksRepository bookmarksRepository) {

        this.bookmarksRepository = bookmarksRepository;

    }

    @Autowired
    BookmarkServices bookmarkServices;

    @GetMapping("/allbookmarks")
    public String showall(Model model) {
        Iterable<Bookmarks> bookmarks = bookmarksRepository.findAll();
        model.addAttribute("bookmarks", bookmarks);
        return "bookmarks";
    }

    @GetMapping("/create_bookmark")
    public String form(Model model) {
        System.out.println(bookmarkServices.findIndividualBookmark(58).get(0).gettitle());
        Bookmarks bookmark = new Bookmarks();
        model.addAttribute("bookmark", bookmark);
        return "create_bookmark";
    }

    @PostMapping("/create_bookmark")
    public String createbookmark(Bookmarks bookmark){
        bookmarksRepository.save(bookmark);
        return "redirect:/allbookmarks";
    }

    @DeleteMapping("/bookmark/{id}/delete")
    public String deleteBookmark(@PathVariable int id){
        Bookmarks bookmark = bookmarksRepository.findById(id).get();
        bookmarksRepository.delete(bookmark);
        return "redirect:/allbookmarks";
    }

    @GetMapping("/bookmark/update/{id}")
    public String updateform(@PathVariable int id, Model model) {
        Bookmarks bookmark = new Bookmarks();
        model.addAttribute("bookmark", bookmark);
        model.addAttribute("bookmark_id", id);
        return "update_bookmark";
    }

    @PatchMapping("/bookmark/update/{id}")
    public String updateBookmark(@PathVariable int id, Bookmarks new_bookmark){
        Bookmarks update_bookmark = bookmarksRepository.findById(id).get();
        update_bookmark.settitle(new_bookmark.gettitle());
        update_bookmark.seturl(new_bookmark.geturl());
        bookmarksRepository.save(update_bookmark);
        return "redirect:/allbookmarks";
        // Is there a better way of doing updating?
    }
}
