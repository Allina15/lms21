package Lms21Collections.ServicesImpl;

import Lms21Collections.Models.Book;
import Lms21Collections.Models.DataBase;
import Lms21Collections.Models.Library;
import Lms21Collections.Services.BookServices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookServicesImpl implements BookServices {
    private DataBase dataBase;
    public BookServicesImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    public DataBase getDataBase() {
        return dataBase;
    }
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public Book saveBook(Long libraryId, Book book) {
        ArrayList<Library> arr1 = (ArrayList<Library>) dataBase.getLibraries();
        for (Library arr:arr1) {
            if (arr.getId() == libraryId && !arr.getBooks().contains(book)) {
                arr.getBooks().add(book);
                dataBase.getBooks().add(book);
            }
        }
        return book;
    }
    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library l : dataBase.getLibraries()) {
            if (l.getId() == libraryId) {
                return l.getBooks();
            }
        }
        return null;
    }
    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library l : dataBase.getLibraries()) {
            if (l.getId() == libraryId) {
                for (Book b : dataBase.getBooks()) {
                    if (b.getId() == bookId) {
                        return b;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library l : dataBase.getLibraries()) {
            if (l.getId() == libraryId) {
                for (Book b : dataBase.getBooks()) {
                    if (b.getId() == bookId) {
                        l.getBooks().remove(b);
                        dataBase.getBooks().remove(b);
                        return "Book is deleted";
                    }
                }
            }
        }
        return null;
    }
    @Override
    public void clearBooksByLibraryId(Long libraryId){
        for (Library l : dataBase.getLibraries()) {
            if (l.getId() == libraryId) {
             l.getBooks().clear();
            }
        }
        System.out.println(dataBase.getLibraries());
    }
}
