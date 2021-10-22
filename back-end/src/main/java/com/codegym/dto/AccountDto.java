package com.codegym.dto;

import javax.validation.constraints.Size;

public class AccountDto {
    @Size(max = 30, message = "Khong qua 30 ky tu")
    private String username;
    @Size(max = 30, message = "Khong qua 30 ky tu")
    private String password;

    public AccountDto() {
    }

    public AccountDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
