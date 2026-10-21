package theatricalplays;

public class HistoricalCalculator extends PerformanceCalculator {

    public HistoricalCalculator(Performance perf) {
        super(perf);
    }

    @Override
    public int amount() {
        int result = 50000;
        if (performance.audience > 20) {
            result += 1500 * (performance.audience - 20);
        }
        return result;
    }

    @Override
    public int volumeCredits() {
        return performance.audience / 5;
    }
}
