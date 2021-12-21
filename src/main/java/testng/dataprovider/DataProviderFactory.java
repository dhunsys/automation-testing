package testng.dataprovider;

import db.SqliteHelper;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Author: mshahabuddin
 * Date: 2/13/2020
 */
public class DataProviderFactory {
    private SqliteHelper sqliteHelper = new SqliteHelper();

    @DataProvider(name = "myDp")
    public Iterator<Object[]> getDpTestData() {
        Collection<Object[]> dp = new ArrayList<>();
        //student1 map
        Map<String, String> s1 = new HashMap<>();
        s1.put("name", "Student1");
        s1.put("roll", "123");
        //student2 map
        Map<String, String> s2 = new HashMap<>();
        s2.put("name", "Student2");
        s2.put("roll", "100");
        dp.add(new Object[]{s1});
        dp.add(new Object[]{s2});
        return dp.iterator();

    }


    @DataProvider(name = "platformDp")
    public Iterator<Object[]> getTestData() {
        List<Map<String, Object>> platforms = sqliteHelper.getTestData("platform");
        Collection<Object[]> dp = new ArrayList<>();
        for (Object platform : platforms) {
            dp.add(new Object[]{platform});
        }

        return dp.iterator();

    }

    @DataProvider(name = "platformDp1", parallel = true)
    public Iterator<Object[]> getTestDataParallel() {
        List<Map<String, Object>> platforms = sqliteHelper.getTestData("platform");
        Collection<Object[]> dp = new ArrayList<>();
        for (Object platform : platforms) {
            dp.add(new Object[]{platform});
        }

        return dp.iterator();

    }

    @DataProvider(name = "2DReturnType")
    public Object[][] createDp() {
        return new Object[][]{
                {"Student1", new Integer(36)},
                {"student2", new Integer(37)},
        };
    }


    @DataProvider(name = "nameDp")
    public Object[][] gtName() {
        return new Object[][]{{"ABC"}, {"XYZ"}};

    }

    @DataProvider(name = "setParallelTruewe")
    public Object[][] gtParallelTrue(Method method) {
        return new Object[][]{{"Mumbai"}, {"Delhi"}, {"Kolkata"}, {"Chennai"}, {"Pune"}, {"Patna"}};

    }
}
