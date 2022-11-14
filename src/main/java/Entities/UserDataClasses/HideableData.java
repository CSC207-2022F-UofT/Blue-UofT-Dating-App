package Entities.UserDataClasses;

import java.io.Serializable;

public abstract class HideableData<H> extends UserData<H> implements Serializable {

    public H data;
    public boolean hidden;

    public HideableData(H data){
        super(data);
        this.data = data;
        this.hidden = true;
    }
    public HideableData(H data, boolean hidden){
        super(data);
        this.data = data;
        this.hidden = hidden;
    }

    public void hide(){
        this.hidden = true;
    }

    public void show(){
        this.hidden = false;
    }

    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }
}
