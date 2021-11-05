package com.esai.dvdlibrary.dto;

/**
 *
 * @author Esai
 */
public class DVD {

    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String userNote;
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String newTitle){
        title = newTitle;
    }
    
    public String getReleaseDate(){
        return releaseDate;
    }
    
    public void setReleaseDate(String newReleaseDate){
        releaseDate = newReleaseDate;
    }
    
    public String getMpaaRating(){
        return mpaaRating;
    }
    
    public void setMpaaRating(String newMpaaRating){
        mpaaRating = newMpaaRating;
    }
    
    public String getDirectorsName(){
        return directorsName;
    }
    
    public void setDirectorsName(String newName){
        directorsName = newName;
    }
    
    public String getStudio(){
        return studio;
    }
    
    public void setStudio(String newStudio){
        studio = newStudio;
    }
    
    public String getUserNote(){
        return userNote;
    }
    
    public void setUserNote(String newUserNote){
        userNote = newUserNote;
    }
    
}
