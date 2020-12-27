package com.module.notification.notificationData;

public  enum Language{
    ARABIC("Arabic"),ENGLISH("English");
    private String name;
    private Language(String name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }


}
