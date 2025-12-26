package com.keno.solo.game_logic.game_engine.plot_four;

import java.util.ArrayList;
import java.util.List;

import com.keno.solo.game_logic.game_engine.boardgame.BoardPosition;
import com.keno.solo.game_logic.game_engine.plot_four.PlotFour;

public class PlotFourOffline extends PlotFour
{
   public PlotFourOffline
   (
    String name,
    String description,
    List<String> genres
   )
   {
    super
    (
        name,
        description,
        genres
    );
   }

   @Override
   protected void setBoard() 
   {
    board = new ArrayList<ArrayList<BoardPosition<PlotFourPiece>>>();
    for (int row = 0; row < ROWS; row++)
    {
        board.add(new ArrayList<BoardPosition<PlotFourPiece>>());
        for (int col = 0; col < COLS; col++)
        {
            board.get(row).add(new BoardPosition<PlotFourPiece>(row, col, null));
        }
    }
   }


   @Override
   public BoardPosition<PlotFourPiece> move(int col) 
   {
    for (int row = ROWS - 1; row >= 0; row--)
    {
        if (board.get(row).get(col).getBoard_Piece() == null)
        {
            if (red_turn)
            {
                board.get(row).get(col).setBoard_Piece(PlotFourPiece.RED);
                red_turn = !red_turn;
                return board.get(row).get(col);
            }
            else
            {
                board.get(row).get(col).setBoard_Piece(PlotFourPiece.YELLOW);
                red_turn = !red_turn;
                return board.get(row).get(col);
            }
        }
    }

       return null;
   }

   @Override
   public PlotFourPiece win
   (
    BoardPosition<PlotFourPiece> position, 
    int x, 
    int y, 
    int n
    )
    {
        int row = position.getRow(), col = position.getCol(), count = 0;

        while ((row >= 0 && col >= 0) && (row < ROWS && col < COLS))
        {
            if (board.get(row).get(col).getBoard_Piece() == position.getBoard_Piece())
            {
                count++;
            }
            else if (row != position.getRow() || col != position.getCol() || count == 4)
            {
                break;
            }

         row += x;
         col += y;
        }

        row = position.getRow();
        col = position.getCol();

        while ((row >= 0 && col >= 0) && (row < ROWS && col < COLS))
        {
            if (board.get(row).get(col).getBoard_Piece() == position.getBoard_Piece() && (row != position.getRow() || col != position.getCol()))
            {
                count++;
            }
            else if (row != position.getRow() || col != position.getCol() || count == 4)
            {
                break;
            }

            row += x * -1;
            col += y * -1;
        }

        if (count == 4) return position.getBoard_Piece();

        if (n < 4)
        {
            if (x + y == -1) return win(position, x, 1, n + 1);
            else if (x + y == 0) return win(position, 0, y, n + 1);
            else return win(position, 1, y, n + 1);
        }
        
        return null;
    }
}
