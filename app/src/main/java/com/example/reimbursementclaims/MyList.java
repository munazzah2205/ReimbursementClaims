package com.example.reimbursementclaims;
import androidx.recyclerview.widget.RecyclerView;

public class MyList {
    private int cash;
    private String claim1;
    private String november17;
    private String money1;


    public MyList(int cash,String claim1, String november17,String money1) {
        this.cash = cash;
        this.claim1 = claim1;
        this.november17 = november17;
        this.money1 = money1;
    }
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getClaim1()
    {
        return claim1;
    }

    public void setClaim1(String claim1) {
        this.claim1 = claim1;
    }

    public String getNovember17() {
        return november17;
    }

    public void setNovember17(String november17) {
        this.november17 = november17;
    }

    public String getMoney1() {
        return money1;
    }

    public void setMoney1(String money) {
        this.money1 = money1;
    }
}