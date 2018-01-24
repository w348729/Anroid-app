package com.example.blade.template;

import java.util.Date;

/**
 * Created by Blade on 2018/1/3.
 */

public class OrderEntity {


    private int order_id;


    private int user_id;


    private String useraddress;


    private String usercompany;


    private String userunitnumber;


    private String recipentaddress;


    private String recipentcompany;


    private String recipentunitnumber;


    private String recipentname;


    private String recipentnumber;


    private transient String itempic;


    private String status;


    private Date ordertime;


    private Date bidtime;


    private Date expirytime;


    public int getOrder_id() {
        return order_id;
    }


    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUseraddress() {
        return useraddress;
    }


    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }


    public String getUsercompany() {
        return usercompany;
    }


    public void setUsercompany(String usercompany) {
        this.usercompany = usercompany;
    }


    public String getUserunitnumber() {
        return userunitnumber;
    }


    public void setUserunitnumber(String userunitnumber) {
        this.userunitnumber = userunitnumber;
    }


    public String getRecipentaddress() {
        return recipentaddress;
    }


    public void setRecipentaddress(String recipentaddress) {
        this.recipentaddress = recipentaddress;
    }


    public String getRecipentcompany() {
        return recipentcompany;
    }


    public void setRecipentcompany(String recipentcompany) {
        this.recipentcompany = recipentcompany;
    }


    public String getRecipentunitnumber() {
        return recipentunitnumber;
    }


    public void setRecipentunitnumber(String recipentunitnumber) {
        this.recipentunitnumber = recipentunitnumber;
    }


    public String getRecipentname() {
        return recipentname;
    }


    public void setRecipentname(String recipentname) {
        this.recipentname = recipentname;
    }


    public String getRecipentnumber() {
        return recipentnumber;
    }


    public void setRecipentnumber(String recipentnumber) {
        this.recipentnumber = recipentnumber;
    }


    public String getItempic() {
        return itempic;
    }


    public void setItempic(String itempic) {
        this.itempic = itempic;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Date getOrdertime() {
        return ordertime;
    }


    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }


    public Date getBidtime() {
        return bidtime;
    }


    public void setBidtime(Date bidtime) {
        this.bidtime = bidtime;
    }


    public Date getExpirytime() {
        return expirytime;
    }


    public void setExpirytime(Date expirytime) {
        this.expirytime = expirytime;
    }


}
