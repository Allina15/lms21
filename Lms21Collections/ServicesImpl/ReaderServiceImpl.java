package Lms21Collections.ServicesImpl;

import Lms21Collections.Models.DataBase;
import Lms21Collections.Models.Library;
import Lms21Collections.Models.Reader;
import Lms21Collections.Services.ReaderServices;

import java.util.List;

public class ReaderServiceImpl implements ReaderServices {
    private DataBase dataBase;
    public ReaderServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    public DataBase getDataBase() {
        return dataBase;
    }
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void saveReader(Reader reader) {
     dataBase.getReaders().add(reader);
        System.out.println("Reader is saved");
    }
    @Override
    public List<Reader> getAllReaders() {
        return dataBase.getReaders();
    }
    @Override
    public Reader getReaderById(Long id) {
        for (Reader r: dataBase.getReaders()) {
            if (r.getId()==id){
                return r;
            }
        }
        return null;
    }
    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader r : dataBase.getReaders()) {
            if (r.getId()==id){
                r.setFullName(reader.getFullName());
                r.setGender(reader.getGender());
                r.setEmail(reader.getEmail());
                r.setPhoneNumber(reader.getPhoneNumber());
            }
        }
        return reader;
    }
    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Reader r : dataBase.getReaders()) {
            if (r.getId()==readerId){
                for (Library l : dataBase.getLibraries()) {
                    if (l.getId()==libraryId){
                        l.getReaders().add(r);
                    }
                }
            }
        }
        System.out.println("Читатель перемещен");
    }
}
