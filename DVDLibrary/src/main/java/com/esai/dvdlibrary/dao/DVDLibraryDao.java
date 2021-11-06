package com.esai.dvdlibrary.dao;

import java.util.*;
import com.esai.dvdlibrary.dto.DVD;

/**
 *
 * @author Esai
 */
public interface DVDLibraryDao {

    DVD addDVD(DVD newDVD) throws ClassDVDDaoException;
    
    boolean removeDVD(DVD dvdToRemove) throws ClassDVDDaoException;
    
    void editDVD(DVD dvdToEdit, DVD newDVD) throws ClassDVDDaoException;
    
    ArrayList<DVD> getAllDVDs() throws ClassDVDDaoException;
    
    ArrayList<DVD> getDVDInfoByTitle(String title);
    
    DVD getDVDInfoByTitleAndReleaseDate(String title, String releaseDate);
    
    boolean checkDVDInLibraryToEdit(DVD dvdToEdit);
}
