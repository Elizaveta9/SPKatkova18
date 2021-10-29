package com.company;

public class BankAccount {
    public static void main(String[] args) {
        // количество денег, которое надо снять
        long moneyToWithdraw = 15000;

        // создание счета
        Account acc = new Account();

        // создание и запуск потока
        AccountTread accTread = new AccountTread(acc);
        accTread.start();

        // main поток, проверяющий баланс и снимающий указанную сумму
        for (int i = 0; i < 1000; i++) {
            acc.withdrawMoney(moneyToWithdraw);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// класс счёта
class Account {
    private long balance = 1000;

    // метод для снятия денег
    public Long withdrawMoney(long money) {
        if (balance >= money) {
            balance -= money;
            System.out.println("Cнято " + money);
        }
        return balance;
    }

    // метод для добавления денег
    public void putMoney(long money) {
        balance += money;
    }

    public long getBalance() {
        return balance;
    }
}

// класс потока
class AccountTread extends Thread {
    Account acc;

    public AccountTread(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            // рандомное определение суммы для добавления
            long money = (long) (Math.random() * 1000);

            acc.putMoney(money);
            System.out.println("Добавлено " + money + " кромеров, баланс " + acc.getBalance());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
