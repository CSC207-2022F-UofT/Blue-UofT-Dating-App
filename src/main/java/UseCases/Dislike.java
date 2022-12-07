package UseCases;

public class Dislike {
    public boolean dislike;

    public void dislike() {
        dislike = false;
    }

    public void setDislike() {
        //if (...){ // if 'dislike button is clicked'
            dislike = true;
            //}
    }


    public int getDislike() {
        //used in the likeDislike UserGraph
        //return binary representation of dislike status
        if (dislike) {
            return 1;
        }
        // in this case, dislike is false, returns 0
        return 0;
    }
}

