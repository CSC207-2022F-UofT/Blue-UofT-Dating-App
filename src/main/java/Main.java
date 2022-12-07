import usecases.PracticeGraphCreator;
import usecases.PracticeGraphReadWrite;

public class Main {
    public static void main(String[] args) {

        PracticeGraphReadWrite practiceGraphReadWrite = new PracticeGraphReadWrite(PracticeGraphCreator.createGraph());

    }
}
