package usecases;

public class Like {
    public boolean like;

    public void like(){
        like = false;
    }

    public void setLike(){
    //    if(...) { // update like if the like button is clicked on the interface
            like = true;
            //}
    }


    public int getLike(){
        //used in the likeDislike UserGraph
        //return binary representation of dislike status
        if(like){
            return 1;
        }
        //in this case, like is false, return 0
        return 0;
    }

}
