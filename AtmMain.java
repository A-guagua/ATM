package com.ATM;

import java.util.Scanner;
public class AtmMain {

    private static String cardid;
    private static String cardpwd;
    private static CustomerService customerService;

    public static void main(String[] args) {
        customerService = new CustomerService();
        // 测试 客户类的 数据   // 作业1: 对 manager管理类 做出  单例模式. 并测试 是否数据初始了.
        //CustomerData customerData = CustomerData.getInstance();
        //List<Customer> customerList = customerData.getCustomerList();
        TextUitl.Login();
        int i = 0;
        while (i < 6) {
            doWritePassword();
            doCheckPassword(cardid, cardpwd);
            i++;
        }
    }

    // 判断角色 和 判断密码
    private static void doCheckPassword(String cardid, String cardpwd) {

        if (cardid.length() == 8) {
            customerService.checkPwd(cardid,cardpwd);
        }
    }

    private static void doWritePassword() {

        System.out.println("请输入卡号");
        Scanner scanner = new Scanner(System.in);
        cardid = scanner.nextLine();
        System.out.println("cardid = " + cardid);
        System.out.println("请输入密码");
        cardpwd = scanner.nextLine();
        System.out.println("cardPwd = " + cardpwd);
    }
}
