package InputOutputStream;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String filename = null;
        OutputStream os = null;

        //erstellt Output Stream
        try {
            filename = "testFile.txt";
             os = new FileOutputStream(filename); //Konstruktor

        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling}
        }

        //schreibt in file
        String someText = "Hello";
        byte[] textAsByte = someText.getBytes();

        try {
            os.write(textAsByte);
        } catch (IOException ex) { //IO Exeption für Input/Output Fehler
            System.err.print("couldn't write data - fatal");
            System.exit(0);
        }

        //erstellt Inputstream
        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling}
        }

        //lesen aus Stream
        byte[] readBuffer = new byte[100]; //ByteArray mit der Länge 100
        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0); // brutal exception handling}
        }

        String readString = new String (readBuffer);
        System.out.println ("read something: " + readString);
    }
}
