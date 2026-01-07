template <typename BoardPiece>
struct BoardPosition
{
    private:
    BoardPiece* board_piece;
    int row, col;

    public:
    BoardPosition(int row, int col, BoardPiece* board_piece = nullptr);
    
    BoardPiece getBoardPiece() const;
    int getRow() const;
    int getCol() const;
};