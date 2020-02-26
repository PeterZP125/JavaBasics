package com.peter.multiThread.案例.账户存钱;

//甲和乙分别对同一账户充钱，每次1000元，存十次
public class AccountDeposit {
    private int balance = 0;

    public void deposit() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                balance += 1000;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存了1000元，与余额" + balance + "元");
            }
        }
    }

    public static void main(String[] args) {
        AccountDeposit accountDeposit = new AccountDeposit();
        User t1 = new User();
        User t2 = new User();
        t1.setAccountDeposit(accountDeposit);
        t2.setAccountDeposit(accountDeposit);
        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();


    }
}

class User extends Thread {
    private AccountDeposit accountDeposit;

    @Override
    public void run() {
        accountDeposit.deposit();
    }

    public AccountDeposit getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(AccountDeposit accountDeposit) {
        this.accountDeposit = accountDeposit;
    }
}
