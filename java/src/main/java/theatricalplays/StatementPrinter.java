package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    protected static String usd(int aNumber) {
        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
        return frmt.format(aNumber / 100);
    }

    public String print(Invoice invoice, Map<String, Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = String.format("Statement for %s%n", invoice.customer);

        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);

            PerformanceCalculator calculator = PerformanceCalculator.create(perf, play);
            
            int thisAmount = calculator.amount();
            volumeCredits += calculator.volumeCredits();

            
            // print line for this order
            result += String.format("  %s: %s (%s seats)%n", play.name, usd(thisAmount), perf.audience);
            totalAmount += thisAmount;
        }
        result += String.format("Amount owed is %s%n", usd(totalAmount));
        result += String.format("You earned %s credits%n", volumeCredits);
        return result;
    }

}
