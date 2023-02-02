import java.io.*;

public class Stack {
    private Object[] sc = new Object[4];
    private int topOfTheStack = -1;

    public Stack(Object[] sc) {
        this.sc = sc;
    }

    public Stack(Object[] sc, int topOfTheStack) {
        this.sc = sc;
        this.topOfTheStack = topOfTheStack;
    }

    public Stack() {
    }

    public Object[] getSc() {
        return sc;
    }

    public void setSc(Object[] sc) {
        this.sc = sc;
    }

    public void addToStack(Object o) {
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == null) {
                sc[i] = o;
                topOfTheStack += 1;
                return;
            }
        }
    }

    public Object getLast() {
        return sc[topOfTheStack];
    }

    public void removeLast() {
        sc[topOfTheStack] = null;
        topOfTheStack -= 1;
    }

    public Object copyLast() {
        Object lastObj = sc[topOfTheStack];
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.txt"))) {
            oos.writeObject(lastObj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object lastObjCopy = null;
        try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream("temp.txt"))) {
            lastObjCopy = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File f = new File("temp.txt");
        f.delete();

        return lastObjCopy;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != null) {
                result += sc[i];
                if (sc[i + 1] != null) {
                    result += ",";
                }
            }
        }
        return "StackContainer{" +
                "sc=" + result +
                '}';
    }
}
