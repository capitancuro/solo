package com.keno.solo.game_logic.game_engine.plot_four;

import java.util.ArrayList;
import java.util.List;

import com.keno.solo.game_logic.game_engine.boardgame.BoardPosition;
import com.keno.solo.game_logic.game_engine.boardgame.Boardgame;
import com.keno.solo.game_logic.game_engine.plot_four.PlotFourPiece;

public abstract class PlotFour extends Boardgame<PlotFourPiece>
{
    protected final int ROWS = 6;
    protected final int COLS = 7;

    protected boolean red_turn = true;
    
    public PlotFour
    (
        String name,
        String description,
        List<String> genres
    )
    {
        super
        (
            name,
            "E",
            "Playable",
            description,
            genres,
            0
        );

        setBoard();
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

   private boolean isWithinBounds(int r, int c) 
   {
    return r >= 0 && r < ROWS && c >= 0 && c < COLS;
   }

    /**
     * Helper: Scans in ONE direction until it hits an edge or a different piece.
     */
    private int countDirection(BoardPosition<PlotFourPiece> pos, int dx, int dy) 
    {
        int count = 0;
        int r = pos.getRow() + dx;
        int c = pos.getCol() + dy;

        while (isWithinBounds(r, c) && board.get(r).get(c).getBoard_Piece() == pos.getBoard_Piece()) 
        {
            count++;
            r += dx;
            c += dy;
        }
        return count;
    }

    /**
     * Helper: Combines forward and backward counts for a single vector.
     */
    private int countInLine(BoardPosition<PlotFourPiece> pos, int dx, int dy) 
    {
        // Start at 1 (the piece just played) + count both ways
        return 1 + countDirection(pos, dx, dy) + countDirection(pos, -dx, -dy);
    }

    
    public PlotFourPiece win(BoardPosition<PlotFourPiece> position, int x, int y, int n) 
    {
        // 1. Define the vectors as DATA (Horizontal, Vertical, Diagonal 1, Diagonal 2)
        // This replaces the recursive 'n' logic.
        int[][] directions = {
            {0, 1},  // Horizontal
            {1, 0},  // Vertical
            {1, 1},  // Diagonal (Top-Left to Bottom-Right)
            {1, -1}  // Diagonal (Bottom-Left to Top-Right)
        };

        // 2. Iterate through the directions
        for (int[] dir : directions) 
        {
            int dx = dir[0];
            int dy = dir[1];

            // Check if this specific vector has 4 in a row
            if (countInLine(position, dx, dy) >= 4) 
            {
                return position.getBoard_Piece();
            }
        }

        // If the loop finishes with no return, there is no winner
        return null;
    }
}
