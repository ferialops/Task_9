package ru.vsu.cs.kunakhova_a_y.Utils;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArrayUtils {
    private static final Random RND = new Random();


    public static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toPrimitive(Double[] arr) {
        if (arr == null) {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] toIntArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        // из List<Integer> можно получить Integer[]
        Integer[] arr = list.toArray(new Integer[0]);
        // Integer[] -> int[]
        return ArrayUtils.toPrimitive(arr);
    }

    //переделанная функция для List
    public static List<Integer> toIntList(int[] array) {
        Scanner scanner = new Scanner(ArrayUtils.toString(array));
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    public static int[] listToArray(List<Integer> list) {
        Integer[] arr = list.toArray(new Integer[0]);
        return ArrayUtils.toPrimitive(arr);
    }

    public static String toString(int[] arr, String itemFormat) {
        if (arr == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, arr[i]));
        }
        return sb.toString();
    }

    public static String toString(int[] arr) {
        return toString(arr, null);
    }


    public static String toString(int[][] arr2, String itemFormat) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr2.length; r++) {
            if (r > 0) {
                sb.append(System.lineSeparator());
            }
            sb.append(toString(arr2[r], itemFormat));
        }
        return sb.toString();
    }

    /**
     * Чтение всего текстового файла в массив строк
     */
    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            // обязательно, чтобы закрыть открытый файл
        }
        return lines.toArray(new String[0]);
    }

    /**
     * Чтение массива int[] из первой строки текстового файла
     */
    public static int[] readIntArrayFromFile(String fileName) {
        try {
            return toIntArray(readLinesFromFile(fileName)[0]);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static void writeArrayToFile(String fileName, int[] arr, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr, itemFormat));
        }
    }

    public static void writeArrayToFile(String fileName, int[] arr)
            throws FileNotFoundException {
        writeArrayToFile(fileName, arr, null);
    }

    public static void writeArrayToFile(String fileName, int[][] arr2, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr2, itemFormat));
        }
    }

    public static void writeArrayToFile(String fileName, int[][] arr2)
            throws FileNotFoundException {
        writeArrayToFile(fileName, arr2, null);
    }

    /**
     * Cоздание одномерного массива целых чисел, заполненного случайными числами
     *
     * @param length   Кол-во элементов в массиве
     * @param minValue Минимальное значение для случайных чисел (включая)
     * @param maxValue Максимальное значение (не включая)
     * @return Массив int[]
     */
    public static int[] createRandomIntArray(int length, int minValue, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = minValue + RND.nextInt(maxValue - minValue);
        return arr;
    }

    /**
     * @see #createRandomIntArray(int, int, int)
     */
    public static int[] createRandomIntArray(int length, int maxValue) {
        return createRandomIntArray(length, 0, maxValue);
    }

    public static void printArrayInConsole(int[] arr) {
        for (int j : arr) {
            System.out.print(j);
            System.out.print(", ");
        }
    }
    public static List<Integer> readListFromJTable(JTable table) {
        StringBuilder sb = new StringBuilder();
        TableModel tableModel = table.getModel();

        int numberOfColumns = tableModel.getColumnCount();

        for (int i = 0; i < numberOfColumns; i++) {
            sb.append(tableModel.getValueAt(0, i).toString());
            sb.append(" ");
        }

        return convertToList(sb.toString());
    }
    private static List<Integer> convertToList(String unsortedList) {
        List<Integer> sortedList = new ArrayList<>();

        if (unsortedList != null) {
            Scanner scn = new Scanner(unsortedList);
            scn.useDelimiter("(\\s|,)+");

            while (scn.hasNext())
                if (!scn.hasNextInt()) {
                    return null;
                } else {
                    sortedList.add(scn.nextInt());
                }
        } else {
            return null;
        }

        return sortedList;
    }
    public static void writeListToFile(String fileName, List<Integer> list) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);

        String res = convertListToString(list);
        out.print(res);
        out.close();
    }
    public static String convertListToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        int numOfMembers = list.size();

        for (Integer i : list) {
            numOfMembers--;
            sb.append(i);

            if (numOfMembers != 0) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

}

