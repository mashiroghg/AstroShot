import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private boolean keyWasPressed = false;
    public String[] keys = {"w", "a", "s", "d", "ENTER"};    
    public void act()
    {
        KeyCheck();
        Shoot();
    }
    //zum ueberpruefen welche tasten gedruegt sind
    private void KeyCheck(){
        if(Greenfoot.isKeyDown(keys[0])){
           if(Greenfoot.isKeyDown("SHIFT")){
              Movement("UP", 10);
            }else{
              Movement("UP", 5);           
            }
        }else if (Greenfoot.isKeyDown(keys[1])){
           if(Greenfoot.isKeyDown("SHIFT")){
              Movement("LEFT", 10);
            }else{
              Movement("LEFT", 5);           
            }
        }else if (Greenfoot.isKeyDown(keys[2])){
           if(Greenfoot.isKeyDown("SHIFT")){
              Movement("DOWN", 10);
            }else{
              Movement("DOWN", 5);           
            }
        }else if (Greenfoot.isKeyDown(keys[3])){
           if(Greenfoot.isKeyDown("SHIFT")){
              Movement("RIGHT", 10);
            }else{
              Movement("RIGHT", 5);           
            }
        }
    }
    
    private void Shoot(){
        if (Greenfoot.isKeyDown(keys[4])) {  
            if (!keyWasPressed) {
                // Führe die Aktion nur einmal aus
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet, getX(), getY());
                keyWasPressed = true;  // Verhindert wiederholte Ausführung
            }
        } else {
            keyWasPressed = false;  // Setzt zurück, wenn die Taste losgelassen wird
        }
    }
    
    
    private void Movement(String d, int speed){
        if(d == "up" || d == "UP"){
           setLocation(getX(), getY() - speed);
        }else if(d == "down" || d == "DOWN"){
           setLocation(getX(), getY() + speed);
        }else if(d == "right" || d == "RIGHT" ){
           setLocation(getX() + speed, getY());
        }else if(d == "left"  || d == "LEFT"){
           setLocation(getX() - speed, getY());
        }
    }
}
