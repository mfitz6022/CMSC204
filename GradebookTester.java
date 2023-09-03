import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

    GradeBook book1;
    GradeBook book2;
    @BeforeEach
    void setUp() throws Exception 
    {
        book1 = new GradeBook(5);
        book2 = new GradeBook(5);
        book1.addScore(99.8);
        book1.addScore(78.5);
        book1.addScore(66.6);
        book2.addScore(80.1);
        book2.addScore(71.9);
        book2.addScore(20.5);
        book2.addScore(10.6);
    }

    @AfterEach
    void tearDown() throws Exception 
    {
        book1 = book2 = null;
    }

    @Test
    void testAddScore() 
    {
        assertTrue(book1.toString().equals("99.8 78.5 66.6"));
        assertTrue(book2.toString().equals("80.1 71.9 20.5 10.6"));
        assertEquals(3, book1.getScoreSize());
        assertEquals(4, book2.getScoreSize());
    }

    @Test
    void testSum() 
    {
        assertEquals(244.9, book1.sum());
        assertEquals(183.1, book2.sum());
    }

    @Test
    void testMinimum() 
    {
        assertEquals(66.6, book1.minimum());
        assertEquals(10.6, book2.minimum());
    }

    @Test
    void testFinalScore() 
    {
        assertEquals(178.3, book1.finalScore());
        assertEquals(172.5, book2.finalScore());
    }

    @Test
    void testGetScoreSize() 
    {
        assertEquals(3, book1.getScoreSize());
        assertEquals(4, book2.getScoreSize());
    }

    @Test
    void testToString() 
    {
        assertTrue(book1.toString().equals("99.8 78.5 66.6"));
        assertTrue(book2.toString().equals("80.1 71.9 20.5 10.6"));
    }

}