package university.models.academic;

import java.util.Objects;

public class Mark implements Comparable<Mark> {

    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double total;

    public Mark(double firstAttestation, double secondAttestation, double finalExam) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
        this.total = firstAttestation + secondAttestation + finalExam;
    }

    public boolean isFailed() { return total < 50.0; }

    public double getGradePoint() {
        if (total >= 90) return 4.0;
        if (total >= 80) return 3.0;
        if (total >= 65) return 2.0;
        if (total >= 50) return 1.0;
        return 0.0;
    }

    public String getLetterGrade() {
        if (total >= 90) return "A";
        if (total >= 85) return "A-";
        if (total >= 80) return "B+";
        if (total >= 75) return "B";
        if (total >= 70) return "B-";
        if (total >= 65) return "C+";
        if (total >= 60) return "C";
        if (total >= 55) return "C-";
        if (total >= 50) return "D+";
        return "F";
    }

    @Override public int compareTo(Mark other) { return Double.compare(this.total, other.total); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        return Double.compare(((Mark) o).total, total) == 0;
    }

    @Override public int hashCode() { return Objects.hash(total); }

    @Override
    public String toString() {
        return "Mark{att1=" + firstAttestation + ", att2=" + secondAttestation
                + ", final=" + finalExam + ", total=" + total + " (" + getLetterGrade() + ")}";
    }

    public double getFirstAttestation() { return firstAttestation; }
    public double getSecondAttestation() { return secondAttestation; }
    public double getFinalExam() { return finalExam; }
    public double getTotal() { return total; }
}
