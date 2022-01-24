#include <iostream>

int main()
{
    int amount_bits = 0;
    amount_bits = cantidad_bits();
    return 0;
}

int cantidad_bits()
{
    std::string bits[] = {
        "1 bit",
        "2 bits",
        "3 bits",
        "4 bits",
        "5 bits",
        "7 bits",
        "8 bits"};
    int value = 0;
    for (int i = 0; i < 8; i++)
    {
        std::cout << i;
    }
    std::cout << "Seleccione la cantidad de bits: ";
    std::cin >> value;
    return bits[value - 1];
}