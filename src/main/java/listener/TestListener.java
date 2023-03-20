package listener;

import org.testng.*;

import java.util.Arrays;
import java.util.logging.Logger;

public class TestListener implements ITestListener, IDataProviderListener {
    @Override
    public void onTestStart(ITestResult result) {
        skipIfSkipMe(result.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.getAnonymousLogger().info(result.getThrowable().getMessage());
    }

    @Override
    public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method, ITestContext iTestContext) {
        skipIfSkipMe(method);
    }

    private void skipIfSkipMe(ITestNGMethod testNGMethod) {
        if (Arrays.asList(testNGMethod.getGroups()).contains("SkipMe"))
            throw new SkipException("Test was skipped");
    }
}
