# `JAVADOC`
Как правило, все существующие среды разработки `IDE` приложений `Java` предлагают решение по связыванию кода с документацией в процессе разработки с использованием `javadoc`. Для этого необходимо соответствующим образом написать комментарий к коду, т.е. документировать. `Java` комментарии необходимы как для комментирования программы, так и для составления или оформления документации.

*`javadoc` — это генератор документации в `HTML` - формате из комментариев исходного кода Java и определяет стандарт для документирования классов `Java`.*
Для создания доклетов и тэглетов, которые позволяют программисту анализировать структуру `Java`-приложения, `javadoc` также предоставляет `API`. В каждом случае комментарий должен находиться перед документируемым элементом.

При написании комментариев к кодам Java используют три типа комментариев:
```java
// однострочный комментарий; 
/* 
многострочный комментарий 
*/ 
/** 
комментирование документации 
*/
```

`javadoc` дескрипторы: `@author`, `@version`, `@since`, `@see`, `@param`, `@return`.

| Дескриптор                     | Применение                    | Описание                                     |
| ------------------------------ | ----------------------------- | -------------------------------------------- |
| @author                        | Класс, интерфейс              | Автор                                        |
| @version                       | Класс, интерфейс              | Версия. Не более одного дескриптора на класс |
| @since                         | Класс, интерфейс, поле, метод | Указывает, с какой версии доступно           |
| @see                           | Класс, интерфейс, поле, метод | Ссылка на другое место в документации        |
| @param                         | Метод                         | Входной параметр метода                      |
| @return                        | Метод                         | Описание возвращаемого значения              |
| @exception имя_класса описание | Метод                         | Описание исключения                          |
| @throws имя_класса описание    | Метод                         | Описание исключения                          |
| @deprecated                    | Класс, интерфейс, поле, метод | Описание устаревших блоков кода              |
| {@link reference}              | Класс, интерфейс, поле, метод | Ссылка                                       |
| {@value}                       | Статичное поле                | Описание значения переменной                 |
