# Обобщения (`Generic`)

1. ### [[Обобщенные интерфейсы]]
2. ### [[Обобщенные методы]]
3. ### [[Использование нескольких универсальных параметров]]
4. ### [[Обобщенные конструкторы]]

Обобщения - это параметризованные типы. С их помощью можно объявлять классы, интерфейсы и методы, где тип данных указан в виде параметра. Обобщения добавили в язык [[безопасность типов]].

```java
class Account<T>{

 private T id;
 private int sum;
 
 Account(T id, int sum){
  this.id = id;
  this.sum = sum;
 }

 public T getId() {
  return id;
 }

 public int getSum() {
  return sum; 
 }

 public void setSum(int sum) {
  this.sum = sum; 
 }
}
```


#Java 
#JavaFundamentals 
#Generic