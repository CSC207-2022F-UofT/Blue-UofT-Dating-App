package Entities.UserDataClasses.PublicDataClasses;

import Entities.UserDataClasses.UserData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Photos extends UserData<ArrayList<Photo>> {
    public ArrayList<Photo> data;

    public Photos(ArrayList<Photo> photos){
        super(photos);
        this.data = photos;
    }

    public Photos(Photo photo){
        super(new ArrayList<Photo>());
        super.data.add(photo);
        this.data = super.data;
    }
}
