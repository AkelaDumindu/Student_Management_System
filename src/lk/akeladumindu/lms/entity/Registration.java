package lk.akeladumindu.lms.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

public class Registration {

    @EmbeddedId
    private RegistarationIds registarationIds = new RegistarationIds();//should initialize the obeject

    @ManyToMany
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("programId")
    private Program program;

    private Date regDate;

    public Registration() {
    }

    public Registration(RegistarationIds registarationIds, Student student, Program program, Date regDate) {
        this.registarationIds = registarationIds;
        this.student = student;
        this.program = program;
        this.regDate = regDate;
    }

    public RegistarationIds getRegistarationIds() {
        return registarationIds;
    }

    public void setRegistarationIds(RegistarationIds registarationIds) {
        this.registarationIds = registarationIds;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
