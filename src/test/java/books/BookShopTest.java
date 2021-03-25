package books;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * TODO : Add your import here
 */
public class BookShopTest {

    BookShop bookShop;
    BooksAvailable booksAvailable;

    @BeforeEach
    public void setUp() {
        booksAvailable = new BooksAvailable();
        bookShop = new BookShop("a-z books");
        System.out.println("Object initialized, test will run now.");
    }

    @Test
    public void testCost_DuplicateHPbooks() {
        String[] booksBought = {booksAvailable.hp_Azkaban,
            booksAvailable.hp_Azkaban,
            booksAvailable.other,
            "Mask of Zorro: Part 2"
        };
        assertEquals(32.0, bookShop.cost(booksBought));
    }

    @Test
    public void testCost_NoHPbooks() {
        String[] booksBought = {booksAvailable.other,
            "Mask of Zorro: Part 2"
        };
        assertEquals(16.0, bookShop.cost(booksBought));
    }
    
    @Test
    public void testCost_OneUniqueHPbook() {
        String[] booksBought = {booksAvailable.hp_Fire
        };
        assertEquals(8.0, bookShop.cost(booksBought));
    }
    
    @Test
    public void testCost_TwoUniqueHPbooks() {
        String[] booksBought = {booksAvailable.hp_Fire,
            booksAvailable.hp_Azkaban
        };
        assertEquals(14.88, bookShop.cost(booksBought));
    }
    
    @Test
    public void testCost_ThreeUniqueHPbooks() {
        String[] booksBought = {booksAvailable.hp_Fire,
            booksAvailable.hp_Azkaban,
            booksAvailable.hp_Phoenix
        };
        assertEquals(20.64, bookShop.cost(booksBought));
    }
    
    @Test
    public void testCost_FourUniqueHPbooks() {
        String[] booksBought = {booksAvailable.hp_Fire,
            booksAvailable.hp_Azkaban,
            booksAvailable.hp_Phoenix,
            booksAvailable.hp_Secrets
        };
        assertEquals(23.04, bookShop.cost(booksBought));
    }
    
    @Test
    public void testCost_AllUniqueHPbooks() {
        String[] booksBought = {booksAvailable.hp_Fire,
            booksAvailable.hp_Azkaban,
            booksAvailable.hp_Phoenix,
            booksAvailable.hp_Secrets,
            booksAvailable.hp_Stone
        };
        assertEquals(26.0, bookShop.cost(booksBought));
    }

    @Test
    public void testCost_UniqueHPbooksPlusExtra() {
        String[] booksBought = {booksAvailable.hp_Fire,
            booksAvailable.hp_Azkaban,
            booksAvailable.other,
            "Mask of Zorro: Part 2"
        };
        assertEquals(30.88, bookShop.cost(booksBought));
    }

    @Test
    public void testCost_AllUniqueHPbooksPlusExtra() {
        String[] booksBought = {booksAvailable.hp_Fire,
            booksAvailable.hp_Azkaban,
            booksAvailable.hp_Phoenix,
            booksAvailable.hp_Secrets,
            booksAvailable.hp_Stone,
            "The Punisher: Border Crossing",
            booksAvailable.other
        };
        assertEquals(42, bookShop.cost(booksBought));
    }
    
    @Test
    public void testCost_4HPbooksWith3Unique() {
        String[] booksBought = {booksAvailable.hp_Azkaban,
            booksAvailable.hp_Fire,
            booksAvailable.hp_Phoenix,
            booksAvailable.hp_Azkaban
        };
        assertEquals(28.64, bookShop.cost(booksBought));
    }
}
