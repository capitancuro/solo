package com.keno.solo;

import java.util.Scanner;

import com.keno.solo.game.engine.plot_four.PlotFourOffline;

public class App 
{
    public static void main(String[] args) 
    { 
        PlotFourOffline off = new PlotFourOffline();
        Scanner scanner = new Scanner(System.in);
        int col = 0;
        while(col != -1)
        {
                for(int r = 0; r < 6; r++)
                {
                    for(int c = 0; c < 7; c++)
                    {
                        System.out.print(off.getBoard().get(r).get(c).getUnit() == null? "[ ]" : "[1]");
                    }
                    System.out.println();
                }

                System.out.println("Input column");
                col = scanner.nextInt();

                if(col > -1 && col < 7)
                {
                    off.move(col);
                }

        }
        scanner.close();
    }
}