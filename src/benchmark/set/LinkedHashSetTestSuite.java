package benchmark.set;

import java.util.*;

public class LinkedHashSetTestSuite {
    public int size;
    public int multiplicity;
    public HashMap<String, Integer> Profile;
    public HashMap<String, String> Semantics;

    public LinkedHashSetTestSuite(int p_size, int p_multiplicity) {
        this.size = p_size;
        this.multiplicity = p_multiplicity;
        this.Profile = new HashMap<>();
        this.Semantics = new HashMap<>();
        run();
    }

    public void run() {
        insert_1();
        delete_1();
        iterate_1();
        search_1();
    }

    public String dump() {
        System.out.println("java.util.LinkedHashSet Profile:");
        StringBuffer buf = new StringBuffer();
        buf.append("\"java.util.LinkedHashSet\":");
        buf.append("{");
        for (Map.Entry<String, Integer> entry : Profile.entrySet()) {
            System.out.println("Interface = " + entry.getKey() +
                    ", Cost = " + entry.getValue());
            buf.append("\"" + entry.getKey() + "\"");
            buf.append(":");
            buf.append(entry.getValue());
            buf.append(",");
        }
        buf.deleteCharAt(buf.length() - 1);
        buf.append("}");
        System.out.println();
        return buf.toString();
    }

    public void insert_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedHashSet<Integer> LinkedHashSet_object = new LinkedHashSet<Integer>();
            for (int j = 0; j < this.size; j++) {
                LinkedHashSet_object.add(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("add(O)", new Integer((int)totalTime));
        this.Semantics.put("add(O)", "insert");
    }

    public void delete_1() {
        ArrayList<LinkedHashSet<Integer>> LinkedHashSet_objects = new ArrayList<LinkedHashSet<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedHashSet<Integer> LinkedHashSet_object = new LinkedHashSet<>();
            for (int j = 0; j < this.size; j++) {
                LinkedHashSet_object.add(j);
            }
            LinkedHashSet_objects.add(LinkedHashSet_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedHashSet LinkedHashSet_object = LinkedHashSet_objects.get(i);
            for (int j = 0; j < size; j++) {
                LinkedHashSet_object.remove(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(O)", new Integer((int)totalTime));
        this.Semantics.put("remove(O)", "delete");
    }

    public void iterate_1() {
        LinkedHashSet<Integer> LinkedHashSet_object = new LinkedHashSet<Integer>();
        for (int j = 0; j < this.size; j++) {
            LinkedHashSet_object.add(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            Iterator<Integer> it = LinkedHashSet_object.iterator();
            while(it.hasNext()) {
                Integer elem = it.next();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("iterator()", new Integer((int)totalTime));
        this.Semantics.put("iterator()", "iterateSet");
    }

    public void search_1() {
        LinkedHashSet<Integer> LinkedHashSet_object = new LinkedHashSet<Integer>();
        for (int j = 0; j < this.size; j++) {
            LinkedHashSet_object.add(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                LinkedHashSet_object.contains(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("contains", new Integer((int)totalTime));
        this.Semantics.put("contains", "search");
    }

}
