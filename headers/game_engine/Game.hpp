#include <string>
#include <vector>

class Game
{
    protected:
    std::string name, rating, type, description;
    std::vector<std::string> genres;
    int price;
    
    public:

    Game
    (
        std::string name,
        std::string rating,
        std::string type,
        std::string description,
        std::vector<std::string> genres,
        int price
    );

    std::string getName() const;
    std::string getRating() const;
    std::string getType() const;
    std::string getDescription() const;
    std::vector<std::string> getGenres() const;
    int getPrice() const;
};