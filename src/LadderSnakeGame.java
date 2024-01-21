import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LadderSnakeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Player p4 = new Player();
        Queue<Player> queue = new ArrayDeque<>();
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        queue.add(p4);
        Board board = new Board(size,5,5);
        board.init();
        System.out.println(board.jump);
        int count=0;
        while (true) {
            count++;
            Player p = queue.remove();
            queue.add(p);
            int position = p.getPosition();
            int roll = Dice.rollDice();
            System.out.println(p.toString()+ "  "+position+" "+roll);
            if (position + roll > size) {
                continue;
            }
            position = position+roll;
            if (board.getJumps().containsKey(position))
                position=board.getJumps().get(position);
            p.setPosition(position);
            if (position==size){
                System.out.println("Winner"+p.toString());
                break;

            }

        }


        System.out.println(count);


    }
}