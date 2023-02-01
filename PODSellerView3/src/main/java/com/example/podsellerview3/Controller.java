package com.example.podsellerview3;

import com.example.podsellerview3.mba.MBAApplicationService;
import com.example.podsellerview3.mba.MBARepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@Service
@org.springframework.stereotype.Controller
public class Controller {

    //Integrationtest

    @FXML private Label mainSceneLabel;
    @FXML private Label loginsSceneLabel;
    @FXML private Label sellerSceneLabel;
    @FXML private TextField emailMBA;
    @FXML private PasswordField passwordMBA;
    @FXML private Label mbaAmountOfSales;
    /**
    @FXML private TextField emailSpreadshirt;
    @FXML private PasswordField passwordSpreadshirt;
    @FXML private TextField emailRedbubble;
    @FXML private PasswordField passwordRedbubble;
    @FXML private TextField emailSociety6;
    @FXML private PasswordField passwordSociety6;
    */
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MBAApplicationService mbaApplicationService;
    private MBARepository mbaRepository;

    @Autowired
    public Controller(MBAApplicationService mbaApplicationService, MBARepository mbaRepository) {
        this.mbaApplicationService = mbaApplicationService;
        this.mbaRepository = mbaRepository;
    }
    //private SpreadshirtRepository spreadshirtRepository;
    //private Society6Repository society6Repository;
    //private RedBubbleRepository redBubbleRepository;


    @FXML
    public void openLoginScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginsScene.fxml"));
        stage = (Stage)(mainSceneLabel.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void openMainScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("1_MainScene.fxml"));
        stage = (Stage)(loginsSceneLabel.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSellerViewScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SellerViewScene.fxml"));
        stage = (Stage)(mainSceneLabel.getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void saveLogins() {
        //Amazon
        String emailAmazon = emailMBA.getText();
        String passwordAmazon = passwordMBA.getText();
        mbaApplicationService = new MBAApplicationService(mbaRepository);
        mbaApplicationService.saveLogin(emailAmazon, passwordAmazon, mbaRepository);

        /**
        //Spreadshirt
        String emailStringSpreadshirt = emailSpreadshirt.getText();
        String passwordStringSpreadshirt = passwordMBA.getText();
        Spreadshirt spreadshirtLogin = new Spreadshirt(emailStringSpreadshirt, passwordStringSpreadshirt);
        spreadshirtRepository.save(spreadshirtLogin);

        //RedBubble
        String emailStringRedBubble = emailRedbubble.getText();
        String passwordStringRedbubble = passwordRedbubble.getText();
        RedBubble redBubbleLogin = new RedBubble(emailStringRedBubble, passwordStringRedbubble);
        redBubbleRepository.save(redBubbleLogin);

        //Society6
        String emailStringSociety6 = emailSociety6.getText();
        String passwordStringSociety6 = passwordSociety6.getText();
        Society6 society6Login = new Society6(emailStringSociety6, passwordStringSociety6);
        society6Repository.save(society6Login);
         */
    }

    public void checkAmazonSales() throws InterruptedException {
        mbaApplicationService = new MBAApplicationService(mbaRepository);
        mbaApplicationService.chromeDriverSetUp();
        mbaApplicationService.login();
        //mbaAmountOfSales = mbaApplicationService.getSalesAmount();
    }
}