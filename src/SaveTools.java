import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

/**
 * Utility class providing helper functions for reading, parsing, and manipulating
 * game save files (specifically tailored for console save formats such as Spyro data).
 */
public class SaveTools {

    /** The expected fixed byte size of a standard save file. */
    public static final int SAVE_FILE_SIZE = 1024;

    /** The default file system path pointing to the console save file. */
    public static final String SAVE_FILE_PATH = "../Console/BASCUS-94467SPY3_1.BAC0";

    /**
     * Reads the entire content of a specified save file into a byte array and verifies
     * that its length matches the expected {@link #SAVE_FILE_SIZE}.
     *
     * @param saveData the file object pointing to the save data file to read
     * @return a byte array containing the contents read from the file
     * @throws RuntimeException if an {@link IOException} occurs while reading, or if the file
     *                          size does not exactly match {@link #SAVE_FILE_SIZE}
     */
    public static byte @NotNull [] saveToBytes(@NotNull File saveData) {
        byte[] output;
        try {
            output = Files.readAllBytes(saveData.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read save file: " + saveData.getPath(), e);
        }

        // Ensure the file size matches the expected save layout length
        if (output.length != SAVE_FILE_SIZE) {
            throw new RuntimeException("Invalid save file size. Expected " + SAVE_FILE_SIZE +
                    " bytes, but found " + output.length + " bytes.");
        }

        return output;
    }

    /**
     * Main execution entry point for testing save file loading and printing individual byte values.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args){
        File testData = new File(SAVE_FILE_PATH);
        byte[] intake = saveToBytes(testData);
        for(byte n : intake){
            System.out.println(n);
        }
    }

    /**
     * Computes a running checksum sum of the save slot bytes data array up to the final 4 bytes.
     * Handles individual bytes as unsigned values using bitwise masking.
     *
     * @param data the byte array representing the save data structure
     * @return the calculated integer checksum sum
     */
    public static int checksumSaveSlotBytes(byte[] data) {
        int sum = 0;
        for (int i = 0; i < data.length - 4; i++) {
            sum += (data[i] & 0xFF); // Handle unsigned byte conversion in Java
        }
        return sum;
    }

    /**
     * Converts a 4-byte array segment into a 32-bit signed integer using a {@link ByteBuffer}.
     * Supports configurable byte ordering (crucial for parsing cross-platform or little-endian
     * game save files).
     *
     * @param bytes       the source byte array containing the 4 bytes to convert
     * @param offset      the starting index within the array where the 4-byte sequence begins
     * @param isBigEndian {@code true} for Big-Endian byte order (most significant byte first),
     *                    {@code false} for Little-Endian byte order (least significant byte first)
     * @return the resulting 32-bit integer value parsed from the byte sequence
     * @throws IndexOutOfBoundsException if {@code offset} is negative, or if fewer than 4 bytes
     *                                   remain in the array from the given offset
     */
    public static int bytesToInt(byte[] bytes, int offset, boolean isBigEndian) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, 4);
        buffer.order(isBigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        return buffer.getInt();
    }
}