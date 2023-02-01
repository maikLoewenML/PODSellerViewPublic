module PODSellerView3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires spring.context;
    requires spring.beans;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.chrome_driver;
    requires spring.data.commons;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;


    opens com.example.podsellerview3 to javafx.fxml;
    exports com.example.podsellerview3;
}