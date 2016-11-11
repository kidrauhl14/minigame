package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable{
    @FXML
    public Button start;
    public AnchorPane Pane;
    public Label print;
    public Label scan;
    public int score = 0;
    public int k = 0;

    ArrayList<String> words;


    public String reversewords[] = {"doof", "eikooc", "elppa", "nep", "olleh", "traeh", "rats", "eseehc", "azzip", "nekcihc"};

    TextField input = new TextField();
    Scanner scanner = new Scanner(System.in);

    public ImageView iv1 = new ImageView();
    public ImageView iv2 = new ImageView();

    public Label scores;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        print.setVisible(false);
        scan.setVisible(false);

       addWords();

        scores = new Label();

        //start.setFont(Font.font("ENDOMCA", 30));

        start.setOnMouseClicked(event -> {
            Pane.getChildren().remove(start);
            print.setVisible(true);
            scan.setVisible(true);
            print.setText(reversewords[k++]);
            scan.setText("입력 : ");

            Pane.getChildren().add(input);
            input.setEditable(true);
            input.setText(" ");
            input.setLayoutX(400);
            input.setLayoutY(200);
            input.requestFocus();
        });

        input.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                Pane.getChildren().remove(iv1);
                Pane.getChildren().remove(iv2);
                //System.out.println("엔터!");
                String inputText = input.getText().toString().replace(" ", "");
                StringBuffer o_word = new StringBuffer(reversewords[k-1]);

                final Image correct = new Image("o.jpg");
                final Image bbik = new Image("x.jpg");
                iv1.setImage(correct);
                iv2.setImage(bbik);

//                scores.setLayoutX(400);
//                scores.setLayoutY(10);
//                scores.setText(" ");
//                Pane.getChildren().add(scores);

                if(inputText.equals(o_word.reverse().toString()) == true) {
                    //같을 때
                    print.setText(reversewords[k++]);
                    iv1.setX(355);
                    Pane.getChildren().add(iv1);
                    //System.out.print("정답");
//                    score++;
                }
                else {
                    //System.out.print("오답");
                    Pane.getChildren().add(iv2);
                }

                input.setText("");

//                scores.setText(score*10000+"점");



            }
        });
    }

    public void addWords (){ // 배열에 있는 단어 리스트에 추가
        words = new ArrayList<>();
        for(int i=0; i<reversewords.length; i++){
            words.add(i, reversewords[i]);
        }
    }
}
//점수, 사진위치, bgm, 끝났을때