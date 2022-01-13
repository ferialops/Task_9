package ru.vsu.cs.kunakhova_a_y;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.kunakhova_a_y.Utils.ArrayUtils;

import java.util.List;

public class transformListTest {

    @Test
    public void firstTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput1.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput1.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void secondTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput2.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput2.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void thirdTest3() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput3.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput3.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void fourthTest4() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput4.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput4.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void fifthTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput5.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput5.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void sixthTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput6.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput6.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void seventhTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput7.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput7.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void eighthTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput8.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput8.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void ninthTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput9.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput9.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }

    @Test
    public void tenthTest() {
        List<Integer> input = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testInput10.txt"));
        List<Integer> outputCorrect = ArrayUtils.toIntList(ArrayUtils.readIntArrayFromFile("testSrc/testOutput10.txt"));

        List<Integer> outputCurrent = transformList.uniq(input);

        Assert.assertEquals(outputCorrect, outputCurrent);
    }
}
