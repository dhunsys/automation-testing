package testng.annotations;

import org.testng.annotations.Test;

/**
 * The @Test annotation can be put on a class instead of a test method:
 * The effect of a class level @Test annotation is to make all the public methods of this class to become test methods even if they are not annotated.
 * You can still repeat the @Test annotation on a method if you want to add certain attributes.
 * Here test1 is not annotated with @Test still testng take it as a test method due to @Test annotation at class level
 * RUN : run this test class directly to see 2 tests run
 */
@Test
public class ClassLevelAnnotationTest {

    public void test1() {
        System.out.println("I am not annotated with @Test");
    }

    @Test
    public void test2() {
        System.out.println("I am annotated with @Test");
    }
}
