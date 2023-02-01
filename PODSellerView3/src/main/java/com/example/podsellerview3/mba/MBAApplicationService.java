package com.example.podsellerview3.mba;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MBAApplicationService {

    public static WebDriver driver;
    private static int amountOfSales;

    private MBARepository mbaRepository;

    @Autowired
    public MBAApplicationService(MBARepository mbaRepository) {
        this.mbaRepository = mbaRepository;
    }

    public static void main(String[] args) throws InterruptedException {
        //BasicConfigurator.configure();
        //MBAApplicationService runnable = new MBAApplicationService(mbaRepository);
        //runnable.chromeDriverSetUp();
        //runnable.login();
        //TimeUnit.SECONDS.sleep(5);
        //amountOfSales = runnable.getSalesAmount();
        //getUSD();

        /**
         final String url = "https://merch.amazon.com/analyze/earnings";

         try {
         final Document document = Jsoup.connect(url).get();
         for ( Element row : document.select( "table.table tr" ) ) {
         if ( row.getElementById("record-0-gross") != null ) {
         System.out.println("gefunden");
         }
         else System.out.println("nicht gefunden");
         }
         }
         catch ( Exception e ) {
         System.out.println("hat gar nicht funktioniert");
         e.printStackTrace();
         }
         */
    }

    public void saveLogin(String email, String password, MBARepository mbaRepository) {
        MBA mba = new MBA(email, password);
        mbaRepository.save(mba);
    }

    public void chromeDriverSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void login() {

        //String email = amazonMerchOnDemandRepository.findAll().toString();
        //System.out.println("Email: " + email);
        //String password = amazonMerchOnDemandRepository.findAll().toString();
        //System.out.println("Password: " + password);

        driver.get("https://merch.amazon.com/dashboard");
        Actions emailEntryAmazon = new Actions(driver).sendKeys("");
        emailEntryAmazon.perform();
        Actions jumpToPasswordEntry = new Actions(driver).keyDown(Keys.TAB);
        jumpToPasswordEntry.perform();
        Actions passwordEntry = new Actions(driver).sendKeys("");
        passwordEntry.perform();
        Actions enter = new Actions(driver).keyDown(Keys.ENTER);
        enter.perform();
    }

    public int getSalesAmount() throws InterruptedException {
        int amountOfSales = 0;
        driver.findElement(By.linkText("Analysieren")).click();

        TimeUnit.SECONDS.sleep(4);

        int salesAmountUSA = Integer.parseInt(driver.findElement(By.id("currency-summary-sold-USD")).getText());
        int salesAmountUK = Integer.parseInt(driver.findElement(By.id("currency-summary-sold-GBP")).getText());
        int salesAmountEUR = Integer.parseInt(driver.findElement(By.id("currency-summary-sold-EUR")).getText());
        int salesAmountJP = Integer.parseInt(driver.findElement(By.id("currency-summary-sold-JPY")).getText());

        amountOfSales = salesAmountUSA + salesAmountUK + salesAmountEUR + salesAmountJP;
        System.out.println(amountOfSales);
        return amountOfSales;
    }

    private static int allCurrenciesIntoEuro() {
        int usd = getUSD();
        return 0;
    }

    private static int getUSD() {
        return Integer.parseInt(driver.findElement(By.id("currency-summary-royalties-USD")).getText());
    }

    private static int getGBP() {
        return Integer.parseInt(driver.findElement(By.id("currency-summary-royalties-UK")).getText());
    }

    private static int getEUR() {
        return Integer.parseInt(driver.findElement(By.id("currency-summary-royalties-EUR")).getText());
    }

    private static int getJPY() {
        return Integer.parseInt(driver.findElement(By.id("currency-summary-royalties-JPY")).getText());
    }
}

