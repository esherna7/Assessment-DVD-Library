package com.esai.dvdlibrary.dao;

import com.esai.dvdlibrary.dto.DVD;
import java.util.*;

/**
 *
 * @author Esai
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{

    public static final String DVD_LIBRARY = "dvdLibrary.txt";
    public static final String DELIMITER = "::";
    
    private ArrayList<DVD> dvdLibrary = new ArrayList<DVD>();
    
    @Override
    public DVD addDVD(DVD newDVD) {
        dvdLibrary.add(newDVD);
        return newDVD;
    }

    @Override
    public DVD removeDVD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD editDVD(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DVD> getAllDVDs() {
        return dvdLibrary;
    }

    @Override
    public DVD getDVDInfo(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD getDVDInfoByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private DVD unmarshallDVD(String dvd){
        // split DVD info from file to array via :: delimiter
        String[] dvdTokens = dvd.split(DELIMITER);
        
        // create new DVD with info from dvdTokens
        DVD dvdFromFile = new DVD();
        dvdFromFile.setTitle(dvdTokens[0]);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        dvdFromFile.setDirectorsName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserNote(dvdTokens[5]);
        
        // return created dvd
        return dvdFromFile;
    }
}
