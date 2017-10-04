package com.sda.dto;

import sun.util.resources.LocaleData;

import javax.validation.constraints.NotNull;

public class UserDTO {

    @NotNull
    private String uuid;

    @NotNull
    private String username;

    public UserDTO(){}

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
