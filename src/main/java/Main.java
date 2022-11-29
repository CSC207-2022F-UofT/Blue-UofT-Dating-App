import Entities.UserGraph;
import UseCases.PracticeGraphCreator;
import UseCases.PracticeGraphReadWrite;
import FrameworksDrivers.UserEditView;
public class Main {
    public static void main(String[] args) {

        PracticeGraphReadWrite practiceGraphReadWrite = new PracticeGraphReadWrite(PracticeGraphCreator.createGraph());

    }
}
