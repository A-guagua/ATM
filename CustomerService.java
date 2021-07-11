package com.ATM;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;
    Scanner s =new Scanner(System.in);

    public void  checkPwd(String cardid, String  cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList  = customerData.getCustomerList();


        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                currentCustomer=  customer;

                System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全"   );
                TextUitl.oneLeveOption();
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);

            }
        }
    }

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                yue();
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                qvkuan();

                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                zhuanzhang();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                cunkuan();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                System.out.println("欢迎下次光临，请拿好您的卡，祝您一路顺风");
                break;
        }
    }
    private void yue() {
        double money = currentCustomer.getMoney();
        System.out.println(" 余额是 " +money);
    }
    private void qvkuan(){
        System.out.println("请输入取款金额:");

        double money = s.nextDouble();
            if (money <= currentCustomer.getMoney()){
                money = currentCustomer.getMoney()-money;
                currentCustomer.setMoney(money);
                System.out.println("取款成功,账户余额:"+currentCustomer.getMoney());
            }else {
                System.out.println("余额不足，取款失败");
            }

        }
        private  void zhuanzhang(){
            System.out.println("请输入转账人的账号:");
            String name = s.next();
            System.out.println("输入转账金额:");
            double money=s.nextDouble();
            if (money<=currentCustomer.getMoney()){
                money=currentCustomer.getMoney()-money;
                currentCustomer.getMoney();
                System.out.println("转账成功");

            }else {
                System.out.println("余额不足，转账失败");
            }

        }

    private void cunkuan(){
        System.out.println("请输入存钱额度:");
        double money = s.nextDouble();
        if (money >0){
            System.out.println("存款金额不能为0");
        }
        money = money+currentCustomer.getMoney();
        currentCustomer.setMoney(money);
        System.out.println("存款成功，当前余额:"+currentCustomer.getMoney());
    }


    private  void goOneHome( ){
        TextUitl.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);
    }


}
