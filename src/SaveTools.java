import java.io.File;
import java.util.Scanner;


public class SaveTools {
    //This class will contain utility functions for reading and manipulating save files
    public static final int SAVE_FILE_SIZE = 1024;
    public static byte[] saveToBytes(File saveData){
        byte[] output = new byte[SAVE_FILE_SIZE];
        Scanner readIn = new Scanner(System.in);
        for(byte n : output){
            n = readIn.nextByte();
        }
        return output;
    }
    public static void main(String[] args){
        File testData = new File(args[0]);
        byte[] intake = saveToBytes(testData);
        for(byte n : intake){
            System.out.println(n);
        }
    }
}
