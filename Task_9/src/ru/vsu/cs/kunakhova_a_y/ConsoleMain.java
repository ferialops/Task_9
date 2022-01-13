package ru.vsu.cs.kunakhova_a_y;

import ru.vsu.cs.kunakhova_a_y.Utils.ArrayUtils;

import java.io.PrintStream;
import java.util.List;

public class ConsoleMain {
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length > 1) {
                params.inputFile = args[0];
                params.outputFile = args[1];
                return params;
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        ConsoleMain.CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> <input-File> <output-File>");
            out.println("  for example: <cmd> f1.txt f2.txt");
            out.println("  f1: inputFile f2: outputFile");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        if (params.window) {
            GuiMain.winMain();
        } else {
            List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile(params.inputFile));
            if (input == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            }
            List<Integer> result = transformList.uniq(input);
            int[] resultArray = ArrayUtils.listToArray(result);
            ArrayUtils.printArrayInConsole(resultArray);
            ArrayUtils.writeArrayToFile(params.outputFile, resultArray);
        }
    }
}
