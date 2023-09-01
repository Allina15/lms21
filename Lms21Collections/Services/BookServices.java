package Lms21Collections.Services;

import Lms21Collections.Models.Book;

import java.util.List;

public interface BookServices {
    Book saveBook(Long libraryId,Book book);

    List<Book> getAllBooks(Long libraryId);

    Book getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId,Long bookId);

    void clearBooksByLibraryId(Long libraryId);
}
