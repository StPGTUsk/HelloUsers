package edu.penzgtu.oop.types;

public class App {
    public static void main(String[] args) {
        // type Byte: хранит целые числа от -128 до 127
        System.out.printf("Min Byte: %d | Max Byte: %d | Bytes: %d \n", Byte.MIN_VALUE,Byte.MAX_VALUE,Byte.SIZE);

        // type Short: хранит целые числа от -32768 до 32767
        System.out.printf("Min Short: %d | Max Short: %d | Bytes: %d \n", Short.MIN_VALUE,Short.MAX_VALUE,Short.SIZE);

        // type Integer: хранит целые числа от -2^31 до 2^31 - 1
        System.out.printf("Min Integer: %d | Max Integer: %d | Bytes: %d \n", Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.SIZE);

        // type Long хранит целые числа от -2^63 до 2^63 - 1
        System.out.printf("Min Long: %d | Max Long: %d | Bytes: %d \n", Long.MIN_VALUE,Long.MAX_VALUE,Long.SIZE);

        // type Float хранит целые числа от -3.4*10^38 до 3.4*10^38
        System.out.printf("Min Float: %e | Max Float: %e | Bytes: %d \n", Float.MIN_VALUE,Float.MAX_VALUE,Float.SIZE);

        // type Double хранит числа c плавающей точкой, примерно от -1.8*10^308 до 1.8*10^308
        System.out.printf("Min Double: %e | Max Double: %e | Bytes: %d \n", Double.MIN_VALUE,Double.MAX_VALUE,Double.SIZE);
    }
}
