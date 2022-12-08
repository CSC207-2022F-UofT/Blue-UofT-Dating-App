package UseCases;

import Entities.User;
import UseCases.useredit.CompatibilityFunction;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static java.lang.Math.round;


/**
 * Test Class for CompatibilityFunction use case
 */
class CompatibilityFunctionTest {
    private User testUser1;
    private User testUser2;
    private User testUser3;
    private User testUser4;

    /**
     * Creates Users for Testing
     */
    void createTestUsers(){
        testUser1 = new User("test1", "1");
        testUser2 = new User("test2", "1");
        testUser3 = new User("test3", "1");
        testUser4 = new User("test4", "1");

        // Add blue eyes to User 1
        testUser1.addAttribute(5, 2);

        // Make blue eyes a dealbreaker for User 2
        testUser2.addPreference(5, 2);

        // Make Users 2 and 3 interested in rock music, partying, and pizza
        ArrayList<Integer> commonInterests = new ArrayList<>();
        commonInterests.add(46);
        commonInterests.add(44);
        commonInterests.add(33);
        testUser2.addInterests(commonInterests);
        testUser3.addInterests(commonInterests);

        // Make User 1 interested in rock music
        testUser1.addInterest(46);
    }

    // The weights between users should be as follows:
    // User1 - User2: 0
    // User1 - User3: .5 + 1/102
    // User2 - User3: .5 + 3/102
    // User4 - any User: .5

    /**
     * Tests to ensure the expected weights between Users is given by the
     * compatibility function (forwards and backwards)
     */
    @Test
    void testCompatibilityFunction() {
        createTestUsers();
        CompatibilityFunction test = new CompatibilityFunction();

        assert test.getCompatibility(testUser1, testUser2) == 0;
        assert test.getCompatibility(testUser2, testUser1) == 0;
        assert test.getCompatibility(testUser1, testUser4) == .5;
        assert test.getCompatibility(testUser2, testUser4) == .5;
        assert test.getCompatibility(testUser4, testUser2) == .5;
        assert test.getCompatibility(testUser3, testUser4) == .5;

        // Because floats are hard to work with, we will ensure the difference
        // between the actual and expected values is neglibible:
        assert round(test.getCompatibility(testUser1, testUser3) - (.5 + (1f / 102f))) == 0;
        assert round(test.getCompatibility(testUser2, testUser3) - (.5 + (3f / 102f))) == 0;

    }

}