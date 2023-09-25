package org.example;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {

        int i=-4;
        while (i<5){
            i++;
            System.out.print("i:"+i+" ");
            try {
                System.out.println(10 / i);
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        }
        System.out.println("setelah while");

        // PR FileException

        //Try Catch
        //Aplikasi tetep run tidak crash.
        //Try Catch Finally
        //Try Catch with Resource
        //Throws
        //Throw

        System.out.println("Sebelum ada error");//thread 1



        BufferedReader br = null;
        try {
            int nilai = 50 / 0; // thread 1


            File file = new File("/home/ilyas/Downloads/abc.txt");
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

        }catch (ArithmeticException ae){
            ae.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File file = new File("/home");

        try(
                FileReader fr = new FileReader(file);
                BufferedReader br2 = new BufferedReader(fr);
        ){

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("");
        }

        System.out.println("Setelah ada error"); //thread 1


//        try {
//            //User userLogin = ...;
//            readFile();
//        } catch (FileNotFoundException e) {
//            //Log.error(userLogin+e.printStackTrace());
//        }
//
//        FileReader fr3 = null;
//        try{
//            //ada potensi error
//            fr3 = new FileReader(new File(""));
//            BufferedReader br3 = new BufferedReader(fr3);
//            fr3.close();
//            br3.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            fr3.close();
//            //apapun yang terjadi. Pada akhrinya block ini akan running
//        }
//
//        whil

    }


    void readFile() throws FileNotFoundException {
        File file = new File("/home/ilyas/Downloads/abc.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

    }
    public static void readFile2(){


        try{

        }finally {

        }
    }

    //https://aplikasi.id/user/20

//    public User getUserById(long 20){
//        Optional<User> userOptional= userRepository.findById(20); //null atau User
//        if(userOptional.isEmpty()){
//            throw new RuntimeException();
//        }
//        return userOptional.get();
//    }


}