package by.it.dilkevich.jd01_14;

import com.sun.xml.internal.txw2.output.DataWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {


    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/dilkevich/jd01_14/";
        String filePathOutput = src + "dataTaskA.bin";
        String filePathInput = src + "resultTaskA.txt";



        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePathOutput)));){

            double avr = 0;
            for (int i = 0; i < 20; i++) {

                Integer number = (int) (Math.random()*101);
                dos.writeInt(number);
                System.out.print(number + " ");
                avr += number;
            }
            System.out.println("\navg=" + avr / 20);


        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();

        try (DataInputStream inputInt = new DataInputStream(new BufferedInputStream(new FileInputStream(filePathOutput)))){

            while (inputInt.available() > 0){

                list.add(inputInt.readInt());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintWriter out = new PrintWriter(new FileWriter(filePathInput))) {

            double sum = 0;
            for (Integer value : list) {
                out.printf("%d ", value);
                sum += value;
            }
            out.println("\navg=" + sum / 20);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
