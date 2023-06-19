package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws MyException, IOException {
        inputWithTryCatchFinally();
        inputWithoutCatch();
        inputWithoutFinally();
        inputWithResources();
        inputWithTwoExceptionInOneCatch();

    }

    public static String inputWithTryCatchFinally() throws MyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        try {
            str = reader.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {

            try {
                reader.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (str.equals("")) {

            throw new MyException("String can not be empty!");
        }
        return str;
    }

    public static String inputWithoutCatch() throws MyException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        try {
            str = reader.readLine();

        } finally {

            try {
                reader.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (str.equals("")) {

            throw new MyException("Stringcannotbeempty!");
        }
        return str;
    }

    public static String inputWithoutFinally() throws MyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        try {
            str = reader.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        if (str.equals("")) {

            throw new MyException("Stringcannotbeempty!");
        }
        return str;
    }


    public static String inputWithResources() throws MyException {
        String str = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (str.equals("")) {
            throw new MyException("Stringcannotbeempty!");
        }
        return str;
    }

    public static String inputWithTwoExceptionInOneCatch() {
        String str = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = reader.readLine();
            if (str.equals("")) {
                throw new MyException("Stringcannotbeempty!");
            }
        } catch (IOException | MyException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }
}