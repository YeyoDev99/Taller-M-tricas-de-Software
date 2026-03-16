@echo off
echo === Compilando FastFoodApp (Consola) ===

if not exist out mkdir out

javac -d out src\model\Producto.java src\model\Cliente.java src\repository\FastFoodRepository.java src\view\ConsoleView.java src\controller\MenuController.java src\Main.java

if %errorlevel% == 0 (
    echo [OK] Compilacion exitosa
    echo.
    echo === Ejecutando aplicacion ===
    cd out
    java Main
) else (
    echo [ERROR] Fallo la compilacion
    pause
)
