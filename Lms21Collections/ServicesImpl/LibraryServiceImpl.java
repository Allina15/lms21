package Lms21Collections.ServicesImpl;

import Lms21Collections.Models.DataBase;
import Lms21Collections.Models.Library;
import Lms21Collections.Services.LibraryServices;

import java.util.List;

public class LibraryServiceImpl implements LibraryServices {
    private DataBase dataBase;
    public LibraryServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    public DataBase getDataBase() {
        return dataBase;
    }
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        dataBase.getLibraries().addAll(libraries);
        return dataBase.getLibraries();
    }
    @Override
    public List<Library> getAllLibraries() {
        return dataBase.getLibraries();
    }
    @Override
    public Library getLibraryById(Long id) {
        for (Library l:dataBase.getLibraries()) {
            if (l.getId()==id){
                return l;
            }
        }
        return null;
    }
    @Override
    public Library updateLibrary(Long id, Library library) {
        for (Library library1: dataBase.getLibraries()){
            if (library1.getId()==id){
                library1.setId(library.getId());
                library1.setBooks(library.getBooks());
                library1.setName(library.getName());
                library1.setReaders(library.getReaders());
                library1.setAddress(library.getAddress());
            }

        }
        return library;
    }
    @Override
    public String deleteLibrary(Long id) {
        for (Library l: dataBase.getLibraries()) {
           if (l.getId()==id){
               dataBase.getLibraries().remove(l);
           }
        }
        return "Library was deleted";
    }
}
