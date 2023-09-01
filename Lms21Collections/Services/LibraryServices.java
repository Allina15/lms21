package Lms21Collections.Services;

import Lms21Collections.Models.Library;

import java.util.List;

public interface LibraryServices {
    List<Library>saveLibrary(List<Library> libraries);

    List<Library>getAllLibraries();

    Library getLibraryById(Long id);

    Library updateLibrary(Long id, Library library);

    String deleteLibrary(Long id);
}
