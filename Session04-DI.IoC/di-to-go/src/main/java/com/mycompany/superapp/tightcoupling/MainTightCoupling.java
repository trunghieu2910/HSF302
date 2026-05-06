package com.mycompany.superapp.tightcoupling;

public class MainTightCoupling {
    public static void main(String[] args) {
        // CLASS NÀY ĐÓNG VAI LÀ UI để gọi và điều khiển nưhuxng thăgf ở tằng dưới sau này tahy abnwgf web page
        UserService userService = new UserService();
        userService.regissterAccount(new Account());

    }
}
