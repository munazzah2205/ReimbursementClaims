package com.example.reimbursementclaims;

public class MyList1 {
    private int page;
    private String claim2;
    private String november10;
    private int cut;

    public MyList1(int page,String claim2, String november10,int cut) {
        this.page = page;
        this.claim2 = claim2;
        this.november10 = november10;
        this.cut = cut;

    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getClaim2()
    {
        return claim2;
    }

    public void setClaim2(String claim2) {
        this.claim2 = claim2;
    }

    public String getNovember10() {
        return november10;
    }

    public void setNovember10(String november10) {
        this.november10 = november10;
    }
    public int getCut() {
        return cut;
    }

    public void setCut(int cut) {
        this.cut = cut;
    }

}
