package com.example.test1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController extends Passenger {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        main();
    }
    @FXML
    protected void button()  throws IOException {
        String copy = "";
        for (int i = 0; i < waiting.length; i++){
            if(waiting[i].getFirstName()=="firstName"){
                copy = ("Empty space :"+(i+1));
            }else
                copy = copy+((i+1)+" : "+ waiting[i].getFirstName());
        }

        welcomeText.setText(copy);
    }
    @FXML
    protected void viewAllFuelQueues() throws IOException{

        welcomeText.setText("");
        String copy = "";
        welcomeText.setText("Queue 1");
        for (int i = 0; i < array1.length; i++){
            if(array1[i].getFirstName()=="firstName"){
                copy = copy+("Empty space :"+(i+1)+"\n");
            }else
                copy = copy+((i+1)+" : "+ array1[i].getFirstName()+"\n");
        }

        copy=copy+"\n";
        welcomeText.setText(copy);
        welcomeText.setText("");

        welcomeText.setText("Queue 2");
        for (int i = 0; i < array2.length; i++){
            if(array2[i].getFirstName()=="firstName"){
                copy = copy+("Empty space :"+(i+1)+"\n");
            }else
                copy = copy+((i+1)+" : "+ array2[i].getFirstName()+"\n");
        }

        copy=copy+"\n";
        welcomeText.setText(copy);
        welcomeText.setText("");

        welcomeText.setText("Queue 3");
        for (int i = 0; i < array3.length; i++){
            if(array3[i].getFirstName()=="firstName"){
                copy = copy+("Empty space :"+(i+1)+"\n");
            }else
                copy = copy+((i+1)+" : "+ array3[i].getFirstName()+"\n");
        }

        copy=copy+"\n";
        welcomeText.setText(copy);
        welcomeText.setText("");

        welcomeText.setText("Queue 4");
        for (int i = 0; i < array4.length; i++){
            if(array4[i].getFirstName()=="firstName"){
                copy = copy +("Empty space :"+(i+1)+"\n");
            }else
                copy = copy+((i+1)+" : "+ array4[i].getFirstName()+"\n");
        }

        copy=copy+"\n";
        welcomeText.setText(copy);
        welcomeText.setText("");
        welcomeText.setText("Queue 5");
        for (int i = 0; i < array5.length; i++){
            if(array5[i].getFirstName()=="firstName"){
                copy = copy+("Empty space :"+(i+1)+"\n");
            }else
                copy = copy+((i+1)+" : "+ array5[i].getFirstName()+"\n");
        }

        copy=copy+"\n";
        welcomeText.setText(copy);


    }
}