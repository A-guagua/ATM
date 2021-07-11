package com.ATM;

public class Manager {
    private  String account,password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
