package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Report;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportImplTest {
    private static final Report report = new ReportImpl();

    @BeforeClass
    public static void beforeClass() {
        Storage.storage.put(new Fruit("apple"), 100);
        Storage.storage.put(new Fruit("banana"), 20);
    }

    @Test
    public void createReport_Ok() {
        List<String> expected = new ArrayList<>(List.of("fruit,amount", "banana,20", "apple,100"));
        List<String> actual = report.createNewReport();
        assertEquals(expected, actual);
    }
}
