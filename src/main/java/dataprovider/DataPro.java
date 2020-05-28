package dataprovider;

import db.SqliteHelper;
import org.testng.annotations.DataProvider;

import java.util.*;

/**
 * Author: mshahabuddin
 * Date: 2/13/2020
 */
public class DataPro {
private SqliteHelper sqliteHelper=new SqliteHelper();
    @DataProvider(name = "platformDp")
    public Iterator<Object[]> getTestData() {
        List<Map<String, Object>> platforms = sqliteHelper.getTestData("platform");
        Collection<Object[]> dp = new ArrayList<Object[]>();
        for (Object platform : platforms) {
            dp.add(new Object[]{platform});
        }

        return dp.iterator();

    }

    @DataProvider(name = "platformDp1", parallel = true)
    public Iterator<Object[]> getTestDataParallel() {
        List<Map<String, Object>> platforms = sqliteHelper.getTestData("platform");
        Collection<Object[]> dp = new ArrayList<Object[]>();
        for (Object platform : platforms) {
            dp.add(new Object[]{platform});
        }

        return dp.iterator();

    }

}
