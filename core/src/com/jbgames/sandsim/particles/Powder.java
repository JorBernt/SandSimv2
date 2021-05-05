package com.jbgames.sandsim.particles;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public abstract class Powder extends Particle{

    public Powder(String type, Vector2 pos, float temperature, Vector2 velocity, float density, boolean solid) {
        super(type, pos, temperature, velocity, density, solid);
    }

    @Override
    public void update(float delta, Vector2 gravity, Particle[][] simGrid) {
        super.update(delta, gravity, simGrid);

        simGrid[posToGrid().y][posToGrid().x] = null;

        Vector2 curVec = new Vector2(getX(), getY());
        Vector2 newVec = new Vector2(getX(), getY());

        newVec.add(getVelocity().scl(delta));

        if(newVec.y >= simGrid.length) newVec.y = simGrid.length-1;

        Point curPos = new Point((int)curVec.x, (int)curVec.y);
        Point newPos = new Point((int)newVec.x, (int)newVec.y);

        boolean collided = false;

        while(curPos.x != newPos.x || curPos.y != newPos.y) {
            Point temp = new Point(curPos.x, curPos.y);
            if(curPos.x < newPos.x) curPos.x++;
            else if(curPos.x > newPos.x) curPos.x--;
            if(curPos.y < newPos.y) curPos.y++;
            else if(curPos.y > newPos.x) curPos.y--;
            if(simGrid[curPos.y][curPos.x] != null) {
                setPos(new Vector2(temp.x, temp.y));
                simGrid[temp.y][temp.x] = this;
                collided = true;
            }
        }

        if(collided) {
            Point p = posToGrid();
            while(true) {
               if (p.y + 1 >= simGrid.length) break;
               boolean b = false;
               if(simGrid[p.y+1][p.x] == null) {
                   p.y++;
                   b = true;
               }
               if(p.x-1 >= 0) {
                   if(simGrid[p.y+1][p.x-1] == null) {
                       p.x--;
                       p.y++;
                       b = true;
                   }
               }
               else if(p.x+1 < simGrid[0].length) {
                   if(simGrid[p.y+1][p.x+1] == null) {
                       p.x++;
                       p.y++;
                       b = true;
                   }
               }
               if(!b) break;
           }
            setPos(new Vector2(p.x, p.y));
            simGrid[newPos.y][newPos.x] = this;
        }
        else {
            setPos(newVec);
            simGrid[newPos.y][newPos.x] = this;
        }
    }

}
