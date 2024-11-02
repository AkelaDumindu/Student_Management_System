package lk.akeladumindu.lms.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.akeladumindu.lms.bo.BoFactory;
import lk.akeladumindu.lms.bo.custom.StudentBo;
import lk.akeladumindu.lms.dto.StudentDto;
import lk.akeladumindu.lms.view.tm.StudentTm;
import java.util.Optional;
import javafx.scene.control.Button;




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
            deleteButton.setStyle("-fx-background-color: #c0392b");
            Button seeMorButton = new Button("See More");
            seeMorButton.setStyle("-fx-background-color: #2980b9");

            StudentTm tm = new StudentTm(dto.getId(), dto.getName(), dto.getContact(), deleteButton ,seeMorButton);
            tmList.add(tm);

            deleteButton.setOnAction(e->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> selectedButtonData = alert.showAndWait();
                if (selectedButtonData.get().equals(ButtonType.YES)){
                    try{
                        studentBo.deleteStudentById(tm.getId());
                        new Alert(Alert.AlertType.INFORMATION, "Student Deleted").show();
                        loadAllStudents();
                    }catch (Exception exception){
                        new Alert(Alert.AlertType.ERROR, "Try Again").show();
                    }
                }
            });
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
            loadAllStudents();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Try Again!").show();
        }
    }




}
