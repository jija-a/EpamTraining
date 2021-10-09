# Цикл `DO-WHILE`
 `do-while` похож на цикл [[Цикл `While`| цикл `while`]] - это тоже цикл типа «пока», у него так же есть тело и условие, которые пишется после тела. Единственное отличие цикла `do-while` от [[Цикл `While`]] - условие проверяется после выполнения тела. Тело `do-while` выполнится хотя бы раз, даже если условие возвращает значение `false`.

```java
public class DoWhile {
    public static void main(String[] args) {
        int n = 10;
        do {
            System.out.println("Тик " + n--);
        } while (n > 0);
    }
}
```

