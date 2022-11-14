package Entities.UserDataClasses;

import java.io.Serializable;

public abstract class UserData<T> implements Serializable {

    public T data;

    public UserData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T newData){
        this.data = newData;
    }
}
