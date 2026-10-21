package theatricalplays;

// This class handles creating multiple different calculators depending on what is needed
// This follows the abstract factory model

public abstract class PerformanceCalculator {

    protected final Performance performance;

    protected PerformanceCalculator(Performance performance) {
        this.performance = performance;
    }

    public abstract int amount();

    public int volumeCredits() {
        return Math.max(performance.audience - 30, 0);
    }

    // The only switch statement that we need

    public static PerformanceCalculator create(Performance perf, Play play) {
        switch (play.type) {
            case "tragedy": return new TragedyCalculator(perf);
            case "comedy": return new ComedyCalculator(perf);
            case "historical": return new HistoricalCalculator(perf);
            default: throw new Error("unknown type: %s".formatted(play.type));
        }
    }

}
