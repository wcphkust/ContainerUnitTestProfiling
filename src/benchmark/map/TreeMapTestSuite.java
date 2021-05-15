package benchmark.map;

import java.util.*;

public class TreeMapTestSuite {
    public int size;
    public int multiplicity;
    public HashMap<String, Integer> Profile;
    public HashMap<String, String> Semantics;

    public TreeMapTestSuite(int p_size, int p_multiplicity) {
        this.size = p_size;
        this.multiplicity = p_multiplicity;
        this.Profile = new HashMap<>();
        this.Semantics = new HashMap<>();
        run();
    }

    public void run() {
        insert_1();
        delete_1();
        access_1();
        iterate_1();
        search_1();
        search_2();
    }

    public String dump() {
        System.out.println("java.util.TreeMap Profile:");
        StringBuffer buf = new StringBuffer();
        buf.append("\"java.util.TreeMap\":");
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
            TreeMap<Integer, Integer> TreeMap_object = new TreeMap<Integer, Integer>();
            for (int j = 0; j < this.size; j++) {
                TreeMap_object.put(j, j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("put(O, O)", new Integer((int)totalTime));
        this.Semantics.put("put(O, O)", "insert");
    }

    public void delete_1() {
        ArrayList<TreeMap<Integer, Integer>> TreeMap_objects = new ArrayList<TreeMap<Integer, Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            TreeMap<Integer, Integer> TreeMap_object = new TreeMap<>();
            for (int j = 0; j < this.size; j++) {
                TreeMap_object.put(j, j);
            }
            TreeMap_objects.add(TreeMap_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            TreeMap TreeMap_object = TreeMap_objects.get(i);
            for (int j = 0; j < size; j++) {
                TreeMap_object.remove(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(O)", new Integer((int)totalTime));
        this.Semantics.put("remove(O)", "delete");
    }

    public void access_1() {
        TreeMap<Integer, Integer> TreeMap_object = new TreeMap<Integer, Integer>();
        for (int j = 0; j < this.size; j++) {
            TreeMap_object.put(j, j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer k = TreeMap_object.get(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(O)", new Integer((int)totalTime));
        this.Semantics.put("get(O)", "access");
    }

    public void iterate_1() {
        TreeMap<Integer, Integer> TreeMap_object = new TreeMap<Integer, Integer>();
        for (int j = 0; j < this.size; j++) {
            TreeMap_object.put(j, j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            Iterator it = TreeMap_object.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("entrySet()", new Integer((int)totalTime));
        this.Semantics.put("entrySet()", "iterateMap");
    }

    public void search_1() {
        TreeMap<Integer, Integer> TreeMap_object = new TreeMap<Integer, Integer>();
        for (int j = 0; j < this.size; j++) {
            TreeMap_object.put(j, j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                TreeMap_object.containsKey(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("containsKey(O)", new Integer((int)totalTime));
        this.Semantics.put("containsKey(O)", "searchByKey");
    }

    public void search_2() {
        TreeMap<Integer, Integer> TreeMap_object = new TreeMap<Integer, Integer>();
        for (int j = 0; j < this.size; j++) {
            TreeMap_object.put(j, j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                TreeMap_object.containsValue(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("containsValue(O)", new Integer((int)totalTime));
        this.Semantics.put("containsValue(O)", "searchByValue");
    }
}
