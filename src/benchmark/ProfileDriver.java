package benchmark;

import benchmark.list.LinkedListTestSuite;
import benchmark.list.StackTestSuite;
import benchmark.list.ArrayListTestSuite;

import benchmark.map.HashMapTestSuite;
import benchmark.map.TreeMapTestSuite;
import benchmark.map.HashtableTestSuite;

import benchmark.set.HashSetTestSuite;
import benchmark.set.LinkedHashSetTestSuite;
import benchmark.set.TreeSetTestSuite;

import java.io.PrintWriter;
import java.util.*;

public class ProfileDriver {
    static StackTestSuite stackTestSuite;
    static LinkedListTestSuite linkedListTestSuite;
    static ArrayListTestSuite arrayListTestSuite;

    static HashSetTestSuite hashSetTestSuite;
    static LinkedHashSetTestSuite linkedHashSetTestSuite;
    static TreeSetTestSuite treeSetTestSuite;

    static HashMapTestSuite hashMapTestSuite;
    static TreeMapTestSuite treeMapTestSuite;
    static HashtableTestSuite hashtableTestSuite;

    public static void main(String[] args) {
        System.out.println("OK");
        int size = 10000;
        int multiplicity = 10;

        stackTestSuite = new StackTestSuite(size, multiplicity);
        linkedListTestSuite = new LinkedListTestSuite(size, multiplicity);
        arrayListTestSuite = new ArrayListTestSuite(size, multiplicity);

        hashSetTestSuite = new HashSetTestSuite(size, multiplicity);
        linkedHashSetTestSuite = new LinkedHashSetTestSuite(size, multiplicity);
        treeSetTestSuite = new TreeSetTestSuite(size, multiplicity);

        hashMapTestSuite = new HashMapTestSuite(size, multiplicity);
        treeMapTestSuite = new TreeMapTestSuite(size, multiplicity);
        hashtableTestSuite = new HashtableTestSuite(size, multiplicity);
        dumpToJson();
    }

    public static void dumpToJson() {
        StringBuffer buf = new StringBuffer();
        buf.append("{");
        buf.append(stackTestSuite.dump());
        buf.append(",");
        buf.append(linkedListTestSuite.dump());
        buf.append(",");
        buf.append(arrayListTestSuite.dump());
        buf.append(",");
        buf.append(hashSetTestSuite.dump());
        buf.append(",");
        buf.append(linkedHashSetTestSuite.dump());
        buf.append(",");
        buf.append(treeSetTestSuite.dump());
        buf.append(",");
        buf.append(hashMapTestSuite.dump());
        buf.append(",");
        buf.append(treeMapTestSuite.dump());
        buf.append(",");
        buf.append(hashtableTestSuite.dump());
        buf.append("}");
        System.out.println(buf.toString());

        try (PrintWriter out = new PrintWriter("specification/benchmark-container-performance-spec.json")) {
            out.println(buf.toString());
        } catch (Exception e) {
            System.out.println("Cannot dump to json file");
        }
    }
}
