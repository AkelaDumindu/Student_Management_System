package lk.akeladumindu.lms.dto;

public class ProgramDto {

    private String title;

    private int credits;

    public ProgramDto() {
    }

    public ProgramDto(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
