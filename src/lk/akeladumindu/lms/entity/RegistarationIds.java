package lk.akeladumindu.lms.entity;

import javax.persistence.EmbeddedId;
import java.io.Serializable;

public class RegistarationIds implements Serializable {

    @EmbeddedId
    private long studentId;

    private long programId;


}
