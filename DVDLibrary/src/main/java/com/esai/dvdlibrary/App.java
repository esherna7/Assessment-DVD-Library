package com.esai.dvdlibrary;

import com.esai.dvdlibrary.controller.DVDLibraryController;

/**
 *
 * @author Esai
 */
public class App {

    
    public static void main(String args[]) {
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();
    }
}
