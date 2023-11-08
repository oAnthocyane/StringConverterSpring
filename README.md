# Тестовое задание на Java.

## Содержание

- [Условие](#Условие)
- [Описание приложения](#описание-приложения)
- [Документация](#Документация)
- [Запуск](#Запуск)
- [Связаться со мной]()



## Условие 
Условие данной задачи доступно по данной [ссылке](https://docs.google.com/document/d/1G_bNiKfEWXorOOry79s7UzPTNvYy4tRaYqnUnhPxuiU/edit).

## Описание приложения

Ответственным классом за принятие строки является [StringConverterController](ru/consulting/stringconverter/controller/StringConverterController.java). На вход для конвертации строки нужно предоставить json-file с параметром "line" и передать в этот параметр значение. Отправить запрос нужно POST-запросом на http://localhost:8080/string/convert.

Все тесты прописаны в папке [ru/consulting/stringconverter](ru/consulting/stringconverter).

Пример как должен выглядеть post-запрос:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"line": "abc"}' http://localhost:8080/string/convert
```

При отсутствии параметра "line" выведется 400 ошибка.
## Документация
Документация по всем классам оформлена в javadoc. 

Путь к документации: [build/docs/javadoc/index.html](./build/docs/javadoc/index.html).

## Запуск

Скачать openjdk version "17.0.5", после чего склонировать репозиторий, перейти в папку StringConverterSpring и запустить java -jar.
```bash
sudo apt install openjdk-17-jdk 
git clone https://github.com/oAnthocyane/StringConverterSpring.git
cd StringConverterSpring
java -jar ./target/StringConverter-0.0.1-SNAPSHOT.jar 

```

Для пересборки проекта использовать mvnw:
```bash
./mvnw clean package
```

## Связаться со мной

Telegram: https://t.me/Syrnick
