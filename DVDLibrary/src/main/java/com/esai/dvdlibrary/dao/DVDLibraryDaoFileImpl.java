package com.esai.dvdlibrary.dao;

import com.esai.dvdlibrary.dto.DVD;
import java.util.*;
import java.io.*;

/**
 *
 * @author Esai
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    // holds file
    public static final String DVD_LIBRARY = "dvdLibrary.txt";
    public static final String DELIMITER = "::"; // Delimiter

    // Arraylist holds dvds in library
    private ArrayList<DVD> dvdLibrary = new ArrayList<DVD>();

    // add newly created DVD to dvdLibrary
    @Override
    public DVD addDVD(DVD newDVD) throws ClassDVDDaoException {
        // reset dvdlibrary
        dvdLibrary = new ArrayList<DVD>();
        // load dvds from file into arraylist
        loadDVD();
        // add new dvd to arraylist library
        dvdLibrary.add(newDVD);
        // load new library to file
        writeDVD();
        return newDVD;
    }

    // remove DVD from library based on title and release date
    // to handle multiple same titles
    @Override
    public boolean removeDVD(DVD dvdToRemove) throws ClassDVDDaoException {
        // reset dvdlibrary
        dvdLibrary = new ArrayList<DVD>();
        // go through dvdLibrary to find dvd to remove
        loadDVD();
        for (int x = 0; x < dvdLibrary.size(); x++) {
            if (dvdLibrary.get(x).getTitle().equals(dvdToRemove.getTitle())) {
                if (dvdLibrary.get(x).getReleaseDate().equals(dvdToRemove.getReleaseDate())) {
                    dvdLibrary.remove(x);
                    writeDVD();
                    return true;
                }
            }
        }
        return false;
    }

    // Edit DVD info in library with new user data
    @Override
    public void editDVD(DVD dvdToEdit, DVD newDVD) throws ClassDVDDaoException {
        // Find DVD in library to be edited and change to newEditedDVD
        dvdLibrary = new ArrayList<DVD>();
        loadDVD();
        for (int x = 0; x < dvdLibrary.size(); x++) {
            if (dvdLibrary.get(x).getTitle().equals(dvdToEdit.getTitle())) {
                if (dvdLibrary.get(x).getReleaseDate().equals(dvdToEdit.getReleaseDate())) {
                    dvdLibrary.set(x, newDVD);
                    writeDVD();
                    break;
                }
            }
        }
    }

    // return arraylist containing all current DVD's
    @Override
    public ArrayList<DVD> getAllDVDs() throws ClassDVDDaoException {
        dvdLibrary = new ArrayList<DVD>();
        loadDVD();
        return dvdLibrary;
    }

    // return list of DVD searched for by Title in case of mulitple same titles
    @Override
    public ArrayList<DVD> getDVDInfoByTitle(String title) {
        ArrayList<DVD> dvdByTitle = new ArrayList<DVD>();

        // add all dvds with searched for title to dvdByTitle list to return
        for (int x = 0; x < dvdLibrary.size(); x++) {
            if (dvdLibrary.get(x).getTitle().equals(title)) {
                dvdByTitle.add(dvdLibrary.get(x));
            }
        }
        return dvdByTitle;
    }

    // return DVD searched for by Title and release date
    @Override
    public DVD getDVDInfoByTitleAndReleaseDate(String title, String releaseDate) {

        // search and return DVD with searched for title and release date
        for (int x = 0; x < dvdLibrary.size(); x++) {
            if (dvdLibrary.get(x).getTitle().equals(title)) {
                if (dvdLibrary.get(x).getReleaseDate().equals(releaseDate)) {
                    return dvdLibrary.get(x);
                }
            }
        }
        return null;
    }

    // check if dvd user wants to edit exists in library
    // return true or false
    @Override
    public boolean checkDVDInLibraryToEdit(DVD dvdToEdit) {
        // go through dvdLibrary to find dvd to edit
        for (int x = 0; x < dvdLibrary.size(); x++) {
            if (dvdLibrary.get(x).getTitle().equals(dvdToEdit.getTitle())) {
                if (dvdLibrary.get(x).getReleaseDate().equals(dvdToEdit.getReleaseDate())) {
                    return true;
                }
            }
        }
        return false;
    }

    // translate object in file to a DVD object
    // splits on delimiter ::
    private DVD unmarshallDVD(String dvd) {
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

    // reads dvdLibrary into memory
    private void loadDVD() throws ClassDVDDaoException {
        Scanner scanner;

        // try catch block to throw error if file not found
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY)));
        } catch (FileNotFoundException e) {
            throw new ClassDVDDaoException("Could not load DVD Library into memory.", e);
        }

        String currentLine;
        DVD currentDVD;

        // Go line by line in dvdLibrary.txt and unmarshall line into DVD
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvdLibrary.add(currentDVD);
        }
        //close scanner
        scanner.close();
    }

    // transform DVD information in memory to line of text to be written
    private String marshallDVD(DVD dvd) {
        String dvdText = dvd.getTitle() + DELIMITER;
        dvdText += dvd.getReleaseDate() + DELIMITER;
        dvdText += dvd.getMpaaRating() + DELIMITER;
        dvdText += dvd.getDirectorsName() + DELIMITER;
        dvdText += dvd.getStudio() + DELIMITER;
        dvdText += dvd.getUserNote() + DELIMITER;

        return dvdText;
    }

    // write current arraylist dvd library to DVD_LIBRARY file
    private void writeDVD() throws ClassDVDDaoException {
        PrintWriter out;

        // try catch block throws error if file isnt found
        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY));
        } catch (IOException e) {
            throw new ClassDVDDaoException("Could not save DVD data.", e);
        }

        String dvdText;
        // transform DVD info to text
        for (DVD currentDVD : dvdLibrary) {
            dvdText = marshallDVD(currentDVD);
            // write text to file
            out.println(dvdText);
            out.flush();
        }
        // close PrintWriter
        out.close();
    }
}
