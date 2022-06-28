Feature: Calculate formula using Calculator Application

  Scenario Outline: Formula results calculation
    Given I have a formula to calculate with operator <operator>
    When enter <numberX>, <numberY> and operator <operator> to calculate
    Then final calculation result is <result>

    Examples:
      | numberX | numberY | operator | result            |
      | 2       | 2       | ADD      | 4.0               |
      | 5       | 4       | SUBTRACT | 1.0               |
      | 4       | 3       | MULTIPLY | 12.0              |
      | 30      | 10      | DIVIDE   | 3.0               |
      | 2       | 0       | DIVIDE   | positive infinity |

