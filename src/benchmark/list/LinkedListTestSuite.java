package benchmark.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class LinkedListTestSuite {
    public int size;
    public int multiplicity;
    public HashMap<String, Integer> Profile;
    public HashMap<String, String> Semantics;

    public LinkedListTestSuite(int p_size, int p_multiplicity) {
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
        System.out.println("java.util.LinkedList Profile:");
        StringBuffer buf = new StringBuffer();
        buf.append("\"java.util.LinkedList\":");
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

    public void insertAtHead_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.addFirst(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("addFirst(O)", new Integer((int)totalTime));
        this.Semantics.put("addFirst(O)", "insertAtHead");
    }

    public void insertAtEnd_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.addLast(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("addLast(O)", new Integer((int)totalTime));
        this.Semantics.put("addLast(O)", "insertAtEnd");
    }

    public void insertRandom_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.add(j/2, j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("add(I, O)", new Integer((int)totalTime));
        this.Semantics.put("add(I, O)", "insertRandom");
    }

    public void deleteAtHead_1() {
        ArrayList<LinkedList<Integer>> LinkedList_objects = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList<Integer> LinkedList_object = new LinkedList<>();
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.push(j);
            }
            LinkedList_objects.add(LinkedList_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList LinkedList_object = LinkedList_objects.get(i);
            while(!LinkedList_object.isEmpty()) {
                LinkedList_object.removeFirst();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("removeFirst()", new Integer((int)totalTime));
        this.Semantics.put("removeFirst()", "deleteAtHead");
    }

    public void deleteAtEnd_1() {
        ArrayList<LinkedList<Integer>> LinkedList_objects = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList<Integer> LinkedList_object = new LinkedList<>();
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.push(j);
            }
            LinkedList_objects.add(LinkedList_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList LinkedList_object = LinkedList_objects.get(i);
            while(!LinkedList_object.isEmpty()) {
                LinkedList_object.removeLast();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("removeLast()", new Integer((int)totalTime));
        this.Semantics.put("removeLast()", "deleteAtEnd");
    }

    public void deleteRandom_1() {
        ArrayList<LinkedList<Integer>> LinkedList_objects = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList<Integer> LinkedList_object = new LinkedList<>();
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.push(j);
            }
            LinkedList_objects.add(LinkedList_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            LinkedList LinkedList_object = LinkedList_objects.get(i);
            while(!LinkedList_object.isEmpty()) {
                LinkedList_object.remove(LinkedList_object.size() / 2);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(I)", new Integer((int)totalTime));
        this.Semantics.put("remove(I)", "deleteRandom");
    }

    public void accessAtHead_1() {
        LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
        for (int j = 0; j < this.size; j++) {
            LinkedList_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = LinkedList_object.peekFirst();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("peekFirst()", new Integer((int)totalTime));
        this.Semantics.put("peekFirst()", "accessAtHead");
    }

    public void accessAtEnd_1() {
        LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
        for (int j = 0; j < this.size; j++) {
            LinkedList_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = LinkedList_object.peek();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("peek()", new Integer((int)totalTime));
        this.Semantics.put("peek()", "accessAtEnd");
    }

    public void accessRandom_1() {
        LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
        for (int j = 0; j < this.size; j++) {
            LinkedList_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = LinkedList_object.get(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(I)", new Integer((int)totalTime));
        this.Semantics.put("get(I)", "accessRandom");
    }

    public void search_1() {
        LinkedList<Integer> LinkedList_object = new LinkedList<Integer>();
        for (int j = 0; j < this.size; j++) {
            LinkedList_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                LinkedList_object.contains(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("contains", new Integer((int)totalTime));
        this.Semantics.put("contains", "search");
    }

}
