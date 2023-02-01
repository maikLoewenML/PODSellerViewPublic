package com.example.podsellerview3.mba;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

@Entity
@Getter
public class MBA {
    @Getter(AccessLevel.NONE)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String email;
    private String password;

    public static WebDriver driver;
    private static int amountOfSales;

    public void setId(UUID id) {
        this.id = id;
    }

    public MBA() {
        this.id = UUID.randomUUID();
        this.email = null;
        this.password = null;
    }

    public MBA(String email, String password) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
    }

    /**
     * zuerst wird über Selenium Chromedriver die richtige Auswahl angeklickt
     * danach wird über einen WebScraper die richtigen Daten ausgelesen
     */


    /**
     * setting property for the ChromeDriver with providing path of chromedriver.exe
     * Selenium ChromeDriver object is created, it will open the chrome browser window
     */

}
