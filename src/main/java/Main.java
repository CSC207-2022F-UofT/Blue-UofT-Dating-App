import UseCases.PracticeGraphCreator;
import UseCases.PracticeGraphReadWrite;

public class Main {
    public static void main(String[] args) {

        PracticeGraphReadWrite practiceGraphReadWrite = new PracticeGraphReadWrite(PracticeGraphCreator.createGraph());

    }
}
