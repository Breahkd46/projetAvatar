module com.mycompany.projetavatar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projetavatar to javafx.fxml;
    exports com.mycompany.projetavatar;
}