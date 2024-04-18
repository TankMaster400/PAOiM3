package com.example.paoim3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
public class Controller implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TableColumn<ClassEmployee, String> Nazwa_g;
    @FXML
    private TableColumn<ClassEmployee, String> zapelnienie;
    @FXML
    private TableColumn<Employee, String> imie;
    @FXML
    private TableColumn<Employee, String> nazwisko;
    @FXML
    private TableColumn<Employee, EmployeeCondition> stan;
    @FXML
    private TableView<ClassEmployee> table1;
    @FXML
    private TableView<Employee> table2;
    @FXML
    private TableColumn<Employee, Double> wyplata;
    @FXML
    private TableColumn<Employee, Integer> rok;
    @FXML
    private TextField imie_d;
    @FXML
    private TextField max;
    @FXML
    private TextField nazwa;
    @FXML
    private TextField nazwisko_d;
    @FXML
    private TextField rok_d;
    @FXML
    private ChoiceBox<EmployeeCondition> stan_d;
    @FXML
    private TextField wyplata_d;
    @FXML
    private TextField szukaj;

    ObservableList<ClassEmployee> list1 = FXCollections.observableArrayList
            (
                    new ClassEmployee("Gr1", 4),
                    new ClassEmployee("Gr2", 5.),
                    new ClassEmployee("Gr3", 4.),
                    new ClassEmployee("Gr4", 6.)

            );

    Employee Pracownik1 = new Employee("Wojciech", "Zub",EmployeeCondition.obecny ,2002,2500.);
    Employee Pracownik2 = new Employee("Wojciech", "Zubik",EmployeeCondition.obecny ,2001,2500.);
    Employee Pracownik3 = new Employee("Adam", "Kowal",EmployeeCondition.obecny ,2001,3500.);
    Employee Pracownik4 = new Employee("Karol", "Kozubek",EmployeeCondition.obecny ,2001,2400.);
    Employee Pracownik5 = new Employee("Wojciech", "Malanowski" ,EmployeeCondition.obecny ,2001,2500.);
    ObservableList<Employee> listk = FXCollections.observableArrayList();
    int pam;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        table1.setEditable(true);
        table2.setEditable(true);

        stan_d.setItems(FXCollections.observableArrayList( EmployeeCondition.values()));

        list1.get(0).lista_pracownikow.add(Pracownik1);
        list1.get(1).lista_pracownikow.add(Pracownik2);
        list1.get(1).lista_pracownikow.add(Pracownik3);
        list1.get(2).lista_pracownikow.add(Pracownik4);
        list1.get(2).lista_pracownikow.add(Pracownik5);

        list1.get(0).setZapelnienie();
        list1.get(1).setZapelnienie();
        list1.get(2).setZapelnienie();
        list1.get(3).setZapelnienie();

        Nazwa_g.setCellValueFactory(new PropertyValueFactory<ClassEmployee,String>("nazwa_grupy"));
        Nazwa_g.setCellFactory(TextFieldTableCell.forTableColumn());
        Nazwa_g.setOnEditCommit(new EventHandler<CellEditEvent<ClassEmployee,String>>() {
                                    @Override
                                    public void handle(CellEditEvent<ClassEmployee, String> event) {
                                                ClassEmployee gr = event.getRowValue();
                                                gr.setNazwa_grupy(event.getNewValue());
                                    }
                                }
        );
        zapelnienie.setCellValueFactory(new PropertyValueFactory<ClassEmployee,String>("zapelnienie"));
        zapelnienie.setCellFactory(TextFieldTableCell.forTableColumn());
        zapelnienie.setOnEditCommit(new EventHandler<CellEditEvent<ClassEmployee,String>>() {
                                    @Override
                                    public void handle(CellEditEvent<ClassEmployee, String> event) {
                                        ClassEmployee gr = event.getRowValue();
                                        double wart;
                                        wart = Double.valueOf(event.getNewValue());
                                        gr.setMax_p(wart);
                                        list1.get(table1.getSelectionModel().getSelectedIndex()).setMax_p(wart);
                                        list1.get(table1.getSelectionModel().getSelectedIndex()).setZapelnienie();
                                        table1.refresh();
                                    }
                                }
        );

        table1.setItems(list1);

        imie.setCellValueFactory(new PropertyValueFactory<Employee,String>("imie"));
        imie.setCellFactory(TextFieldTableCell.forTableColumn());
        imie.setOnEditCommit(new EventHandler<CellEditEvent<Employee,String>>() {
                                    @Override
                                    public void handle(CellEditEvent<Employee, String> event) {
                                        Employee prac = event.getRowValue();
                                        prac.setImie(event.getNewValue());
                                    }
                                }
        );
        nazwisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("nazwisko"));
        nazwisko.setCellFactory(TextFieldTableCell.forTableColumn());
        nazwisko.setOnEditCommit(new EventHandler<CellEditEvent<Employee,String>>() {
                                 @Override
                                 public void handle(CellEditEvent<Employee, String> event) {
                                     Employee prac = event.getRowValue();
                                     prac.setNazwisko(event.getNewValue());
                                 }
                             }
        );
        stan.setCellValueFactory(new PropertyValueFactory<>("stan_pracownika"));
        stan.setCellFactory(ChoiceBoxTableCell.forTableColumn(EmployeeCondition.values()));
        stan.setOnEditCommit(new EventHandler<CellEditEvent<Employee,EmployeeCondition>>() {
                                    @Override
                                    public void handle(CellEditEvent<Employee, EmployeeCondition> event) {
                                        Employee prac = event.getRowValue();
                                        prac.setStan_pracownika(event.getNewValue());
                                    }
                                }
        );
        wyplata.setCellValueFactory(new PropertyValueFactory<Employee,Double>("wynagrodzenie"));
        wyplata.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        wyplata.setOnEditCommit(new EventHandler<CellEditEvent<Employee,Double>>() {
                                     @Override
                                     public void handle(CellEditEvent<Employee, Double> event) {
                                         Employee prac = event.getRowValue();
                                         prac.setWynagrodzenie(event.getNewValue());
                                     }
                                 }
        );
        rok.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("rok_urodzenia"));
        rok.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        rok.setOnEditCommit(new EventHandler<CellEditEvent<Employee,Integer>>() {
                                    @Override
                                    public void handle(CellEditEvent<Employee, Integer> event) {
                                        Employee prac = event.getRowValue();
                                        prac.setRok_urodzenia(event.getNewValue());
                                    }
                                }
        );

        szukaj.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                ObservableList<Employee> list_sz = FXCollections.observableArrayList();
                if(keyEvent.getCode().equals(KeyCode.ENTER)) {
                    for (int j = 0; j < list1.size(); j++) {
                        for (int i = 0; i < list1.get(j).lista_pracownikow.size(); i++) {

                            if (list1.get(j).lista_pracownikow.get(i).compareTo(szukaj.getText()) == 0)
                            {
                                list_sz.add(list1.get(j).lista_pracownikow.get(i));
                            }
                        }
                        table2.setItems(list_sz);
                    }
                }
            }
        });

    }

    @FXML
    private void infoButton(ActionEvent event)
    {
        table2.setItems(list1.get(table1.getSelectionModel().getSelectedIndex()).lista_pracownikow);
        pam = table1.getSelectionModel().getSelectedIndex();
    }
    @FXML
    private void delButton1(ActionEvent event)
    {
        table1.getItems().removeAll(table1.getSelectionModel().getSelectedItem());

    }
    @FXML
    private void delButton2(ActionEvent event)
    {
        list1.get(pam).removeEmployee(table2.getSelectionModel().getSelectedItem());
        table1.refresh();

    }
    @FXML
    private void addgr(ActionEvent event)
    {
        list1.add(new ClassEmployee(nazwa.getText(),Double.parseDouble(max.getText())));
        table1.refresh();
        nazwa.clear();
        max.clear();
    }
   @FXML
    private void addpr(ActionEvent event)
    {
        list1.get(pam).addEmployee(new Employee(imie_d.getText(), nazwisko_d.getText() , stan_d.getValue(),Integer.parseInt(rok_d.getText()), Double.parseDouble(wyplata_d.getText())));
        table1.refresh();
        imie_d.clear();
        nazwisko_d.clear();
        wyplata_d.clear();
        rok_d.clear();
    }
}