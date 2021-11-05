package com.esai.dvdlibrary.controller;

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
        while (keepGoing) {
            menuSelection = getMenuSelection();

            // do case based on selected option
            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    io.print("Remove DVD");
                    break;
                case 3:
                    io.print("Edit DVD Info");
                    break;
                case 4:
                    listDVDLibrary();
                    break;
                case 5:
                    io.print("Display DVD Info");
                    break;
                case 6:
                    io.print("Search DVD by Title");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("Unknown Command");
            }
        }
        
        io.print("Goodbye");
    }

    // calls View to print out Menu and read user input selection
    // returns the users input to determine menu selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    // create a new DVD to add to library
    // 
    private void createDVD(){
        DVD newDVD = view.getDVDInfo();
        doa.addDVD(newDVD);
        view.displayAddSuccessBanner();
    }
    
    // remove DVD here
    
    // edit DVD here
    
    private void listDVDLibrary(){
        view.displayDVDListBanner();
        ArrayList<DVD> dvdList = doa.getAllDVDs();
        view.displayDVDList(dvdList);
    }
}
