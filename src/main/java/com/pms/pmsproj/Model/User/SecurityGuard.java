package com.pms.pmsproj.Model.User;

import com.pms.pmsproj.Model.Checkpoint.Checkpoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SecurityGuard extends User {
    private ObservableList<Checkpoint> checkpoints;

    public ObservableList<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(ObservableList<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public SecurityGuard(){
        checkpoints = FXCollections.observableArrayList();
    }
}
