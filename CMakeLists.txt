cmake_minimum_required(VERSION 3.14)
project(SoloArcade LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)

# --- 1. Fetch FTXUI ---
include(FetchContent)
FetchContent_Declare(ftxui
  GIT_REPOSITORY https://github.com/ArthurSonzogni/ftxui
  GIT_TAG v5.0.0
)
FetchContent_MakeAvailable(ftxui)

# --- 2. Find Notcurses (The one you manually built) ---
find_package(PkgConfig REQUIRED)
pkg_check_modules(NOTCURSES REQUIRED notcurses notcurses++)

# --- 3. Build your Arcade App ---
add_executable(solo_app app/src/main.cpp)

# Link everything together
target_link_libraries(solo_app 
    PRIVATE ftxui::screen ftxui::dom ftxui::component
    PRIVATE ${NOTCURSES_LIBRARIES}
)

target_include_directories(solo_app PRIVATE ${NOTCURSES_INCLUDE_DIRS})