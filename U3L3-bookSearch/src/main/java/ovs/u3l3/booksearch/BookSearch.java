

//Name: Hetarth Parikh
//Unit,Lesson,Name of Assignment: Unit 3 Lesson 3, book Search Assignment
//Date of Completion: October 8th 2024
//Description:This is a program that holds an array of children books with their
//designated reference numbers. Using binary and linear search methods, the code
//will proceed to search for the book as the user enters the reference number
//I've also added the feature of giving the user a short summary of what the book 
//is about and also being able to rate the book giving out average ratings if theres
//multiple, and also displaying what the best seller book is based on the ratings given
//to all the books




package ovs.u3l3.booksearch;


import javax.swing.*;// For JFrame, JButton, JTextArea, JOptionPane, etc.
import javax.swing.event.DocumentEvent;//This is for document event handling
import javax.swing.event.DocumentListener;//to listen to changes in the text field
import java.awt.*;// For layout managers and other components basically
import javax.swing.border.LineBorder;//to change the border of different parts
import javax.swing.JOptionPane;//to show the user message windows
import javax.swing.BorderFactory;//For the border live validation
import javax.swing.border.Border;//Also for the border live validation
import java.awt.event.WindowAdapter;//to handle window events in this case the X
import java.awt.event.WindowEvent;//to capture any window events such as opening etc.
import java.awt.Color;//this is for the color and to use it
import java.util.HashMap;//TO be able to use Hashmap
import java.util.ArrayList;//to use array lists
import java.util.List;//to use lists 
/**
 *
 * @author user
 */
public class BookSearch extends javax.swing.JFrame {
    //this is a HashMap that stores book titles as keys and their summaries as values.
    private HashMap<String, String> bookSummaries;
    //this is another HashMap that stores the booktitles as keys and a list of ratings 
    //for each book as values
    private HashMap<String, List<Integer>> bookRatings;
    /**
     * Creates new form BookSearch
     */
    public BookSearch() {
        initComponents();
        addDocumentListener();;//this adds the document listener
        initializeBookSummaries();//this will initialize the book summmaries for 
                                   //the book summary feature
        setSize(800, 600);//this sets the size of the window 
        initializeBookRatings();//this is initializing the book ratings feature
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//this is just
                                            //setting the default close operation to do nothing on close
        
         // Add the WindowListener to do the validation for the X 
    addWindowListener(new WindowAdapter() {
        @Override
    public void windowClosing(WindowEvent e) {
        // Show the confirmation dialog when user clicks the 'X'
        int response = JOptionPane.showConfirmDialog(
                BookSearch.this,
                //this asks the user if their sure they want to exit
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,//displays the yes or no option
                JOptionPane.QUESTION_MESSAGE//this shows the question message
        );

        // If the user clicks yes, then exit the program
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the program
        }
        // If no, just do nothing and keep the application running
    }
});
    }
    //this is a method to have book ratings
    private void initializeBookRatings() {
    //this initializes the hashmap to hold the book ratings where the key is the
    //book number and the value is just a list of ratings
    bookRatings = new HashMap<>();
    //then loop through each key in the booksummaries hashmap to get ratings for each book
    for (String key : bookSummaries.keySet()) {
        //Now for every book number, this will create an ArrayList to hold these ratings
        bookRatings.put(key, new ArrayList<>()); 
    }
}
    //This is to actually add the rating
    private void addRating(String refNumber, int rating) {
        //this will check if the number even exists in the bookratings hashmap 
    if (bookRatings.containsKey(refNumber)) {
        //then it will add the provided rating to the list of ratings for whatever
        //book it is
        bookRatings.get(refNumber).add(rating); 
        //then it will show a window to the user saying it was added and what the current
        //average rating is based on the amount of times the user rated it
        JOptionPane.showMessageDialog(this, "Rating added! The current average rating is: " + getAverageRating(refNumber));
    } else {
        //if not found, then tell the user with another window showing up 
        JOptionPane.showMessageDialog(this, "Book not found! Please check the reference number.");
    }
}

private double getAverageRating(String refNumber) {
    //this will just get the list of ratings for the book number
    List<Integer> ratings = bookRatings.get(refNumber);
    //then it checks if the list is empty
    if (ratings.isEmpty()) {
        return 0; //This just avoids division by zero, and return if no ratings are there
    }
    //this will just calculate and return the average of the ratings using something
    //called streams. 
    return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
}
    
    private void initializeBookSummaries() {
        // This basically creates a HashMap where the key is a string representing the reference number
        // and the value is a string containing a brief summary of the corresponding book that it matched with
        // Create a HashMap where the key is a String representing the book number
        //the following are all lines with the book's summaries and their numbers
        bookSummaries = new HashMap<>();
        bookSummaries.put("1", "A young boy's adventures growing up in a small town near the Mississipi river.");
        bookSummaries.put("2", "A boy named Huck who runs away from his abusive father and make a trip down the Mississipi river on a raft. The book shows and displays racism as a whole as well");
        bookSummaries.put("4", "The tale of King Arthur's childhood and the magical sword to show he is worth of the throne.");
        bookSummaries.put("6", "This book is about a mouse named stuart who goes on many adventures around NYC to search for his friend who is a bird.");
        bookSummaries.put("10", "This is about a boy named Jim Hawkins who discovers a treasure map and goes on a thrilling adventure as well.");
        bookSummaries.put("12", "A girl named Mary Lennox finds a hidden garden that she brings back to life.");
        bookSummaries.put("14", "A girl named Alice falls into a rabbit hole that takes her to a whole new world with sttrange creatures and so many adventures.");
        bookSummaries.put("20", "A character named Professor Aronnax and his friends go on a underwater adventure aboard a submarine.");
        bookSummaries.put("24", "A boy named Peter Pan who never grows up takes Wendy and her brothers to a place called Neverland where they embark on new adventures");
        bookSummaries.put("26", "A girl named fern has a pet pig named Wilbur and his friend is a spider named Charlotte who helps Wilbur not be slaughtered by the farmers of the farm they live on ");
        bookSummaries.put("31", "A girl named Sara Crewe struggles as her father dies and she is sent to a very strict boarding school, but her imagination helps her get through it all.");
        bookSummaries.put("32", "This book is basically about 4 sisters as they grow up and go through family hardships and their lives as a whole.");
        bookSummaries.put("33", "This book is being told by the perspective of a horse. Its about treating animals properly.");
        bookSummaries.put("35", "An outlaw named Robin Hood help bring peace by fighting alongside his Merry men and going on adventures.");        
        bookSummaries.put("40", "After a huge shipwreck, Robinson Crusoe finds himself stranded on an island where he has to survive.");
        bookSummaries.put("46", "Anne is an oprhan who is by accident, sent to live with 2 siblings in Green Gables.");
        bookSummaries.put("50", "The daily life of the Ingalls family as they settle in the woods.");
        bookSummaries.put("52", "A family must work together to survive on a deserted island using their resources.");
        bookSummaries.put("54", "Basically 4 siblings enter the world of Narnia where they help Aslan defeat the White Witch and help bring peace again.");
        bookSummaries.put("56", "A girl named Heidi is sent to live with her grandpa in the Alps, where she experiences life like none other.");
        bookSummaries.put("66", "Meg Murry and her brother Charles and their friend Calvin go on a journey through space and time to rescue Meg's dad from evil.");
        bookSummaries.put("100", "A nanny named Mary poppins arrives to help care for children but uses her magic to show them different life lessons.");


    }
    
   //This function just adds the DocumentListener to the text field where the user
   //is inputting the book number
    private void addDocumentListener() {
        // Add DocumentListener to the textRating field to trigger validation on text change
    textRating.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            validateRating(); //this just calls the validation specifically 
                              //for the rating when text is inserted
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validateRating(); // This just calls the validation specifically 
                              //for the rating when text is removed basically
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            validateRating(); // this is the same thing except when the text is changed
        }
    });

    // Add DocumentListener to the textNumber field to trigger validation on text change
    textNumber.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            validateNumber(); //This just calls validation specifically for the number when text is inserted
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validateNumber(); //This just calls validation specifically for the number when text is removed
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            validateNumber(); //same thing as before but specifically for the number when text is changed
        }
    });
}
//this method is for the number field
private void validateNumber() {
    String input = textNumber.getText();
    if (isNumeric(input)) {
        // if it is valid make it green
        textNumber.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2)); 
    } else {
        // if not make it red
        textNumber.setBorder(BorderFactory.createLineBorder(Color.RED, 2)); 
    }
}
//this is for the rating field
private void validateRating() {
    String Input = textRating.getText();
    if (isNumeric(Input) && isValidRatingRange(Input)) {
        // If rating is numeric and within valid range, make it green
        textRating.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
    } else {
        // If rating is not numeric or out of valid range, make it red is what its
        //doing
        textRating.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
    }
}

// This is the method to check if a string is numbers
private boolean isNumeric(String str) {
    try {
        Integer.parseInt(str);
        return true;//returns true if it is a number
    } catch (NumberFormatException e) {
        return false;//returns false if the string isnt numbers
    }
}

//This is another method to check if the rating is within the valid range I put
private boolean isValidRatingRange(String str) {
    int rating = Integer.parseInt(str);//parses string
    return rating >= 1 && rating <= 5;//makes sure its between this range 
}
    //this is the array of books being defined here along with the numbers
    private final String[][] books = {
    {"1", "The Adventures of Tom Sawyer"},
    {"2", "Huckleberry Finn"},
    {"4", "The Sword in the Stone"},
    {"6", "Stuart Little"},
    {"10", "Treasure Island"},
    {"12", "The Secret Garden"},
    {"14", "Alice's Adventures in Wonderland"},
    {"20", "Twenty Thousand Leagues Under the Sea"},
    {"24", "Peter Pan"},
    {"26", "Charlotte's Web"},
    {"31", "A Little Princess"},
    {"32", "Little Women"},
    {"33", "Black Beauty"},
    {"35", "The Merry Adventures of Robin Hood"},
    {"40", "Robinson Crusoe"},
    {"46", "Anne of Green Gables"},
    {"50", "Little House in the Big Woods"},
    {"52", "Swiss Family Robinson"},
    {"54", "The Lion, the Witch and the Wardrobe"},
    {"56", "Heidi"},
    {"66", "A Wrinkle in Time"},
    {"100", "Mary Poppins"}
};
    //this is the method for the linear search on the books array 
    private String linearSearch(String refNumber) {
    //this will just iterate through each book in the array 
    for (String[] book : books) {
        //then it'll check if the current input matches any numbers in the array
        if (book[0].equals(refNumber)) {
            //if so, then return the matched book title
            return "Found: " + book[1];
        }
    }
    //if not, tell the user by showing a message
    return "Book not found with linear search.";
}
    //this is the method to perfom a binary search
    private String binarySearch(String refNumber) {
    int low = 0;//this initializes the lower index of the search range basically
    int high = books.length - 1;//this initializes the upper index
    //this while loop will continue to keep searching while the low index is less than 
    //or equal to the upper index
    while (low <= high) {
        //this calculates the middle index of the current search range
        int mid = (low + high) / 2;
        //this then gets the reference number at this range 
        int midRef = Integer.parseInt(books[mid][0]);
        //now this here checks if the mid number matches the input number 
        if (midRef == Integer.parseInt(refNumber)) {
            //if so, then return the book title
            return "Found: " + books[mid][1];
            //if the mid numeber is less than the input, this will search in the 
            //right side basically
        } else if (midRef < Integer.parseInt(refNumber)) {
            low = mid + 1;
            //if its higher than the input, this will search in the left side
        } else {
            high = mid - 1;
        }
    }
    //if the book number is not found, display this message to the user to let 
    //them know 
    return "Book not found with binary search.";
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNumber = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        textLinear = new javax.swing.JTextField();
        textBinary = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSummary = new javax.swing.JButton();
        btnRate = new javax.swing.JButton();
        textRating = new javax.swing.JTextField();
        btnShow = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Children's Classics");

        jLabel2.setText("Enter the reference number:");

        textNumber.setBackground(new java.awt.Color(153, 204, 255));

        btnSearch.setText("Find book!");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        textLinear.setEditable(false);

        textBinary.setEditable(false);

        jLabel3.setText("Linear Search");

        jLabel4.setText("Binary Search");

        btnSummary.setText("Summary of your book!");
        btnSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryActionPerformed(evt);
            }
        });

        btnRate.setText("Rate the book!");
        btnRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRateActionPerformed(evt);
            }
        });

        textRating.setBackground(new java.awt.Color(153, 204, 255));

        btnShow.setText("Show all ratings");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBest.setText("Best Seller!");
        btnBest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnSearch))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnClear)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(67, 67, 67))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRate)
                                        .addComponent(jLabel2)
                                        .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(textNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(196, 196, 196)
                                    .addComponent(btnSummary))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textBinary, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                    .addComponent(textLinear))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnShow)
                                    .addGap(86, 86, 86)
                                    .addComponent(btnBest))))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSummary))
                .addGap(27, 27, 27)
                .addComponent(btnSearch)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textLinear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBinary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRate)
                    .addComponent(btnShow)
                    .addComponent(btnBest))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addGap(167, 167, 167))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    //this is a method to reset the border colors after finding a book
    //sets them both back to normal without the color
    private void resetFieldBorders() {
    textNumber.setBorder(BorderFactory.createLineBorder(Color.GRAY));  
    textRating.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 
}
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         String refNumber = textNumber.getText();

try {
    //This basically just parses the input to ensure it's a valid number
    int referenceNumber = Integer.parseInt(refNumber);

    //This function just does the linear search
    String linearResult = linearSearch(refNumber);
    textLinear.setText(linearResult);//this then just diplays it

    //This will just do the binary search
    String binaryResult = binarySearch(refNumber);
    textBinary.setText(binaryResult);//this then displays it
    
     resetFieldBorders();
} catch (NumberFormatException e) {
    //if its not numeric, it'll let the user know with this window
    JOptionPane.showMessageDialog(this, "Invalid input! Please enter a numeric reference number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryActionPerformed
        // TODO add your handling code here:
        //this code here is for the summary portion of whatever book the user found
          String refNumber = textNumber.getText();//this gets the number

        //Then it will just validate if the reference number exists and then just show a summary
        if (bookSummaries.containsKey(refNumber)) {
            String summary = bookSummaries.get(refNumber);
            //Opens a window with the summary of the book 
            JOptionPane.showMessageDialog(null, summary, "Book Summaries", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //if its not there, show an error message to the user
            JOptionPane.showMessageDialog(null, "No summary found for the given reference number.", "Error", JOptionPane.ERROR_MESSAGE);
        }  
        //in case the user doesnt click the find button, and goes straight to the summary, 
        //this function here will just update the book text field with whatever 
        //the current input of the number is
        btnSearch.doClick();
    }//GEN-LAST:event_btnSummaryActionPerformed

    private void btnRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRateActionPerformed
        // TODO add your handling code here:
        String refNumber = textNumber.getText(); // Assuming textNumber is the field for reference number
String ratingInput = textRating.getText(); // Assuming textRating is the field for user input rating

try {
    //This will validate the rating input
    int rating = Integer.parseInt(ratingInput);
    if (rating < 1 || rating > 5) {
        //this makes sure its between the valid range
        throw new NumberFormatException("Rating must be between 1 and 5.");
    }

    // Then it will check if the book exists using the reference number
    boolean bookExists = false; // Initialize a flag for the book being there or not
    //Now loop through the array of books
    for (String[] book : books) { 
    if (book[0].equals(refNumber)) { //this checks if the reference number matches
        bookExists = true; //This will happen if the book is found
        break; // Then just exit the loop
    }
}


  //this just checks if the book exists or not
    if (!bookExists) {
        // If the book does not exist, tell the user
        JOptionPane.showMessageDialog(null, "Book not found! Please find a book first before adding a rating.");
        return; //Then just exit the method to prevent adding the rating
    }

    //This will call the method to add the rating to the book if it exists
    addRating(refNumber, rating);
    //Make sure user knows its been added
    JOptionPane.showMessageDialog(null, "Rating added successfully!");

} catch (NumberFormatException ex) {
    // If not, show error message for invalid input to the user
    JOptionPane.showMessageDialog(null, "Invalid! Please enter a number between 1 and 5.");
}
btnSearch.doClick();//update the text fields incase user goes straight to rating
resetFieldBorders();//make the border colors reset to original 
    }//GEN-LAST:event_btnRateActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        

    //This will just create a stringBuilder to collect the ratings information
    StringBuilder ratingsInfo = new StringBuilder("Book Ratings:\n\n");

    //Then it will loop through each entry in the bookRatings HashMap
    for (String refNumber : bookRatings.keySet()) {
        //Then this function will get the list of ratings for the current book the
        //user has inputted
        List<Integer> ratings = bookRatings.get(refNumber);

        // If there are ratings, this will basically append the book reference
        //number and ratings to the whole stringbuilder
        //this also checks if the list is empty
        if (!ratings.isEmpty()) {
            ratingsInfo.append("Book Ref ").append(refNumber).append(": ")
                        .append(ratings.toString()).append("\n");
        } else {
            // If there are no ratings found, tell the user that all well by putting
            //the message beside all the reference numbers
            ratingsInfo.append("Book Ref ").append(refNumber).append(": No ratings yet.\n");
        }
    }

    //This will then display all the ratings for every title in a window 
    JOptionPane.showMessageDialog(this, ratingsInfo.toString(), "All Ratings", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        //this will just be easier for users to clear the fields of input
        //it will clear all the fields for the follow textfields being the
        //linear field, binary field, reference number input field and also the 
        //rating field as well
        textNumber.setText("");
        textRating.setText("");
        textLinear.setText("");
        textBinary.setText("");   
         resetFieldBorders();//resets the field borders
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestActionPerformed
        // TODO add your handling code here:

// this will just initialize variables to track the best book and its average rating
List<String> bestBooksRefs = new ArrayList<>(); // a list to store reference numbers of the best books
double highestAverage = 0.0; // this is the highest average rating found of the books
boolean hasRatings = false; // we set a flag to check if any ratings exist basically

// Then it will just loop through each entry in the bookRatings HashMap basically
for (String refNumber : bookRatings.keySet()) {
    // It will then get the list of ratings for the current book
    List<Integer> ratings = bookRatings.get(refNumber);

    // If there are ratings for the current book, just calculate the average
    if (!ratings.isEmpty()) { // checks if its empty or not
        hasRatings = true; // then just set flag to true since we have ratings

        // This will calculate the average rating
        double averageRating = ratings.stream()
            .mapToInt(Integer::intValue) // Convert List<Integer> to IntStream
            .average() // then just calculate the average
            .orElse(0.0); // if there aren't any ratings go to 0.0

        // then this will check if this average is higher than the highest found so far
        if (averageRating > highestAverage) { // if it is,
            highestAverage = averageRating; // just update the highest average
            bestBooksRefs.clear(); // Clear the list of best books
            bestBooksRefs.add(refNumber); // then add the new best book reference number
        } else if (averageRating == highestAverage) { // If this rating matches the highest found
            bestBooksRefs.add(refNumber); // Add this book reference number to the list
        }
    }
}

// this function will check if any ratings were found and display it to the user
if (hasRatings) {
    // Prepare the result string to display all best rated books
    StringBuilder resultMessage = new StringBuilder("Best Rated Books:\n");

    for (String bestBookRef : bestBooksRefs) {
        // this gets the title of the best rated book using the reference number
        String bestBookTitle = getBookTitle(bestBookRef); // this gets the title

        //this just add's each book's details to the result message
        resultMessage.append("Title: ").append(bestBookTitle) // best book title
            .append("\nReference Number: ").append(bestBookRef) // the reference number
            .append("\nAverage Rating: ").append(highestAverage).append("\n\n"); // the average rating of it
    }

    // Show user the best book(s) details
    JOptionPane.showMessageDialog(this,
        resultMessage.toString(), 
        "Best Seller", 
        JOptionPane.INFORMATION_MESSAGE);
} else {
    // If no ratings were found, tell the user and show message that there's 
    // no ratings yet
    JOptionPane.showMessageDialog(this, 
        "No ratings added yet.", 
        "Best Seller", 
        JOptionPane.INFORMATION_MESSAGE);
    }
}

//now this is the method to get the book title by reference number
private String getBookTitle(String refNumber) {
    //this will loop through the books array to find the title that's matching the reference number
    for (String[] book : books) {
        if (book[0].equals(refNumber)) { // this compares the reference number
            return book[1]; //just simply return the title
        }
    }
    return "No Title"; //in case no title is found, say this
    }//GEN-LAST:event_btnBestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBest;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSummary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField textBinary;
    private javax.swing.JTextField textLinear;
    private javax.swing.JTextField textNumber;
    private javax.swing.JTextField textRating;
    // End of variables declaration//GEN-END:variables
}
