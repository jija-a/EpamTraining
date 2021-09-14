# Оператор `BREAK`
([[Операторы управления]])
Оператор языка Java `break`, может применяться в следующих случаях:
-   Для завершения последовательности операторов в операторе `switch`, что было рассмотрено в [[Оператор `switch`|операторе `switch`]]
-   Его можно использовать для выхода из [[Циклы|цикла]].
-   Можно применять в качестве "цивилизованной" формы оператора безусловного перехода `goto`.

### 1. Применение оператора break для выхода из цикла
```java
public class BreakLoop1 {
    public static void main(String[] args) {
        int i = 0, n = 100;

        while (i < n) {
            if (i == 10) {
                break;
            }
            System.out.println("i: " + i++);
        }
        System.out.println("Цикл завершен.");
    }
}
```

Следует отметить, что оператор `break` не предназначен в качестве обычного средства выхода из цикла. Для этого служит условное выражение в цикле. Этот оператор следует использовать для выхода из цикла только в особых случаях. Также оператор `break` следует использовать только внутри цикла.

### 2. Применение оператора break для выхода из внутреннего цикла
```java
public class BreakLoop2 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("Пpoxoд " + i + " : ");
            for (int j = 0; j < 100; j++) {
                if (j == 10) {
                    break;
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("Циклы завершены");
    }
}
```

### 3. Оператор break с [[Метка|меткой]]
Рассмотрим применение оператора break с меткой. Этот вариант может использоваться в качестве цивилизованной формы оператора `goto`, которого нет в языке Java в отличие от некоторых других языков программирования.
```
break метка;
```

### 4. Применение break с меткой для выхода из вложенных циклов
В следующем коде три блока кода отмечены метками `first`, `second`, `third`. При достижении строки `break second;` мы выходим из блока `second`.
```java
public class BreakLoop3 {
    public static void main(String[] args) {
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Перед break.");
                    if (t) {
                        break second;
                    }
                    System.out.println("Этот код не будет выполнен.");
                }
                System.out.println("Этот код не будет выполнен.");
            }
            System.out.println("После второго блока.");
        }
    }
}
```

#JavaFundamentals
#VariablesAndOperators
#Java
