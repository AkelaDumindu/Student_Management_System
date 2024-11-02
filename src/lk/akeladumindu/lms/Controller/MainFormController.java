package lk.akeladumindu.lms.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.akeladumindu.lms.bo.BoFactory;
import lk.akeladumindu.lms.bo.custom.StudentBo;
import lk.akeladumindu.lms.dto.StudentDto;
import lk.akeladumindu.lms.view.tm.StudentTm;

import java.awt.*;
import java.sql.SQLException;

public class MainFormController {


    public TextField txtname;
    public TextField txtContact;

//    private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);
            private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);
    public TableView<StudentTm> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colContactNumber;
    public TableColumn colDelete;
    public TableColumn colSeeMore;


    public void initialize() throws SQLException, ClassNotFoundException {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        colSeeMore.setCellValueFactory(new PropertyValueFactory<>("seeMoreBtn"));
                loadAllStudents();
            }

    private void loadAllStudents() throws SQLException, ClassNotFoundException {
        ObservableList<StudentTm> tmList = FXCollections.observableArrayList();

        for (StudentDto dto : studentBo.findAllStudent()){
            Button deleteButton = new Button("Delete");
//            deleteButton.setStyle("-fx-background-color:#c0392b");
            Button seeMoreButton = new Button("See More");
//            seeMoreButton.setStyle("-fx-background-color:#2980b9");

            StudentTm tm = new StudentTm(dto.getId(), dto.getName(), dto.getContact(), deleteButton,seeMoreButton);
            tmList.add(tm);
        }

        tblStudent.setItems(tmList);
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
