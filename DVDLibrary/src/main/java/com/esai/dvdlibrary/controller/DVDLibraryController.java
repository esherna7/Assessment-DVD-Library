package com.esai.dvdlibrary.controller;

import com.esai.dvdlibrary.dao.ClassDVDDaoException;
import com.esai.dvdlibrary.dao.DVDLibraryDao;
import com.esai.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.esai.dvdlibrary.dto.DVD;
import com.esai.dvdlibrary.ui.DVDLibraryView;
// wont need userIO soon so delete everything later
import com.esai.dvdlibrary.ui.UserIO;
import com.esai.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.*;

/**
 *
 * @author Esai
 */
public class DVDLibraryController {

    private DVDLibraryView view = new DVDLibraryView();
    private DVDLibraryDao doa = new DVDLibraryDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                // do case based on selected option
                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDLibrary();
                        break;
                    case 5:
                        searchDVDByTitle();
                        break;
                    case 6:
                        searchDVDByTitleAndReleaseDate();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        io.print("Unknown Command");
                }
            }
        } catch (ClassDVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

        io.print("Goodbye");
    }

    // calls View to print out Menu and read user input selection
    // returns the users input to determine menu selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    // create a new DVD to add to arraylist library
    private void createDVD() throws ClassDVDDaoException {
        DVD newDVD = view.getDVDInfoToAdd();
        doa.addDVD(newDVD);
        view.displayAddSuccessBanner();
    }

    // remove DVD from library based on title and release date
    private void removeDVD() throws ClassDVDDaoException {
        DVD dvdToRemove = view.getDVDToRemove();
        view.displayRemoveSuccessBanner(doa.removeDVD(dvdToRemove));
    }

    // edit DVD from library based on user input
    private void editDVD() throws ClassDVDDaoException {
        DVD dvdToEdit = view.getDVDToEdit();
        // if dvd to edit exists in library than replace with new user data
        if (doa.checkDVDInLibraryToEdit(dvdToEdit)) {
            // ask for new DVD info
            DVD newDVD = view.getDVDInfoToAdd();
            doa.editDVD(dvdToEdit, newDVD);
            view.displayEditSuccessBanner();
        } else {
            view.displayEditFailureBanner();
        }
    }

    // retrieves DVD library from DVDLibraryDaoFileImpl
    // and View displays all DVDs in library
    private void listDVDLibrary() {
        view.displayDVDListBanner();
        ArrayList<DVD> dvdList = doa.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    // Search for DVD in library by Title
    private void searchDVDByTitle() {
        DVD dvdToSearchFor = view.searchDVDByTitle();
        view.displayDVDList(doa.getDVDInfoByTitle(dvdToSearchFor.getTitle()));
    }

    // Search for DVD in library by Title and year
    private void searchDVDByTitleAndReleaseDate() {
        DVD dvdToSearchFor = view.askDVDToSearchFor();
        // if dvd searched for exists then print out info
        DVD searchedForDVD = doa.getDVDInfoByTitleAndReleaseDate(dvdToSearchFor.getTitle(), dvdToSearchFor.getReleaseDate());
        if (searchedForDVD != null) {
            view.displayDVDInfo(searchedForDVD);
        } //else display error
        else {
            view.displayDoesNotExistBanner();
        }
    }
}
