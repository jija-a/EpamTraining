# Метод `System.exit()`
Метод `System.exit()` используется в языке Java для завершения программы. Этот метод на вход принимает значение типа `int`. Обычно это `0`, что говорит о том, что программа завершается без ошибок. Любое другое значение говорит о том, что программа завершилась с ошибкой. 

Рассмотрим пример:
```java
public class SysExit {
    public static void main(String[] args) {
        System.out.println("Дo возврата.");
        method(true);
        System.out.println("Этот оператор выполняться не будет.");
    }

    public static void method(boolean flag) {
        if (flag) {
            System.exit(0);
        }
        System.out.println("Этот оператор метода выполняться не будет.");
    }
}
```

#JavaFundamentals
#VariablesAndOperators
#Java
