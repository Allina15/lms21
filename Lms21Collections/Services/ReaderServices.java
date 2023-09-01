package Lms21Collections.Services;

import Lms21Collections.Models.Reader;

import java.util.List;

public interface ReaderServices {
    void saveReader(Reader reader);

    List<Reader> getAllReaders();

    Reader getReaderById(Long id);

    Reader updateReader(Long id, Reader reader);

    void assignReaderToLibrary(Long readerId,Long libraryId);
}
