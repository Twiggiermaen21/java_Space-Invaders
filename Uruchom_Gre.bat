@echo off
chcp 65001 >nul
echo 🚀 Kompilowanie i uruchamianie Space Invaders...
echo.

if not exist "target\classes" mkdir "target\classes"
javac --release 21 -d target\classes -sourcepath src\main\java src\main\java\com\mycompany\space_invaders\Space_Invaders.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ❌ Wystąpił błąd podczas kompilacji!
    pause
    exit /b %ERRORLEVEL%
)

echo ✅ Kompilacja zakończona sukcesem! Gra za chwilę się uruchomi...
echo.
java -cp target\classes com.mycompany.space_invaders.Space_Invaders
