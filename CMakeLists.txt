cmake_minimum_required(VERSION 3.16)

project(solo LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# ==========================================
# 1. Qt Setup (Qt Quick / QML)
# ==========================================
set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON)
set(CMAKE_AUTOUIC ON)

# Hardcoded path for your specific Qt install
set(CMAKE_PREFIX_PATH "/home/curo/Qt/6.9.3/gcc_64")

# We now look for "Quick" (the QML engine) instead of "Widgets"
find_package(Qt6 REQUIRED COMPONENTS Quick)

# ==========================================
# 2. FTXUI Setup
# ==========================================
include(FetchContent)

FetchContent_Declare(ftxui
  GIT_REPOSITORY https://github.com/ArthurSonzogni/FTXUI
  GIT_TAG v5.0.0
)
FetchContent_MakeAvailable(ftxui)

# ==========================================
# 3. Source & Header Management
# ==========================================
# Recursively find C++ files
file(GLOB_RECURSE SOURCES "sources/*.cpp")

# Recursively find QML files (so they show up in your IDE)
file(GLOB_RECURSE QML_FILES "qml/*.qml")

# Define the executable using Qt's special wrapper
# (Handles internal hooks better than standard add_executable for QML apps)
qt_add_executable(solo 
    ${SOURCES} 
    ${QML_FILES}
)

# Point compiler to your headers folder
target_include_directories(solo PRIVATE headers)

# ==========================================
# 4. Linking
# ==========================================
target_link_libraries(solo PRIVATE
    Qt6::Quick
    ftxui::screen
    ftxui::dom
    ftxui::component
)

# ==========================================
# 5. Deployment / Copy QML Files
# ==========================================
# This copies the 'qml' folder from your source to the build folder
# so your app can load "qml/main.qml" at runtime without path errors.
add_custom_command(TARGET solo POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E copy_directory
    ${CMAKE_SOURCE_DIR}/qml
    ${CMAKE_BINARY_DIR}/qml
)