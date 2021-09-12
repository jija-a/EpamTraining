# Оператор `IF`
([[Операторы управления]])
Условный оператор `if` используется довольно часто в языке Java, сложно написать программу без его участия. Он используется с целью направления выполнение программы по двум разным ветвям:

### 1. If в Java
```java
if (booleanExpression) {
     System.out.println("In the if block");
}
```

### 2. Оператор if-else:
 ```java
if (booleanExpression) {
    System.out.println("Inside if block");
} else {
    System.out.println("Inside else block");
}
```

### 3. Оператор if-else-if:
```java
public class IfElse1 {
    public static void main(String[] args) {
        int month = 4; // April
        String season;
        if (month == 12 || month == 1 || month == 2) {
            season = "Winter";
        } else if (month == 3 || month == 4 || month == 5) {
            season = "Spring";
        } else {
            season = "Not a Month";
        }
        System.out.println("April is in the " + season + ".");
    }
}
```

#JavaFundamentals
#VariablesAndOperators