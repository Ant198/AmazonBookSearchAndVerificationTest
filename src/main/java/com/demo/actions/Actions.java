package com.demo.actions;

public class Actions {

    private static MainActions mainActions;

    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }
}