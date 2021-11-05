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
    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Info");
        io.print("4. List DVD's");
        io.print("5. Display Info for DVD");
        io.print("6. Search for DVD by Title");
        io.print("7. Exit");
        
        // return user selected option
        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    // 
    public DVD getDVDInfo(){
        
        // ask user for information of new DVD
        String dvdTitle = io.readString("Please enter DVD Title");
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
    
    public void displayDVDListBanner(){
        io.print("=== Display All DVD's ===");
    }
    
    public void displayDVDList(ArrayList<DVD> DVDLibrary){
        for(DVD currentDVD : DVDLibrary){
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
    
    public void displayAddSuccessBanner(){
        io.readString("DVD successfully added. Please hit enter to continue");
    }
}
