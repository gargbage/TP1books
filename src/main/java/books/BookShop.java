package books;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class BookShop {

    private final String name;

    /**
     * Constructor of the class Book shop
     *
     * @param name name of the book shop
     */
    public BookShop(String name) {
        this.name = name;
    }

    /**
     * method to compute the cost of a basket
     *
     * @param books array corresponding to the books that the client desire to
     * buy
     * @return the cost in euro with the discount
     */
    public double cost(String[] books) {
        try {
            double cost = 0.0;
            double cost_hp = 0.0;
            LinkedList list_Unique_HPs = new LinkedList();
            BooksAvailable booksAvailable = new BooksAvailable();

            for (String bookName : books) {
                Boolean isItHP = booksAvailable.IsItHarryPotter(bookName);
                if (isItHP) {
                    Boolean isItUniqueHP = IsItUniqueHPBook(list_Unique_HPs, bookName);
                    if (isItUniqueHP) {
                        list_Unique_HPs.add(bookName);
                        cost_hp += 8.0;
                    } else {
                        cost += 8.0;
                    }
                } else {
                    cost += 8.0;
                }
            }

            Double availableDiscount = DiscountAvailable(list_Unique_HPs.size());
            cost_hp = ((100.0 - availableDiscount) * cost_hp) / 100.0;
            cost = cost + cost_hp;
            return new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP).doubleValue();
        } catch (Exception ex) {
            System.out.println("Error at books.BookShop.cost()");
            ex.printStackTrace();
            return -1;
        }
    }

    /**
     *
     * @param list_Unique_HPs
     * @param hp_BookName
     * @return Returns True if the provided Harry Potter book is not in the list
     * of already bought books else returns False
     * @throws Exception
     */
    Boolean IsItUniqueHPBook(LinkedList list_Unique_HPs, String hp_BookName) throws Exception {
        try {
            Boolean unique;
            if (list_Unique_HPs == null || list_Unique_HPs.isEmpty()) {
                unique = true;
            } else if (list_Unique_HPs.contains(hp_BookName)) {
                unique = false;
            } else {
                unique = true;
            }
            return unique;
        } catch (Exception ex) {
            System.out.println("Error at books.BookShop.IsItUniqueHPBook()");
            throw ex;
        }
    }

    /**
     *
     * @param uniqueHPs
     * @return
     * @throws Returns the discount percentage based on the number of unique HP
     * books bought
     */
    Double DiscountAvailable(Integer uniqueHPs) throws Exception {
        try {
            Double discount = 0.0;
            switch (uniqueHPs) {
                case 1:
                    discount = 0.0;
                    break;
                case 2:
                    discount = 7.0;
                    break;
                case 3:
                    discount = 14.0;
                    break;
                case 4:
                    discount = 28.0;
                    break;
                case 5:
                    discount = 35.0;
                    break;
                default:
                    discount = 0.0;
            }
            return discount;
        } catch (Exception ex) {
            System.out.println("Error at books.BookShop.DiscountAvailable()");
            throw ex;
        }
    }
}
