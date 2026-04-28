package university.models.research;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ResearchPaper implements Comparable<ResearchPaper> {

    private String doi;
    private String title;
    private List<String> authors;
    private String journal;
    private LocalDate datePublished;
    private int citations;
    private int pageStart;
    private int pageEnd;
    private String abstractText;
    private String keywords;

    public ResearchPaper(String doi, String title, List<String> authors, String journal,
                         LocalDate datePublished, int citations, int pageStart, int pageEnd,
                         String abstractText, String keywords) {
        this.doi = doi;
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.datePublished = datePublished;
        this.citations = citations;
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
        this.abstractText = abstractText;
        this.keywords = keywords;
    }

    public int getLength() { return pageEnd - pageStart + 1; }

    public static Comparator<ResearchPaper> BY_DATE =
            Comparator.comparing(ResearchPaper::getDatePublished);

    public static Comparator<ResearchPaper> BY_CITATIONS =
            Comparator.comparingInt(ResearchPaper::getCitations).reversed();

    public static Comparator<ResearchPaper> BY_LENGTH =
            Comparator.comparingInt(ResearchPaper::getLength);

    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(other.citations, this.citations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchPaper)) return false;
        return Objects.equals(doi, ((ResearchPaper) o).doi);
    }

    @Override public int hashCode() { return Objects.hash(doi); }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + authors + " | " + journal
                + " | " + datePublished + " | citations: " + citations;
    }

    public String getDoi() { return doi; }
    public String getTitle() { return title; }
    public List<String> getAuthors() { return authors; }
    public String getJournal() { return journal; }
    public LocalDate getDatePublished() { return datePublished; }
    public int getCitations() { return citations; }
    public int getPageStart() { return pageStart; }
    public int getPageEnd() { return pageEnd; }
    public String getAbstractText() { return abstractText; }
    public String getKeywords() { return keywords; }
    public void setCitations(int citations) { this.citations = citations; }
}
