from roman_converter import RomanConverter

def main():
    converter = RomanConverter()

    while True:
        roman_input = input("Enter a Roman numeral (or 'exit' to quit): ").upper()

        if roman_input == 'EXIT':
            break

        try:
            converted_number = converter.roman_to_integer(roman_input)
            print(f"The numeric value of {roman_input} is: {converted_number}")
        except KeyError:
            print(f"Invalid Roman numeral: {roman_input}")

if __name__ == "__main__":
    main()
