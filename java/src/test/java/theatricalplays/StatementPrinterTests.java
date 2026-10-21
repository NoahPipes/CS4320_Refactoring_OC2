package theatricalplays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementPrinterTests {

    @Test
    void exampleStatement() {
        Map<String, Play> plays = Map.of(
                "hamlet",  new Play("Hamlet", "tragedy"),
                "as-like", new Play("As You Like It", "comedy"),
                "othello", new Play("Othello", "tragedy"));

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    @Test
    void statementWithNewPlayTypes() {
        Map<String, Play> plays = Map.of(
                "henry-v",  new Play("Henry V", "history"),
                "as-like", new Play("As You Like It", "pastoral"));

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Error error = Assertions.assertThrows(Error.class,
            () -> statementPrinter.print(invoice, plays));
        assertEquals("unknown type: history", error.getMessage());
    }

    // check what the final price for a tragedy play with fewer than 30 audience members is
    // it should be $400.00
    @Test
    void smallTragedyPlay() {
        Map<String, Play> plays = Map.of(
                "bob-dies", new Play("The Death of Bob", "tragedy"));

        Invoice invoice = new Invoice("SmallCo", List.of(
                new Performance("bob-dies", 21)));
        
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    // check what the final price for a tragedy play with exactly 31 audience members is
    // it should be $410.00
    @Test
    void exactTragedyPlay() {
        Map<String, Play> plays = Map.of(
                "ttyl", new Play("Talk to You Later", "tragedy"));

        Invoice invoice = new Invoice("SAG-AFTRA", List.of(
                new Performance("ttyl", 31)));
        
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    @Test
    void size20HistoricalPlay() {
        Map<String, Play> plays = Map.of(
                "george-washington", new Play("George Washington's Men", "historical"));

        Invoice invoice = new Invoice("Smithsonian", List.of(
                new Performance("george-washington", 20)));
        
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    @Test
    void size21HistoricalPlay() {
        Map<String, Play> plays = Map.of(
                "george-washington", new Play("George Washington's Men", "historical"));

        Invoice invoice = new Invoice("Smithsonian", List.of(
                new Performance("george-washington", 21)));
        
        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

}