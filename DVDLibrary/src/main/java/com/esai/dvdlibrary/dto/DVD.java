package com.esai.dvdlibrary.dto;

/**
 *
 * @author Esai
 */
public class DVD {

    // properites of DVD
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String userNote;
    
    // return title
    public String getTitle(){
        return title;
    }
    
    // set title
    public void setTitle(String newTitle){
        title = newTitle;
    }
    
    // return release date
    public String getReleaseDate(){
        return releaseDate;
    }
    
    // set release date
    public void setReleaseDate(String newReleaseDate){
        releaseDate = newReleaseDate;
    }
    
    // return mpaa rating
    public String getMpaaRating(){
        return mpaaRating;
    }
    
    // set mpaa rating
    public void setMpaaRating(String newMpaaRating){
        mpaaRating = newMpaaRating;
    }
    
    // return directors name
    public String getDirectorsName(){
        return directorsName;
    }
    
    // set directors name
    public void setDirectorsName(String newName){
        directorsName = newName;
    }
    
    // return studio
    public String getStudio(){
        return studio;
    }
    
    // set studio
    public void setStudio(String newStudio){
        studio = newStudio;
    }
    
    // return user note
    public String getUserNote(){
        return userNote;
    }
    
    // set user note
    public void setUserNote(String newUserNote){
        userNote = newUserNote;
    }
    
}
