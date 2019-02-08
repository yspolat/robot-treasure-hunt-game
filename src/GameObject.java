public abstract class GameObject {

    private int posX;
    private int posY;

    public GameObject(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract String toString();

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
