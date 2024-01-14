package com.example.presentsss;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelloController {

    @FXML
    private ComboBox<String> manufacturerComboBox;
    @FXML
    private ComboBox<String> giftComboBox;
    @FXML
    private Label costLabel;
    @FXML
    private CheckBox regularCustomerCheckBox;

    private double cost = 1;

    private double temp = 1;
    private int ind = 0;

    @FXML
    private void handleCustomer() // постоянный клиент
    {
        boolean fulltime = regularCustomerCheckBox.isSelected();

        if(fulltime)
        {
            temp = 0.8;
            cost *= temp;
        }

        costLabel.setText(Double.toString(cost));
    }


    public void initialize() {
        List<String> fabriqueDetails = DBConnector.fabriqueList.stream()
                .map(fabrique -> fabrique.name)
                .collect(Collectors.toList());

        ObservableList<String> factoryNamesList = FXCollections.observableArrayList(fabriqueDetails);
        manufacturerComboBox.setItems(factoryNamesList);

        manufacturerComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                updateGiftComboBox(newValue));

        giftComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                updateLabelGift(newValue, oldValue, ind));
    }

    private void updateGiftComboBox(String selectedManufacturer) //обновление списка подарков под производителя
    {

        List<String> giftsNames = new ArrayList<>();
        int indexNew = 0;
        for(int i = 0; i < com.example.presentsss.DBConnector.count; i++)
        {
            if(Objects.equals(com.example.presentsss.DBConnector.fabriqueList.get(i).name, selectedManufacturer))
                indexNew = i;
        }
        ind = indexNew;

        for(int i = 0; i < DBConnector.fabriqueList.get(indexNew).giftsAmount; i++)
        {
            giftsNames.add(DBConnector.fabriqueList.get(indexNew).giftsList.get(i).getName());
        }

        ObservableList<String> updatedGiftOptions = FXCollections.observableArrayList(giftsNames);
        giftComboBox.setItems(updatedGiftOptions);
        cost = 0;
        costLabel.setText("0.0");
    }
    private void updateLabelGift(String selectedGift, String oldGift, int newIndex) // кого выбрал
    {
        if (cost != 0.0 || selectedGift == null)
        {
            for(int i = 0; i < DBConnector.fabriqueList.get(newIndex).giftsAmount; i++)
            {
                if(Objects.equals(DBConnector.fabriqueList.get(newIndex).giftsList.get(i).getName(), oldGift))
                    cost -= DBConnector.fabriqueList.get(newIndex).giftsList.get(i).getCost() * temp;
            }
        }
        for(int i = 0; i < DBConnector.fabriqueList.get(newIndex).giftsAmount; i++)
        {
            if(Objects.equals(DBConnector.fabriqueList.get(newIndex).giftsList.get(i).getName(), selectedGift))
                cost += DBConnector.fabriqueList.get(newIndex).giftsList.get(i).getCost() * temp;
        }

        costLabel.setText(Double.toString(cost));
    }
}