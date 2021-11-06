package com.esai.dvdlibrary.ui;

import com.esai.dvdlibrary.dto.DVD;
import java.util.*;

/**
 *
 * @author Esai
 */
public class DVDLibraryView {

    private UserIO io = new UserIOConsoleImpl();

    // display menu and read user input selection
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Info");
        io.print("4. List DVD's");
        io.print("5. Search for DVD by Title");
        io.print("6. Search for DVD by Title and Year");
        io.print("7. Exit");

        // return user selected option
        return io.readInt("Please select from the above choices.");
    }

    // create and return new DVD from user input to add
    // to library or edit dvd already in library
    public DVD getDVDInfoToAdd() {

        // ask user for information of new DVD
        String dvdTitle = io.readString("Please enter new DVD Title");
        String releaseDate = io.readString("Please enter DVD release Date");
        String mpaaRating = io.readString("Please enter MPAA rating");
        String directorsName = io.readString("Please enter directors name");
        String studio = io.readString("Please enter studio name");
        String userNote = io.readString("Please enter user note");

        // create new DVD with user information
        DVD newDVD = new DVD();
        newDVD.setTitle(dvdTitle);
        newDVD.setReleaseDate(releaseDate);
        newDVD.setMpaaRating(mpaaRating);
        newDVD.setDirectorsName(directorsName);
        newDVD.setStudio(studio);
        newDVD.setUserNote(userNote);

        // return new dvd info
        return newDVD;
    }

    // return DVD from user input to remove from library
    public DVD getDVDToRemove() {
        // ask user for title and release date for dvd to remove
        String dvdTitle = io.readString("Please enter DVD Title to remove");
        String releaseDate = io.readString("Please enter DVD release Date");

        // create new DVD with user information
        DVD newDVD = new DVD();
        newDVD.setTitle(dvdTitle);
        newDVD.setReleaseDate(releaseDate);

        // return new dvd info
        return newDVD;
    }

    // return DVD form user input to edit in library
    public DVD getDVDToEdit() {
        // ask user for title and release date for dvd to remove
        String dvdTitle = io.readString("Please enter DVD Title to edit");
        String releaseDate = io.readString("Please enter DVD release Date");

        // create new DVD with user information
        DVD newDVD = new DVD();
        newDVD.setTitle(dvdTitle);
        newDVD.setReleaseDate(releaseDate);

        // return new dvd info
        return newDVD;
    }

    // ask user what DVD to search for by title
    // return DVD user wants to search for with Title
    public DVD searchDVDByTitle() {
        // ask user for title
        String dvdTitle = io.readString("Please enter DVD title to search for");

        // create DVD to return
        DVD newDVD = new DVD();
        newDVD.setTitle(dvdTitle);

        // return DVD user wants to search for
        return newDVD;
    }

    // ask user what DVD to search for by title and release date
    // return DVD user wants to search for with Title and release date
    public DVD askDVDToSearchFor() {
        // ask user for title
        String dvdTitle = io.readString("Please enter DVD title to search for");
        String dvdReleaseDate = io.readString("Please enter DVD release date");

        // create DVD to return
        DVD newDVD = new DVD();
        newDVD.setTitle(dvdTitle);
        newDVD.setReleaseDate(dvdReleaseDate);

        // return DVD user wants to search for
        return newDVD;
    }

    // display DVD info searched for via title and release date
    public void displayDVDInfo(DVD searchedForDVD) {
        String dvdInfo = String.format("%s : %s : %s : %s : %s : %s",
                searchedForDVD.getTitle(),
                searchedForDVD.getReleaseDate(),
                searchedForDVD.getMpaaRating(),
                searchedForDVD.getDirectorsName(),
                searchedForDVD.getStudio(),
                searchedForDVD.getUserNote());
        io.print(dvdInfo);
        io.readString("Please hit enter to continue");
    }

    // Banner before displaying all DVD's
    public void displayDVDListBanner() {
        io.print("=== Display All DVD's ===");
    }

    // Print out all DVD info in library
    public void displayDVDList(ArrayList<DVD> DVDLibrary) {
        // if there are no dvd's in library print no items
        if (DVDLibrary.size() == 0) {
            io.readString("No DVD's in Library. Please hit enter to continue");
            return;
        }

        for (DVD currentDVD : DVDLibrary) {
            String dvdInfo = String.format("%s : %s : %s : %s : %s : %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirectorsName(),
                    currentDVD.getStudio(),
                    currentDVD.getUserNote());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue");
    }

    // Banner to display when new DVD successfully created
    public void displayAddSuccessBanner() {
        io.readString("DVD successfully added. Please hit enter to continue");
    }

    // Banner to display if DVD was successfully removed or not
    public void displayRemoveSuccessBanner(boolean removed) {
        if (removed) {
            io.readString("DVD was successfully removed. Please hit enter to continue");
        } else {
            io.readString("DVD was not removed. Please hit enter to continue");
        }
    }

    // Banner to display if DVD was successfully edited
    public void displayEditSuccessBanner() {
        io.readString("DVD successfully Edited. Please hit enter to continue");
    }

    // Banner to display if DVD was unsuccessfully edited
    public void displayEditFailureBanner() {
        io.readString("DVD was not Edited. Please hit enter to continue");
    }

    // Banner to display if DVD does not exist in library
    public void displayDoesNotExistBanner() {
        io.readString("DVD searched for does not exist. Please hit enter to continue");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
