package exp7;

import java.util.Arrays;

public class CRC {
    public static void main(String[] args) {
        int[] data = {1, 0, 1, 1, 0, 1};
        int[] divisor = {1, 0, 1};
        int[] crc = calculateCRC(data, divisor);

        System.out.println("Dividend: ");
        printArray(data);

        System.out.println("\nCRC code: ");
        printArray(crc);

    }

    static int[] calculateCRC(int[] data, int[] divisor) {
        int dataBits = data.length;
        int divisorBits = divisor.length;
        int totalLength = dataBits + divisorBits - 1;
        int[] dividend = new int[totalLength];

        for (int i = 0; i < dataBits; i++) dividend[i] = data[i];

        for (int i = 0; i < dataBits; i++) {
            if (dividend[i] != 0) {
                for (int j = 0; j < divisorBits; j++)
                    dividend[i + j] ^= divisor[j];
            }
        }

        return Arrays.copyOfRange(dividend, dataBits, totalLength);

    }

    static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value);
    }
}
