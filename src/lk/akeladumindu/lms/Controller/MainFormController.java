package lk.akeladumindu.lms.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.akeladumindu.lms.bo.BoFactory;
import lk.akeladumindu.lms.bo.custom.LaptopBo;
import lk.akeladumindu.lms.bo.custom.ProgramBo;
import lk.akeladumindu.lms.bo.custom.StudentBo;
import lk.akeladumindu.lms.dto.CreateLaptopDto;
import lk.akeladumindu.lms.dto.ProgramDto;
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
            private final LaptopBo laptopBo = BoFactory.getInstance().getBo(BoFactory.BoType.LAPTOP);
    public TableView<StudentTm> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colContactNumber;
    public TableColumn colDelete;
    public TableColumn colSeeMore;
    public Button btnStudentSave;
    public TextField txtBrandName;
    public TextField txtSearch;
    public Button btnLapSave;
    public TableView tblLaptop;
    public TableColumn colLapId;
    public TableColumn colLapName;
    public TableColumn colLapDelete;
    public ComboBox cmdStudent;
    public TextField txtLapSearch;
    public TextField txtProgramName;
    public TextField txtCredit;
    public TextField txtProgramSearch;
    public TableView tblStudent1;

//    private StudentTm selectedStudentTm;


    public void initialize() throws SQLException, ClassNotFoundException {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        colSeeMore.setCellValueFactory(new PropertyValueFactory<>("seeMoreBtn"));
                loadAllStudents();
                loadAllStudentsForLaptopSection();



        //------------------------Listener---------------------
        tblStudent.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        selectedStudentTm = newValue;
                        txtname.setText(newValue.getName());
                        txtContact.setText(newValue.getContent());
                        btnStudentSave.setText("Update Student");
                    }
                });
        //------------------------Listener---------------------


            }

    private void loadAllStudentsForLaptopSection() throws SQLException, ClassNotFoundException {
        ObservableList<Long> obList = FXCollections.observableArrayList();
        for (StudentDto dto:studentBo.findAllStudent()
        ) {
            obList.add(dto.getId());
        }
        cmdStudent.setItems(obList);
    }

    private StudentTm selectedStudentTm = null;

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


//    public void onActionSaveStudent(ActionEvent actionEvent) {
//
//
//        }
//        public void newStudentOnAction(ActionEvent actionEvent) {
//
//        }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        btnStudentSave.setText("Save Student");
        selectedStudentTm = null;
    }

    public void btnStudentSave(ActionEvent actionEvent) {
        StudentDto dto = new StudentDto();
        dto.setName(txtname.getText());
        dto.setContact(txtContact.getText());

        if (btnStudentSave.getText().equals("Update Student")) {
            if ( selectedStudentTm== null) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
                return;
            }
            try {
                dto.setId(selectedStudentTm.getId());
                studentBo.updateStudent(dto);
                new Alert(Alert.AlertType.INFORMATION, "Student Updated").show();
                selectedStudentTm = null;
                btnStudentSave.setText("Save Student");
                loadAllStudents();
                loadAllStudentsForLaptopSection();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }
        } else {
            try {
                studentBo.saveStudent(dto);
                new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
                loadAllStudents();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }}
    }

    public void btnLaptopSave(ActionEvent actionEvent) {

        try {
            laptopBo.saveLaptop(
                    new CreateLaptopDto(
                            (Long) cmdStudent.getValue(),
                            txtBrandName.getText()
                    )
            );
            new Alert(Alert.AlertType.INFORMATION, "Laptop Saved").show();
            loadAllLaptops();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }

    private void loadAllLaptops() {
        //imlementation
    }

    public void saveProgramOnAction(ActionEvent actionEvent) {
        try {
            ProgramBo.saveProgram(
                    new ProgramDto(
                            txtProgramName.getText(),
                            Integer.parseInt(txtCredit.getText())
                    )
            );
            new Alert(Alert.AlertType.INFORMATION, "Program Saved").show();
            loadAllPrograms();
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }

    private void loadAllPrograms() {
    }

    public void newProgramOnAction(ActionEvent actionEvent) {
    }
}



