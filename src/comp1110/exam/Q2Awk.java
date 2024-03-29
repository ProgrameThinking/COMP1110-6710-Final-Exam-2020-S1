package comp1110.exam;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * COMP1110 Exam, Question 2
 *
 * IMPORTANT NOTE:  This question depends on knowledge of Java NIO, which is not
 * taught in S2 classes.  It can be solved without NIO, but is not intended for
 * students who are not familiar with NIO.
 */
public class Q2Awk {
    /**
     * Read the specified input file in comma-separated-value (CSV) format and
     * extract all values from the specified column, writing the values
     * (one per line) to the specified output file.
     * If sortOutput==true, the values in the specified column are written in
     * alphabetical order to the output file; otherwise, the values are written
     * in the same order as they occur in the input file.
     * If the specified column is missing a value for a given line, then that
     * line is ignored and is not included in the output.
     * If the specified column is not included in any line of the input file,
     * then the output file is empty.
     * <p>
     * For example, if the input file "Q2kate.csv" contains the following lines:
     * Babooshka,1980,2
     * Hounds of Love,1986,
     * Rubberband Girl,1993,39
     * Running Up That Hill,1983,6
     * Wuthering Heights,1978,1
     * then the method call extractColumnCSV("Q2kate.csv", 2, "chart.csv", true)
     * would result in the following lines being written to the file "chart.csv":
     * 1
     * 2
     * 39
     * 6
     *
     * @param inputFilename  the filename of the input file
     * @param column         the number of the column to extract (0..n)
     * @param outputFilename the filename of the output file
     * @param sortOutput     if true, the specified column is written to the output
     *                       file in alphabetical order
     * @throws java.nio.file.NoSuchFileException if the input file does not exist or
     *                                           the output file cannot be created
     */
    static void extractColumnCSV(String inputFilename, int column, String outputFilename, boolean sortOutput) throws IOException {
        // FIXME complete this method
    	List<String> values = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > column && !columns[column].isEmpty()) {
                    values.add(columns[column]);
                }
            }
        }
        catch (FileNotFoundException e) {
            // 处理文件不存在的情况
            System.err.println("Error: Input file not found - " + e.getMessage());
            throw new NoSuchFileException(""); // 可选择抛出异常，也可以处理其他逻辑
        }

        if (sortOutput) {
            Collections.sort(values);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            for (String value : values) {
                writer.write(value);
                writer.newLine();
            }
        }
        catch (FileNotFoundException e) {
            // 处理文件不存在的情况
            System.err.println("Error: Input file not found - " + e.getMessage());
            throw new NoSuchFileException(""); // 可选择抛出异常，也可以处理其他逻辑
        }
    }
}