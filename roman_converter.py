class RomanConverter:
    def __init__(self):
        self.roman_numerals = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

    def roman_to_integer(self, roman):
        converted_number = 0
        prev_value = 0

        for numeral in reversed(roman):
            value = self.roman_numerals[numeral]
            if value < prev_value:
                converted_number -= value
            else:
                converted_number += value
            prev_value = value

        return converted_number
