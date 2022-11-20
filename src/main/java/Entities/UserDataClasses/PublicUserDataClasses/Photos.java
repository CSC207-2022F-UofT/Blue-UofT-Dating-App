package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.io.Serializable;
import java.util.ArrayList;

public class Photos extends UserData<ArrayList<Photo>> implements Serializable {
    public ArrayList<Photo> data;

    // Constructors
    public Photos(){
        super(new ArrayList<Photo>());
        this.data = super.data;
    }
    public Photos(ArrayList<Photo> photos){
        super(photos);
        this.data = photos;
    }
    public Photos(Photo photo){
        super(new ArrayList<Photo>());
        super.data.add(photo);
        this.data = super.data;
    }
    public Photos(String photo){
        super(new ArrayList<Photo>());
        super.data.add(new Photo(photo));
        this.data = super.data;
    }


    // Methods
    public void addPhoto(Photo photo){
        this.data.add(photo);
    }
    public void addPhotos(ArrayList<Photo> photos){
        this.data.addAll(photos);
    }
    public void removePhoto(Photo photo){
        this.data.remove(photo);
    }
    public void removePhotos(ArrayList<Photo> photos){
        this.data.removeAll(photos);
    }
}