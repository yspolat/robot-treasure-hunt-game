import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int boardSize;
    private ArrayList<GameObject> gameObjects;
    private Player player;
    private Robot robot;
    private Treasure treasure;
    private final int DEFAULT_DISTANCE = 0;

    public Game(int boardSize) {
        this.boardSize = boardSize;

        robot = new Robot(generateRandomPosition(), generateRandomPosition());
        treasure = new Treasure(generateRandomPosition(),generateRandomPosition());
        player = new Player(generateRandomPosition(), generateRandomPosition(), DEFAULT_DISTANCE);
        player.setPreviousDistance((int) calculateDistance());

        Tree tr1 = new Tree(generateRandomPosition(),generateRandomPosition());
        Tree tr2 = new Tree(generateRandomPosition(),generateRandomPosition());
        House h1 = new House(generateRandomPosition(),generateRandomPosition());

        gameObjects = new ArrayList<>();
        gameObjects.add(robot);
        gameObjects.add(treasure);
        gameObjects.add(tr1);
        gameObjects.add(tr2);
        gameObjects.add(h1);

        checkCoordinates();
    }

    public void play () {
        int turn = 10;
        int x = 0;
        int y = 0;

        Scanner sc1 = new Scanner(System.in);

        for (int i = 1; i <= turn ; i++) {
            System.out.println("Turn " + i);
            System.out.print("You are in position" + " x:" + player.getPosX() + " y:" + player.getPosY());

            System.out.print("\nPlease enter position x for player:");
            x = sc1.nextInt();

            System.out.print("Please enter position y for player:");
            y = sc1.nextInt();

            if(checkPlayerMove(x, y)) {
                player.setPosX(x);
                player.setPosY(y);
            }

            robot.setPosX(generateRandomPosition());
            robot.setPosY(generateRandomPosition());
            checkRobotMove(robot.getPosX(),robot.getPosY());

            if (calculateDistance() > boardSize / 2) {
                System.out.println("You are getting far to the treasure");
            }else {
                System.out.println("You are getting closer to the treasure");
            }

            if(i==10){
                System.out.println("Tie game!");
            }

        }
    }

    private int generateRandomPosition () {
        Random rnd = new Random();
        return rnd.nextInt(boardSize);
    }

    private double calculateDistance () {
        double distance = Math.sqrt(Math.pow((player.getPosX() - treasure.getPosX()), 2) +
                Math.pow((player.getPosY() - treasure.getPosY()), 2));

        return Math.abs(distance);
    }

    private boolean checkPlayerMove (int x, int y) {
        if(robot.getPosX() == x && robot.getPosY() == y){
            System.out.println("You hit the robot and lost the game!");
            System.exit(0);
        }
        if (x < 0 || x > boardSize || y < 0 || y > boardSize) {
            System.out.println("You cannot go there!");
            return false;
        }

        for (int i = 0; i < gameObjects.size(); i++) {
            if(gameObjects.get(i).getClass().getCanonicalName().equals("Tree") ||
                    gameObjects.get(i).getClass().getCanonicalName().equals("House")){
                    if(gameObjects.get(i).getPosX() == x && gameObjects.get(i).getPosY() == y){
                        System.out.println("You cannot go there, there is a " + gameObjects.get(i).getClass().getCanonicalName());
                        return false;
                    }
            }
            if (gameObjects.get(i).getClass().getCanonicalName().equals("Treasure")) {
                if(gameObjects.get(i).getPosX() == x && gameObjects.get(i).getPosY() == y) {
                    System.out.println("You won the game!!!");
                    System.exit(0);
                }
            }
        }

        return true;
    }

    private void checkRobotMove (int x, int y) {
        for (int i = 0; i < gameObjects.size(); i++) {
            if (gameObjects.get(i).getClass().getCanonicalName().equals("Treasure")) {
                if(robot.getPosX() == gameObjects.get(i).getPosX() && robot.getPosY() == gameObjects.get(i).getPosY()){
                    System.out.println("Robot found the treasure!\n" +
                            "You lost the game");
                    System.exit(0);
                }
            }
        }

    }

    private void checkCoordinates () {
        int z=0;
        boolean flag = false;
        boolean flag2 = true;

        do {
            flag = false;
            flag2 = true;
            for (int i = 0; i < gameObjects.size(); i++) {
                z = i;
                for (int j = ++z ; j < gameObjects.size(); j++) {
                    if(gameObjects.get(i).getPosX() == gameObjects.get(j).getPosX()
                            && gameObjects.get(i).getPosY() == gameObjects.get(j).getPosY()) {

                        gameObjects.get(i).setPosX(generateRandomPosition());
                        gameObjects.get(i).setPosX(generateRandomPosition());

                        gameObjects.get(j).setPosX(generateRandomPosition());
                        gameObjects.get(j).setPosX(generateRandomPosition());

                        flag2 = false;
                    }
                }

                if(i == gameObjects.size()-1 && flag2 == true) {
                    flag = true;
                }
            }
        } while(!flag);
    }

    public static void main(String[] args) {
        int boardSize = 0;

        while (boardSize < 5) {
            System.out.print("Please enter the board size :");
            Scanner sc1 = new Scanner(System.in);
            boardSize = sc1.nextInt();

            if(boardSize < 5) {
                System.out.println("Board size cannot be less than 5 cells");
            }
        }
        Game g1 = new Game(boardSize);
        g1.play();
    }
}
