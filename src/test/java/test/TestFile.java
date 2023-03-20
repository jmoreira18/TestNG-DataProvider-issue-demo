package test;

import listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListener.class})
public class TestFile {

    @Test(groups = "SkipMe")
    public void testSkip() {
        Assert.fail("This test should not execute, it should be skipped");
    }

    @DataProvider(name = "dataProvider")
    private Object[] dataProvider() { return new Object[] {"test1"}; }

    @Test(dataProvider = "dataProvider", groups = "SkipMe")
    public void dataProviderTestSkip(String a) {
        Assert.fail("This test should not execute, it should be skipped");
    }
}
