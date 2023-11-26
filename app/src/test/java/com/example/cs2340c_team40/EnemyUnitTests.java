package com.example.cs2340c_team40;


import static org.junit.Assert.assertEquals;

import com.example.cs2340c_team40.Model.Enemy;
import com.example.cs2340c_team40.Model.EnemyFactory;
import com.example.cs2340c_team40.Model.MovePattern;
import com.example.cs2340c_team40.Model.PlayerDirection;
import com.example.cs2340c_team40.Model.Subscriber;

import org.junit.Test;

import java.util.ArrayList;

public class EnemyUnitTests {
    @Test
    public void createEnemyValid() {
        ArrayList<Subscriber> entities = new ArrayList<Subscriber>();
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(660);
        ghost.setY(860);
        int[] ghostArray = {0, 230, 0, 230};
        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'a');
        ghost.setMoveDirection(ghostPattern);
        entities.add(ghost);
    }

    @Test
    public void createEnemyUpdate() {
        EnemyFactory enemyCreator = new EnemyFactory();
        //Ghost Enemy
        Enemy ghost = enemyCreator.createEnemy("Ghost");
        ghost.setX(660);
        ghost.setY(860);
        int[] ghostArray = {0, 230, 0, 230};
        PlayerDirection ghostPattern = new MovePattern(ghost, ghostArray, 'a');
        ghost.setMoveDirection(ghostPattern);
        ghost.setX(655);
        assertEquals(ghost.getX(), 655);
        assertEquals(ghost.getY(), 860);
    }

    @Test
    public void testFactorySkeleton() {
        EnemyFactory factory = new EnemyFactory();
        Enemy e = factory.createEnemy("Skeleton");

        assertEquals(60, e.getHealth());
        assertEquals(10, e.getSpriteSize());
    }

    @Test
    public void testInvalidEnemyType() {
        EnemyFactory factory = new EnemyFactory();
        Enemy e = factory.createEnemy("Bat");

        assertEquals(null, e);
    }
}
