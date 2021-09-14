# Оператор `SWITCH`
([[Операторы управления]])
Оператор `switch` в `Java`- это условный оператор, который дает возможность сравнивать переменную со списком значений.
```java
switch(выражение) {
    case значение1:
        // Блок кода 1
        break;
    case значение2:
        // Блок кода 2
        break;
    ...
    case значениеN:
        // Блок кода N
        break;
    default :
        // Блок кода для default
}
```

Выражение в switch должно иметь тип `char`, `byte`, `short`, `int`, `enum` (начиная с `Java 6`) или `String`(начиная с `Java 7`). Использование любого другого типа, например `float`, приведет к ошибке компиляции.

Для нескольких значений `case` можно указывать один блок.
```java
switch(выражение) {
    case значение1:
	case значение2:
	    // Блок кода 1 и 2
        break;
    default :
        // Блок кода для default
}
```

Если выражение в switch имеет тип меньший чем `int` (`byte`, `short` или `char`), `case` константа должна соответствовать этому типу. Например, следующий пример не откомпилируется:
```java
byte number = 2;
switch (number) {
    case 13:
    case 129://compiler error
}
```

Также нельзя использовать несколько case констант с одним и тем же значением. Следующий блок кода не откомпилируется:
```java
int number = 90;
switch (number) {
    case 50:
        System.out.println("50");
    case 50:
        System.out.println("50"); //compile error
    case 140:
        System.out.println("140");
    default:
        System.out.println("default");
}
```

#JavaFundamentals
#VariablesAndOperators
#Java
