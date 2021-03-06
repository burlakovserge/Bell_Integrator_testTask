# Задача: Написать генератор текстовых отчётов.

+ отчет должен быть разбит на страницы определённой ширины и высоты
+ страницы отделяются друг от друга отдельной строкой содержащей один единственный символ ~
+ высота страницы не включает себя разделитель страниц
+ заголовок и данные внутри колонки должны быть выравнены влево
+ заголовки и данные в строке отделяются друг от друга символом |
+ ширина колонок фиксирована в символах
+ для заполнения неиспользованного места справа добавляются пробелы
+ заголовки колонок должны быть повторены на каждой странице 
+ строки данных в отчете отделяются друг от друга (и от заголовка) строкой символов -
+ для перехода на новую строку должен использоваться системный разделитель строк
+ ширина страницы не включает в себя разделитель строк 
+ если заголовок или значение не умещается в отведённое место, то значение должно быть принудительно разбито
+ разбиенние должно производиться по границе слов, если это возможно
+ если разбиение по границе слов невозможно - то разбивать прямо посередине слова
+ границей слова является любой символ кроме букв и цифр
+ настройки подаются в виде ХМЛ файла (см. пример в settings.xml)
+ данные подаются в виде TAB-delimited файла в кодировке UTF-16 (см. пример в source-data.tsv)
+ результат должен быть записан в файл в кодировке UTF-16
+ использовать нужно язык Java
+ разрешается использовать любые готовые библиотеки
+ все остальные нюансы, не детализированные выше, остаются на усмотрение разработчика
+ все решения, принятые разработчиком, должны быть описаны в сопроводительной записке
+ разрешается менять любое требование
+ любые изменения к требованиям должны быть описаны в сопроводительной записке

## Образец настроек

Ширина: 32
Высота: 12
Колонки:
- Номер, 8 символов
- Дата, 7 символов
- ФИО, 7 символов

см. src/main/resources/settings.xml

## Образец настроек исходных данных

Внимание, здесь данные даны с кавычками и запятыми. В файле нет кавычек и в качестве разделителей используется табуляция!

 1. "1", "25/11", "Павлов Дмитрий"
 2. "2", "26/11", "Павлов Константин"
 3. "3", "27/11", "Н/Д"
 4. "4", "28/11", "Ким Чен Ир"
 5. "5", "29/11/2009", "Юлианна-Оксана Сухово-Кобылина"

см. src/main/resources/source-data.tsv

## Пример вызова генератора

java Generator.class settings.xml source-data.tsv example-report.txt
Для проверки работы программы, файлы settings.xml и source-data.tsv должны находиться в одной папке с исполнительным файлом.