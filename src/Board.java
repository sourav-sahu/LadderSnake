import java.util.HashMap;
import java.util.Map;

public class Board {
    int size;
    Map<Integer,Integer> jump = new HashMap<>();
    int snakeCount;
    int ladderCount;
    public Board(int size,int snakeCount, int ladderCount){
        this.size=size;
        this.snakeCount=snakeCount;
        this.ladderCount=ladderCount;
    }
    public void init(){

        while(jump.size()<ladderCount){
            createLadder();
        }
        while ((jump.size()-ladderCount)<snakeCount){
            createSnake();
        }
    }
    public Map<Integer,Integer> getJumps(){
        return this.jump;
    }

    private void createLadder() {
            int num1= (int) (Math.random()*size+1);
            int num2= (int) (Math.random()*size+1);
            if (num1<num2)
                jump.put(num1,num2);
            else if (num1>num2)
                jump.put(num2,num1);
    }
    private void createSnake() {
        int num1= (int) (Math.random()*size)+1;
        int num2= (int) (Math.random()*size)+1;
        if (num1<num2)
            jump.put(num2,num1);
        else if (num1>num2)
            jump.put(num1,num2);
    }
}
