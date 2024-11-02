package lk.akeladumindu.lms.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.akeladumindu.lms.bo.BoFactory;
import lk.akeladumindu.lms.bo.custom.StudentBo;
import lk.akeladumindu.lms.dto.StudentDto;

import java.sql.SQLException;

public class MainFormController {


    public TextField txtname;
    public TextField txtContact;

//    private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);
            private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);


            public void initialize() throws SQLException, ClassNotFoundException {
                loadAllStudents();
            }

    private void loadAllStudents() throws SQLException, ClassNotFoundException {
        System.out.println(studentBo.findAllStudent());
    }


    public void onActionSaveStudent(ActionEvent actionEvent) {

        StudentDto dto = new StudentDto();
        dto.setName(txtname.getText());
        dto.setContact(txtContact.getText());

        try{
            studentBo.saveStudent(dto);
            new Alert(Alert.AlertType.INFORMATION,"Student Saved!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Try Again!").show();
        }
    }


}
