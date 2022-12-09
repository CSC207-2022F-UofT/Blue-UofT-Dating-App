import FrameworksDrivers.ViewUI;
import UseCases.PracticeGraphCreator;
import UseCases.PracticeGraphReadWrite;
import UseCases.dataretrieval.GetChats;
public class Main {
    public static void main(String[] args) {
        new ViewUI();
        new GetChats();
    }
}
