import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

/**
 * Utility class providing helper functions for reading, parsing, converting,
 * and manipulating game save files (specifically tailored for PSX save formats such as Spyro data).
 */
public class SaveTools {

    /**
     * The expected fixed byte size of a standard save file layout.
     */
    public static final int SAVE_FILE_SIZE = 1024;

    /**
     * Default local path used during testing to locate the binary save file.
     */
    public static final String SAVE_FILE_PATH = "../Console/BASCUS-94467SPY3_1.BAC0";

    /**
     * Reads the entire content of a save file into a byte array and verifies that
     * the file size matches the target {@link #SAVE_FILE_SIZE}.
     *
     * @param saveData File object representing the source save file.
     * @return Byte array containing the raw file data.
     * @throws RuntimeException If an I/O error occurs or the file size does not match {@link #SAVE_FILE_SIZE}.
     */
    public static byte @NotNull [] saveToBytes(@NotNull File saveData) {
        byte[] output;
        try {
            output = Files.readAllBytes(saveData.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read save file: " + saveData.getPath(), e);
        }

        // Validate byte array size against expected save length
        if (output.length != SAVE_FILE_SIZE) {
            throw new RuntimeException("Invalid save file size. Expected " + SAVE_FILE_SIZE +
                    " bytes, but found " + output.length + " bytes.");
        }

        return output;
    }

    /**
     * Console entry point for testing save file loading and byte inspection.
     *
     * @param args Command-line execution arguments.
     */
    public static void main(String[] args) {
        File testData = new File(SAVE_FILE_PATH);
        byte[] intake = saveToBytes(testData);
        for (byte n : intake) {
            System.out.println(n);
        }
    }

    /**
     * Computes a running 32-bit checksum for a save slot byte array up to the last 4 bytes.
     * Individual byte values are cast to unsigned integers prior to addition.
     *
     * @param data Byte array representing the save slot raw memory block.
     * @return Calculated integer checksum.
     */
    @Contract(pure = true)
    public static int checksumSaveSlotBytes(byte @NotNull [] data) {
        int sum = 0;
        for (int i = 0; i < data.length - 4; i++) {
            sum += (data[i] & 0xFF); // Handle unsigned byte conversion in Java
        }
        return sum;
    }

    /**
     * Converts a 4-byte segment from a byte array into a 32-bit signed integer using {@link ByteBuffer}.
     * Supports configurable endianness (Little-Endian for PSX save formats vs. Big-Endian).
     *
     * @param bytes       Source byte array containing the sequence.
     * @param offset      Starting index within the source array.
     * @param isBigEndian {@code true} for Big-Endian, {@code false} for Little-Endian.
     * @return Parsed 32-bit integer value.
     * @throws IndexOutOfBoundsException If {@code offset} is invalid or array length is insufficient.
     */
    public static int bytesToInt(byte[] bytes, int offset, boolean isBigEndian) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes, offset, 4);
        buffer.order(isBigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        return buffer.getInt();
    }
}