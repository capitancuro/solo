#include <iostream>
#include <limits> // For clearing input buffer if needed
#include "game_engine/game_logic/boardgame/plot_four/PlotFourOffline.hpp"

void printBoard(const PlotFourOffline& game)
{
    auto board = game.getBoard();
    std::cout << "\n 0 1 2 3 4 5 6\n"; // Column guides
    std::cout << "===============\n";
    
    for (const auto& row : board)
    {
        std::cout << "|"; 
        for (const auto& spot : row)
        {
            PlotFourPiece p = spot.getBoardPiece();
            char c = ' '; // Empty space looks cleaner
            if (p == PlotFourPiece::RED) c = 'R';
            else if (p == PlotFourPiece::YELLOW) c = 'Y';
            
            std::cout << c << "|";
        }
        std::cout << "\n";
    }
    std::cout << "===============\n";
}

int main()
{
    PlotFourOffline game;
    int col;
    
    // We track this locally for display, knowing Red always starts.
    // The internal game logic manages the actual rules.
    std::string current_player = "RED"; 

    while (true)
    {
        printBoard(game);
        
        std::cout << "\n[" << current_player << "'s Turn]\n";
        std::cout << "Enter Column (0-6): ";
        
        // Basic Input Validation
        if (!(std::cin >> col)) {
            std::cout << "Invalid input. Please enter a number.\n";
            std::cin.clear();
            std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            continue;
        }

        // 1. Attempt Move
        auto last_pos = game.move(col);

        // 🚨 SENTINEL CHECK: Did the move fail?
        // If row is -1, the column was full or out of bounds.
        if (last_pos.getRow() == -1)
        {
            std::cout << "❌ Invalid Move! Column full or out of bounds. Try again.\n";
            // We 'continue' here so we don't switch turns or check win
            continue; 
        }

        // 2. Check Win (Only if move was valid)
        if (game.win(last_pos) != PlotFourPiece::NONE)
        {
            printBoard(game);
            std::cout << "\n🎉 WINNER: " << current_player << "! 🎉\n";
            break;
        }

        // 3. Switch Turn Display (Only if move was valid)
        current_player = (current_player == "RED") ? "YELLOW" : "RED";
    }

    return 0;
}