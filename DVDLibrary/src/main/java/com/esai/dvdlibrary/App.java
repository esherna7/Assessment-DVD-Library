package com.esai.dvdlibrary;

import com.esai.dvdlibrary.controller.DVDLibraryController;

/**
 *
 * @author Esai
 */
public class App {

    // Starts running Controller
    public static void main(String args[]) {
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();
    }
}
