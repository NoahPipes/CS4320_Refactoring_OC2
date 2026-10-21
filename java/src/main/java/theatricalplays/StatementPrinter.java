package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = String.format("Statement for %s%n", invoice.customer);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);

            PerformanceCalculator calculator = PerformanceCalculator.create(perf, play);
            
            int thisAmount = calculator.amount();
            volumeCredits += calculator.volumeCredits();

            
            // print line for this order
            result += String.format("  %s: %s (%s seats)%n", play.name, frmt.format(thisAmount / 100), perf.audience);
            totalAmount += thisAmount;
        }
        result += String.format("Amount owed is %s%n", frmt.format(totalAmount / 100));
        result += String.format("You earned %s credits%n", volumeCredits);
        return result;
    }

}
