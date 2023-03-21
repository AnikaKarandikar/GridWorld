/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int steps2;
    private int sideLength;
    private int turnSteps;
    private boolean isTurn;


    private boolean stretch1 = true;
    private boolean turn = false;
    private boolean stretch2 = false;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        steps2 = 0;
        turnSteps = 0;
        sideLength = length;
        isTurn = false;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        
       if(stretch1)
       {
       
        if (steps < sideLength && canMove())
        {
			move();
			steps++;
		}
        else
        {
            stretch1 = false;
            turn = true;
            turn();
        }
       }
       else if(turn)
       {
            if(turnSteps<sideLength && canMove())
            {
                move(); 
                turnSteps++; 
            }
            else 
            {
                setDirection(getDirection() +135);
                turn = false;
                stretch2 = true;
                //System.out.println(isTurn + "");
            }
       }
       else if(stretch2)
       {
            if(steps2 < sideLength && canMove())
            {
                move();
                steps2++;
            }
            else 
            {
                stretch2 = false;
            }

       }

    }
    
    /**
     * Turns the bug 45 degrees to the left without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() -135);
    }

}
