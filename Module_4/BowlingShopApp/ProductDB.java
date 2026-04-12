/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

public class ProductDB {

    public static GenericQueue<Product> getProducts(String code) {

        GenericQueue<Product> products = new GenericQueue<>();

        if (code.equalsIgnoreCase("b")) {
            for (int i = 1; i <= 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B" + i);
                ball.setDescription("Bowling Ball " + i);
                ball.setPrice(100 + i * 10);
                ball.setColor("Color " + i);
                products.enqueue(ball);
            }
        } 
        else if (code.equalsIgnoreCase("s")) {
            for (int i = 1; i <= 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + i);
                shoe.setDescription("Shoe " + i);
                shoe.setPrice(50 + i * 5);
                shoe.setSize(8 + i);
                products.enqueue(shoe);
            }
        } 
        else if (code.equalsIgnoreCase("a")) {
            for (int i = 1; i <= 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A" + i);
                bag.setDescription("Bag " + i);
                bag.setPrice(30 + i * 10);
                bag.setType(i + " Ball");
                products.enqueue(bag);
            }
        }

        return products;
    }
}