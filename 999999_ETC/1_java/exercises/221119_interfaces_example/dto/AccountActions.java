package dto;

import dao.*;

interface AccountActions {
    BankAccount deposit(long amount);
    BankAccount withdraw(long amount);
    BankAccount transfer(long amount, long number);
}