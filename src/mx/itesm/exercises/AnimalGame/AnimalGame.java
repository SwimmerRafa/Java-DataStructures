package mx.itesm.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import mx.itesm.util.BinaryNode;

public class AnimalGame{
	private static final String SIONEL = "? (s/n): ";
    private static final String DATA = "./game.txt";
    private static final String PREORDER = "PREORDER";
    private static final String INORDER = "INORDER";
    private static ArrayList<String> preorderArray;
    private static ArrayList<String> inorderArray;
    private static BinaryNode<String> gameTree;
    private static BinaryNode<String> current;
    private static Status status;
    private static Scanner sc;
    private static int pIndex;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        readData();
        //System.out.println(preorderArray);
        //System.out.println(inorderArray);
        System.out.println("Piensa en un animal.");
        System.out.println("Yo trataré de adivinar cúal es haciendote varias preguntas.");
        System.out.println();
        pIndex = 0;
        gameTree = generateGameTree(inorderArray, preorderArray, 0, inorderArray.size() - 1);
        startGame();
    }

    private static void startGame() {
        current = gameTree;
        status = Status.Active;

        while(status == Status.Active) {
            String question;
            boolean isLeaf = current.Left() == null && current.Right() ==null;
            question = isLeaf ? "Es un " + current.data() + SIONEL : current.data() + SIONEL;
            System.out.print(question);

            String response = sc.nextLine();
            if (response.equals("s")) {
                if (isLeaf) {
                    status = Status.Won;
                } else {
                    current = current.Left();
                    continue;
                }
            } else if (response.equals("n")) {
                if (isLeaf) {
                    status = Status.Lost;
                } else {
                    current = current.Right();
                    continue;
                }
            }else {
            	System.out.println("Prueba con s/n");

            }

            if (status ==  Status.Won) {
                System.out.println("¡¡¡Adiviné!!!");
                System.out.println();
                current = resetGame();
            } else if (status == Status.Lost) {
                String animal;
                String description;

                System.out.print("* Escribe el nombre del animal que pensaste: ");
                animal = sc.nextLine();
                System.out.print("* Escribe una afirmación que sea verdad para un(a) " + animal + ", pero que sea falsa para un(a) " + current.data() + ": ");
                description = sc.nextLine();

                BinaryNode<String> currentAnimal = new BinaryNode<>(current.data());
                current.setData(description);
                BinaryNode<String> newAnimal = new BinaryNode<>(animal);
                current.setLeft(newAnimal);
                current.setRight(currentAnimal);

                saveNewData();
                current = resetGame();
            }
        }
    }

    private static void saveNewData() {
        Path file = Paths.get(DATA);
        // Recorrido
        BinaryNode<String> current = gameTree;
        ArrayList<String> lines = new ArrayList<>();
        lines.add(PREORDER);
        preorder(current, lines);
        lines.add(INORDER);
        inorder(current, lines);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void preorder(BinaryNode<String> current, ArrayList<String> lines) {
        if (current == null) return;
        lines.add(current.data());
        preorder(current.Left(), lines);
        preorder(current.Right(), lines);
    }

    private static void inorder(BinaryNode<String> current, ArrayList<String> lines) {
        if (current == null) return;
        inorder(current.Left(), lines);
        lines.add(current.data());
        inorder(current.Right(), lines);
    }

    private static void readData() {
        BufferedReader reader;
        preorderArray = new ArrayList<>();
        inorderArray = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(DATA));
            String line = reader.readLine();
            while(line != null) {
                if (line.equals(PREORDER)) {
                    current = preorderArray;
                } else if (line.equals(INORDER)) {
                    current = inorderArray;
                } else if (line.isEmpty()) {
                    line = reader.readLine();
                    continue;
                } else {
                    current.add(line);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static BinaryNode<String> generateGameTree(ArrayList<String> inOrder, ArrayList<String> preOrder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;

        BinaryNode<String> root = new BinaryNode<String>(preOrder.get(pIndex));
        pIndex++;

        if(inStart == inEnd) return root;

        int index = getInorderIndex(inOrder, inStart, inEnd, root.data());
        root.setLeft(generateGameTree(inOrder,preOrder,inStart, index-1));
        root.setRight(generateGameTree(inOrder,preOrder,index+1, inEnd));
        return root;
    }

    public static int getInorderIndex(ArrayList<String> inOrder, int start, int end, String data){
        for(int i = start; i <= end; i++) {
            if(inOrder.get(i).equals(data)) return i;
        }
        return -1;
    }

    private static BinaryNode<String> resetGame() {
        System.out.print("Deseas jugar otra vez" + SIONEL);
        String response = sc.nextLine();
        System.out.println();
        if (response.equals("s")) {
            startGame();
            readData();
            pIndex = 0;
            return generateGameTree(inorderArray, preorderArray, 0, inorderArray.size() - 1);
        }
        else if(response.equals("n")) {
        	System.out.print("Adiós.");
        }else {
        	System.out.println("Prueba con s/n");
        	resetGame();
        }
        return null;
    }
}
