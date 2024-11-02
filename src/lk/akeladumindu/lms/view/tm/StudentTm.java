package lk.akeladumindu.lms.view.tm;

import java.awt.*;

public class StudentTm {

    long id;
    String name;
    String content;
    Button deleteBtn;
    Button seeMoreBtn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public Button getSeeMoreBtn() {
        return seeMoreBtn;
    }

    public void setSeeMoreBtn(Button seeMoreBtn) {
        this.seeMoreBtn = seeMoreBtn;
    }

    public StudentTm() {
    }

    public StudentTm(long id, String name, String content, Button deleteBtn, Button seeMoreBtn) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.deleteBtn = deleteBtn;
        this.seeMoreBtn = seeMoreBtn;
    }
}
