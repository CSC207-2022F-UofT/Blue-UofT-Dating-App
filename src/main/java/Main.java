import Entities.UserGraph;
import UseCases.PracticeGraphCreator;
import UseCases.PracticeGraphReadWrite;

public class Main {
    public static void main(String[] args) {
        // Note how we are "cheating" here and directly creating objects from all of our
        // layers of Clean Architecture in main. This is fine for the purposes
        // of this little demo, but your main method shouldn't generally look like this.

        // Set up a list of users to store in the LoginUseCase so we can try things out
        // for our demo.
        UserGraph userGraph = PracticeGraphCreator.createGraph();
        PracticeGraphReadWrite go = new PracticeGraphReadWrite(userGraph);

    }
}
