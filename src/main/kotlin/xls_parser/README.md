# fin_monitor_xls_parser
Минимальные набор классов для чтения таблицы xls  и вытягивания списка данных по организациям

1. Умеет:
    1. Читать файл по полному пути ("С\\test\\test2\\1.xls")
    2. Парсить файл:
        - [x] Вытягивать организацию (Регномер и название)
        - [x] Вытягивать доп поля в допольнительные массивы
        - [x] Обрабатывать пустой рег номер

1. Не Умеет:
    - [x] Остальное


- [ ] Внедрение выполнено


Зависимости
 1. Kotlin plugin:
     id 'org.jetbrains.kotlin.jvm' version '1.4-M2'
 2. Dependencies: 
    implementation group: 'org.apache.poi', name: 'poi', version: '4.1.2'
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
