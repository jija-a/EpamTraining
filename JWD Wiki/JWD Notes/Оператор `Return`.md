# Оператор `RETURN`
([[Операторы управления]])
Оператор `return` используется в языке Java для выполнения явного возврата из метода.

Если метод возвращает значение `void`, то оператор `return` не является необходимым. Его можно использовать при досрочном выходе из метода:
```java
public class Return1 {
    public static void main(String[] args) {
        boolean t = true;
        System.out.println("Дo возврата.");
        if (t) {
            return;
        }
        System.out.println("Этот оператор выполняться не будет.");
    }
}
```

Если же в объявлении метода указано, что он возвращает какое-то значение, то оператор return необходим. После него указывается значение, возвращаемое из метода:
```java
public class Return2 {
    public static void main(String[] args) {
        double d = getRandomValue(3);
        System.out.println(d);
    }

    public static double getRandomValue(int i) {
        return Math.random() * i;
    }
}
```

#JavaFundamentals
#VariablesAndOperators