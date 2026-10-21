package theatricalplays;

public class ComedyCalculator extends PerformanceCalculator {

    public ComedyCalculator(Performance perf) {
        super(perf);
    }

    @Override
    public int amount() {
        int amount = 30000;
        if (performance.audience > 20) {
            amount += 10000 + 500 * (performance.audience - 20);
        }

        amount += 300 * performance.audience;

        return amount;
    }

    // Uses the parent function's volumeCredits but adds the special comedy bonus
    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (performance.audience / 5);
    }

}
