package example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameTests {
    private static String testNameString;
    private static boolean isExpectedBoolean;

    public CheckNameTests(String testNameString, boolean isExpectedBoolean) {
        this.testNameString = testNameString;
        this.isExpectedBoolean = isExpectedBoolean;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]
                {
                        {" Test NameWithSpaceInBeggining", false},
                        {"Test NameWithSpaceInTheEnd ", false},
                        {"Test  NameWithTwoSpacesBetween", false},
                        {"Te", false},
                        {"Tes", false},
                        {"Test ", false},
                        {"Test NameNameNameName", false},
                        {"Test E", true},
                        {"Test Name", true}

                };
    }
    @Test
    public void checkName() {
        Account account = new Account(testNameString);
        boolean isActual = account.checkNameToEmboss();
        assertEquals(isExpectedBoolean, isActual);
    }
}
