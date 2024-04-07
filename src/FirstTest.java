import lib.CoreTestCase;
import lib.ui.AddHobbitToListAndDeleteObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

public class FirstTest extends CoreTestCase {
    private MainPageObject mainPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    @Test
    public void testSearchKemSU() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Кемеровский государственный университет");
        searchPageObject.waitForSearchResult("Kemerovo State University");
        String result = searchPageObject.waitForTitleResult("Kemerovo State University");
        Assert.assertEquals("Найдено несовпадение в названии статьи", "Хоббит", result);
    }

    @Test
    public void testAddHobbit() {
        AddHobbitToListAndDeleteObject addHobbit = new AddHobbitToListAndDeleteObject(driver);
        addHobbit.initSearchInput();
        addHobbit.typeSearchLine("The Hobbit");
        addHobbit.waitForSearchResult("The Hobbit");
        addHobbit.createListAndAddFilm("Hobbit");
        addHobbit.deleteList("Hobbit");
    }
}
