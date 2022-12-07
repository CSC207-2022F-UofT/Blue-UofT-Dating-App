package usecases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class OtherAccountTest {

    @Test
    void testOtherAccountUseCaseName() {
        DisplayUserModel displayUserModel = new DisplayUserModel("Ewan");
        Object[] updateInformation = displayUserModel.getModel();
        Assertions.assertEquals("Ewan", updateInformation[0]);
    }
    @Test
    void testOtherAccountUseCaseBio() {
        DisplayUserModel displayUserModel = new DisplayUserModel("Ewan");
        Object[] updateInformation = displayUserModel.getModel();
        Assertions.assertEquals("Just your average UofT student.", updateInformation[2]);
    }
    @Test
    void testOtherAccountUseCaseLoc() {
        DisplayUserModel displayUserModel = new DisplayUserModel("Ewan");
        Object[] updateInformation = displayUserModel.getModel();
        Assertions.assertEquals("2nd Massey", updateInformation[1]);
    }
    @Test
    void testOtherAccountUIntsAtrsCour() {
        DisplayUserModel displayUserModel = new DisplayUserModel("Ewan");
        Object[] userinfo = displayUserModel.getModel();
        ArrayList<String> size = (ArrayList<String>) userinfo[3];
        ArrayList<String> size2 = (ArrayList<String>) userinfo[4];
        ArrayList<String> size3 = (ArrayList<String>) userinfo[5];
        int intersts = size.size();
        int attributes = size2.size();
        int courses = size3.size();
        Assertions.assertEquals(0, intersts);
        Assertions.assertEquals(14,attributes);
        Assertions.assertEquals(1, courses);


    }
}
