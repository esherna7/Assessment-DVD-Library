package com.esai.dvdlibrary.dao;

import java.util.*;
import com.esai.dvdlibrary.dto.DVD;

/**
 *
 * @author Esai
 */
public interface DVDLibraryDao {

    DVD addDVD(DVD newDVD);
    
    DVD removeDVD();
    
    DVD editDVD(String title);
    
    ArrayList<DVD> getAllDVDs();
    
    DVD getDVDInfo(String title);
    
    DVD getDVDInfoByTitle(String title);
}
