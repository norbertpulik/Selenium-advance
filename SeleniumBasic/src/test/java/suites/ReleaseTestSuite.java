package suites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.DummyTest;
import tests.WaitForItTest;
import categories.SmokeTest;
import tests.DummyTest;
import tests.InceptionTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(ReleaseTestSuite.class)
@Categories.ExcludeCategory(SmokeTest.class)

@Suite.SuiteClasses({ DummyTest.class, WaitForItTest.class, InceptionTest.class, })

public class ReleaseTestSuite {

}
