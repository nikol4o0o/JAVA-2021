package com.services;

public interface Cipherable
{
    //  метод, който взима за аргумент цяло число и връща масив от символи
    char[] getSecretChars(int seed);
}