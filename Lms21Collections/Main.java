package Lms21Collections;

import Lms21Collections.Enums.Gender;
import Lms21Collections.Enums.Genre;
import Lms21Collections.Models.Book;
import Lms21Collections.Models.DataBase;
import Lms21Collections.Models.Library;
import Lms21Collections.Models.Reader;
import Lms21Collections.ServicesImpl.BookServicesImpl;
import Lms21Collections.ServicesImpl.LibraryServiceImpl;
import Lms21Collections.ServicesImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", Genre.FANTASY);
        Book book2 = new Book("War and Peace", "Leo Tolstoy", Genre.HISTORICAL);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", Genre.ROMANCE);
        Book book4 = new Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE);
        Book book5 = new Book("Good Omens", "Terry Pratchett & Neil Gaiman", Genre.HUMOR);
        List<Book>books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);
        List<Book>books2 = new ArrayList<>();
        books2.add(book3);
        books2.add(book4);
        List<Book>books = new ArrayList<>();
        books.addAll(books1);
        books.addAll(books2);

        Reader person1 = new Reader("John Doe", "john@example.com", 1234567890L, Gender.MALE);
        Reader person2 = new Reader("Jane Smith", "jane@example.com", 9876543210L, Gender.FEMALE);
        Reader person3 = new Reader("Alex Johnson", "alex@example.com", 5555555555L, Gender.MALE);
        Reader person4 = new Reader("Emily Brown", "emily@example.com", 1111111111L, Gender.FEMALE);
        Reader person5 = new Reader("Michael Lee", "michael@example.com", 9998887777L, Gender.MALE);
        Reader person6 = new Reader("Alina Akhunova","Alina@Example.com",123564789L,Gender.FEMALE);
        List<Reader>readers1 = new ArrayList<>();
        readers1.add(person1);
        readers1.add(person2);
        List<Reader>readers2 = new ArrayList<>();
        readers2.add(person3);
        readers2.add(person4);
        List<Reader>readers = new ArrayList<>();
        readers.addAll(readers1);
        readers.addAll(readers2);

        Library library1 = new Library("K.Bayalinov","Chui 120",books1,readers1);
        Library library2 = new Library("A.Osmonov","Zh.Abdrahmanov 89",books2,readers2);
        Library library = new Library("LibraryName","Address",books1,readers1);
        Library library3 = new Library("SomeLibrary","SomeAddress",null,null);
        List<Library>libraries = new ArrayList<>();
        libraries.add(library1);
        libraries.add(library2);
        List<Library>libraries1 = new ArrayList<>();
        libraries1.add(library);

        DataBase dataBase = new DataBase(libraries,books,readers);
        BookServicesImpl b = new BookServicesImpl(dataBase);
        LibraryServiceImpl l = new LibraryServiceImpl(dataBase);
        ReaderServiceImpl r = new ReaderServiceImpl(dataBase);

        System.out.println("1 Methods with readers");
        System.out.println("2 Methods with books");
        System.out.println("3 Methods with libraries");
        Scanner scanner=new Scanner(System.in);
        int a= scanner.nextInt();
        while(true) {
            switch (a) {
                case 1:
                    System.out.println("1 Save Reader");
                    System.out.println("2 Get all readers");
                    System.out.println("3 Get reader by id");
                    System.out.println("4 Update reader");
                    System.out.println("5 Assign reader to library");
                    int a2 = scanner.nextInt();
                    switch (a2) {
                        case 1:
                            System.out.println("First choice");
                            r.saveReader(person5);
                            break;
                        case 2:
                            System.out.println("Second choice");
                            System.out.println(r.getAllReaders());
                            break;
                        case 3:
                            System.out.println("Third choice");
                            System.out.println("Enter id of reader that you want to get");
                            Long idToGetReader = scanner.nextLong();
                            System.out.println(r.getReaderById(idToGetReader));
                            break;
                        case 4:
                            System.out.println("Fourth choice");
                            System.out.println("Enter id of reader that you want to update");
                            Long idToUpdate = scanner.nextLong();
                            r.updateReader(idToUpdate, person6);
                            break;
                        case 5:
                            System.out.println("Fifth choice");
                            System.out.println("Enter id of reader to assign");
                            long IdOfReaderToAssign=scanner.nextLong();
                            System.out.println("Enter id of library ");
                            long IdOfLibraryToAssign=scanner.nextLong();
                            r.assignReaderToLibrary(IdOfReaderToAssign,IdOfLibraryToAssign);
                    }
                    break;
                case 2:
                    System.out.println("1 Save Book");
                    System.out.println("2 Get all books");
                    System.out.println("3 Get book by id");
                    System.out.println("4 Delete book");
                    System.out.println("5 Clear books by id");
                    int c = scanner.nextInt();
                    switch (c) {
                        case 1:
                            System.out.println("First choice");
                            System.out.println("Enter id of library to save");
                            Long idToSave=scanner.nextLong();
                            System.out.println(b.saveBook(idToSave, book5));
                            break;
                        case 2:
                            System.out.println("Second choice");
                            System.out.println("Enter id of library to get");
                            Long idToDelete=scanner.nextLong();
                            System.out.println(b.getAllBooks(idToDelete));
                            break;
                        case 3:
                            System.out.println("Third choice");
                            System.out.println("Enter id of library to find");
                            Long idOfLibraryToFind=scanner.nextLong();
                            System.out.println("Enter id of book to find");
                            Long idOfBookToFind=scanner.nextLong();
                            System.out.println(b.getBookById(idOfLibraryToFind, idOfBookToFind));
                            break;
                        case 4:
                            System.out.println("Fourth choice");
                            System.out.println("Enter id of library to delete");
                            Long idOfLibraryToDelete=scanner.nextLong();
                            System.out.println("Enter id of book to delete");
                            Long idOfBookToDelete=scanner.nextLong();
                            System.out.println(b.deleteBook(idOfLibraryToDelete, idOfBookToDelete));
                            break;
                        case 5:
                            System.out.println("Fifth choice");
                            System.out.println("Enter id of library to clear books");
                            Long idOfLibraryToClear=scanner.nextLong();
                            b.clearBooksByLibraryId(idOfLibraryToClear);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1 Save library");
                    System.out.println("2 Get all libraries");
                    System.out.println("3 Get library by id");
                    System.out.println("4 Update library");
                    System.out.println("5 Delete library");
                    int x = scanner.nextInt();
                    switch (x) {
                        case 1:
                            System.out.println("First choice");
                            System.out.println(l.saveLibrary(libraries1));
                            break;
                        case 2:
                            System.out.println("Second choice");
                            System.out.println(l.getAllLibraries());
                            break;
                        case 3:
                            System.out.println("Third choice");
                            System.out.println("Enter id of library to get");
                            long idOfLibraryToGet=scanner.nextLong();
                            System.out.println(l.getLibraryById(idOfLibraryToGet));
                            break;
                        case 4:
                            System.out.println("Fourth choice");
                            System.out.println("Enter id of library to update");
                            long idOfLibraryToUpdate=scanner.nextLong();
                            System.out.println(l.updateLibrary(idOfLibraryToUpdate, library3));
                            break;
                        case 5:
                            System.out.println("Fifth choice");
                            System.out.println("Enter id of library to delete");
                            long idOfLibraryToDelete=scanner.nextLong();
                            System.out.println(l.deleteLibrary(idOfLibraryToDelete));
                            break;
                    }
                    break;

            }
        }
    }
}
