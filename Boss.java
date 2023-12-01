import greenfoot.*;

public class Boss extends Actor {
    private int Hp = 50;
    
    public void act() {
        // Check if the Boss is still alive

        MyWorld myworld = (MyWorld) getWorld();
        if (Hp > 0) {
            checkCollision();
        } else {
            getWorld().removeObject(this);
            for(int i = 0; i < 20; i++){
                myworld.increaseScore();
            }
        }
    }
    
    private void checkCollision() {
        if (isTouching(Bullet.class)) {
            Hp--; // Decrement HP when touched by a Bullet
            removeTouching(Bullet.class); // Remove the Bullet upon collision
        }
    }
}
