package benchmark.list;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ArrayListTestSuite {
    public int size;
    public int multiplicity;
    public HashMap<String, Integer> Profile;
    public HashMap<String, String> Semantics;

    public ArrayListTestSuite(int p_size, int p_multiplicity) {
        this.size = p_size;
        this.multiplicity = p_multiplicity;
        this.Profile = new HashMap<>();
        this.Semantics = new HashMap<>();
        run();
    }

    public void run() {
        insertAtEnd_1();
        insertAtHead_1();
        insertRandom_1();

        deleteAtEnd_1();
        deleteAtHead_1();
        deleteRandom_1();

        accessAtEnd_1();
        accessAtHead_1();
        accessRandom_1();

        search_1();
    }

    public String dump() {
        System.out.println("java.util.ArrayList Profile:");
        StringBuffer buf = new StringBuffer();
        buf.append("\"java.util.ArrayList\":");
        buf.append("{");
        for (Map.Entry<String, Integer> entry : Profile.entrySet()) {
            System.out.println("Interface = " + entry.getKey() +
                    ", Cost = " + entry.getValue());
            buf.append("\"" + entry.getKey() + "\"");
            buf.append(":");
            buf.append(entry.getValue());
            buf.append(",");
        }
        System.out.println();
        buf.deleteCharAt(buf.length() - 1);
        buf.append("}");
        return buf.toString();
    }

    public void insertAtHead_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.add(0, j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("add(0, O)", new Integer((int)totalTime));
        this.Semantics.put("add(0, O)", "insertAtHead");
    }

    public void insertAtEnd_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.add(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("add(O)", new Integer((int)totalTime));
        this.Semantics.put("add(O)", "insertAtEnd");
    }

    public void insertRandom_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.add(j/2, j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("add(I, O)", new Integer((int)totalTime));
        this.Semantics.put("add(I, O)", "insertRandom");
    }

    public void deleteAtHead_1() {
        ArrayList<ArrayList<Integer>> ArrayList_objects = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList<Integer> ArrayList_object = new ArrayList<>();
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.add(j);
            }
            ArrayList_objects.add(ArrayList_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList ArrayList_object = ArrayList_objects.get(i);
            while(!ArrayList_object.isEmpty()) {
                ArrayList_object.remove(0);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(0)", new Integer((int)totalTime));
        this.Semantics.put("remove(0)", "deleteAtHead");
    }

    public void deleteAtEnd_1() {
        ArrayList<ArrayList<Integer>> ArrayList_objects = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList<Integer> ArrayList_object = new ArrayList<>();
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.add(j);
            }
            ArrayList_objects.add(ArrayList_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList ArrayList_object = ArrayList_objects.get(i);
            while(!ArrayList_object.isEmpty()) {
                ArrayList_object.remove(ArrayList_object.size() - 1);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(size - 1)", new Integer((int)totalTime));
        this.Semantics.put("remove(size - 1)", "deleteAtEnd");
    }

    public void deleteRandom_1() {
        ArrayList<ArrayList<Integer>> ArrayList_objects = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList<Integer> ArrayList_object = new ArrayList<>();
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.add(j);
            }
            ArrayList_objects.add(ArrayList_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            ArrayList ArrayList_object = ArrayList_objects.get(i);
            while(!ArrayList_object.isEmpty()) {
                ArrayList_object.remove(ArrayList_object.size() / 2);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(I)", new Integer((int)totalTime));
        this.Semantics.put("remove(I)", "deleteRandom");
    }

    public void accessAtHead_1() {
        ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
        for (int j = 0; j < this.size; j++) {
            ArrayList_object.add(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = ArrayList_object.get(0);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(0)", new Integer((int)totalTime));
        this.Semantics.put("get(0)", "accessAtHead");
    }

    public void accessAtEnd_1() {
        ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
        for (int j = 0; j < this.size; j++) {
            ArrayList_object.add(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = ArrayList_object.get(ArrayList_object.size() - 1);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(size - 1)", new Integer((int)totalTime));
        this.Semantics.put("get(size - 1)", "accessAtEnd");
    }

    public void accessRandom_1() {
        ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
        for (int j = 0; j < this.size; j++) {
            ArrayList_object.add(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = ArrayList_object.get(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(I)", new Integer((int)totalTime));
        this.Semantics.put("get(I)", "accessRandom");
    }

    public void search_1() {
        ArrayList<Integer> ArrayList_object = new ArrayList<Integer>();
        for (int j = 0; j < this.size; j++) {
            ArrayList_object.add(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                ArrayList_object.contains(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("contains", new Integer((int)totalTime));
        this.Semantics.put("contains", "search");
    }

}
