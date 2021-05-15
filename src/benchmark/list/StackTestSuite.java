package benchmark.list;

import java.lang.System;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class StackTestSuite {
    public int size;
    public int multiplicity;
    public HashMap<String, String> Semantics;
    public HashMap<String, Integer> Profile;

    public StackTestSuite(int p_size, int p_multiplicity) {
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
        System.out.println("java.util.Stack Profile:");
        StringBuffer buf = new StringBuffer();
        buf.append("\"java.util.Stack\":");
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
            Stack<Integer> Stack_object = new Stack<Integer>();
            for (int j = 0; j < this.size; j++) {
                Stack_object.add(0, j);
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
            Stack<Integer> Stack_object = new Stack<Integer>();
            for (int j = 0; j < this.size; j++) {
                Stack_object.push(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("push(O)", new Integer((int)totalTime));
        this.Semantics.put("push(O)", "insertAtEnd");
    }

    public void insertRandom_1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack<Integer> Stack_object = new Stack<Integer>();
            for (int j = 0; j < this.size; j++) {
                Stack_object.add(j/2, j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("add(I, O)", new Integer((int)totalTime));
        this.Semantics.put("add(I, O)", "insertRandom");
    }

    public void deleteAtHead_1() {
        ArrayList<Stack<Integer>> Stack_objects = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack<Integer> Stack_object = new Stack<>();
            for (int j = 0; j < this.size; j++) {
                Stack_object.push(j);
            }
            Stack_objects.add(Stack_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack Stack_object = Stack_objects.get(i);
            while(!Stack_object.isEmpty()) {
                Stack_object.remove(0);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(0)", new Integer((int)totalTime));
        this.Semantics.put("remove(0)", "deleteAtHead");
    }

    public void deleteAtEnd_1() {
        ArrayList<Stack<Integer>> Stack_objects = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack<Integer> Stack_object = new Stack<>();
            for (int j = 0; j < this.size; j++) {
                Stack_object.push(j);
            }
            Stack_objects.add(Stack_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack Stack_object = Stack_objects.get(i);
            while(!Stack_object.isEmpty()) {
                Stack_object.pop();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("pop()", new Integer((int)totalTime));
        this.Semantics.put("pop()", "deleteAtEnd");
    }

    public void deleteRandom_1() {
        ArrayList<Stack<Integer>> Stack_objects = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack<Integer> Stack_object = new Stack<>();
            for (int j = 0; j < this.size; j++) {
                Stack_object.push(j);
            }
            Stack_objects.add(Stack_object);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            Stack Stack_object = Stack_objects.get(i);
            while(!Stack_object.isEmpty()) {
                Stack_object.remove(Stack_object.size() / 2);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("remove(I)", new Integer((int)totalTime));
        this.Semantics.put("remove(I)", "deleteRandom");
    }

    public void accessAtHead_1() {
        Stack<Integer> Stack_object = new Stack<Integer>();
        for (int j = 0; j < this.size; j++) {
            Stack_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = Stack_object.get(0);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(0)", new Integer((int)totalTime));
        this.Semantics.put("get(0)", "accessAtHead");
    }

    public void accessAtEnd_1() {
        Stack<Integer> Stack_object = new Stack<Integer>();
        for (int j = 0; j < this.size; j++) {
            Stack_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = Stack_object.peek();
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("peek()", new Integer((int)totalTime));
        this.Semantics.put("peek()", "accessAtEnd");
    }

    public void accessRandom_1() {
        Stack<Integer> Stack_object = new Stack<Integer>();
        for (int j = 0; j < this.size; j++) {
            Stack_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Integer elem = Stack_object.get(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("get(I)", new Integer((int)totalTime));
        this.Semantics.put("get(I)", "accessRandom");
    }

    public void search_1() {
        Stack<Integer> Stack_object = new Stack<Integer>();
        for (int j = 0; j < this.size; j++) {
            Stack_object.push(j);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < this.multiplicity; i++) {
            for (int j = 0; j < this.size; j++) {
                Stack_object.contains(j);
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        this.Profile.put("contains", new Integer((int)totalTime));
        this.Semantics.put("contains", "search");
    }
}
