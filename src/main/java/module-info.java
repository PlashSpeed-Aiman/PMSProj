module com.pms.pmsproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.pms.pmsproj;
    opens com.pms.pmsproj to javafx.fxml, com.google.gson;
    exports com.pms.pmsproj.Controller;
    opens com.pms.pmsproj.Controller to javafx.fxml;
    exports com.pms.pmsproj.Controller.VisitorController;
    opens com.pms.pmsproj.Controller.VisitorController to javafx.fxml;
    exports com.pms.pmsproj.Controller.GuardController;
    opens com.pms.pmsproj.Controller.GuardController to javafx.fxml;
    exports com.pms.pmsproj.Controller.VendorController;
    opens com.pms.pmsproj.Controller.VendorController to javafx.fxml;
    exports com.pms.pmsproj.Controller.AdminController;
    opens com.pms.pmsproj.Controller.AdminController to javafx.fxml;
    opens com.pms.pmsproj.Model.FinanceRecord to com.google.gson;
    exports com.pms.pmsproj.Controller.ResidentController;
    opens  com.pms.pmsproj.Controller.ResidentController to javafx.fxml;
    exports com.pms.pmsproj.Controller.ManagerController;
    opens  com.pms.pmsproj.Controller.ManagerController to javafx.fxml;
    exports com.pms.pmsproj.Controller.AccountsController;
    opens  com.pms.pmsproj.Controller.AccountsController to javafx.fxml;
    exports com.pms.pmsproj.Controller.BuildingExecController;
    opens  com.pms.pmsproj.Controller.BuildingExecController to javafx.fxml;
    opens com.pms.pmsproj.Model.Complaints to com.google.gson;

}