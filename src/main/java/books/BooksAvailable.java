/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

/**
 *
 * @author aayush.garg
 */
public class BooksAvailable {

    public BooksAvailable() {

    }

    String hp_Stone = "Harry Potter and the Philosopher’s Stone";
    String hp_Secrets = "Harry Potter and the Chamber of Secrets";
    String hp_Azkaban = "Harry Potter and the Prisoner of Azkaban";
    String hp_Fire = "Harry Potter and the Goblet of Fire";
    String hp_Phoenix = "Harry Potter and the Order of the Phoenix";
    String other = "This is good, not Harry Potter though";

    Boolean IsItHarryPotter(String bookName) throws Exception {
        try {
            Boolean result;
            if (bookName == null || bookName.isEmpty()) {
                result = false;
            } else if (bookName.equals(hp_Stone)
                    || bookName.equals(hp_Secrets)
                    || bookName.equals(hp_Azkaban)
                    || bookName.equals(hp_Fire)
                    || bookName.equals(hp_Phoenix)) {
                result = true;
            } else {
                result = false;
            }
            return result;
        } catch (Exception ex) {
            System.out.println("Error at books.BooksAvailable.IsItHarryPotter()");
            throw ex;
        }
    }
}
