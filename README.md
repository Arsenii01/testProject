# testProject
Тестовое задание
Подсчет количества символов в полученной строке, результат в порядке убывания по встречаемости в строке


Для запуска потребуется склонировать репозиторий на локальную машину, введя в консоль

```git clone https://github.com/Arsenii01/testProject.git```

Далее необходимо открыть проект в IntellJIDEA современной версии и запустить проект.
Для тестирования можно использовать Postman или Insomnia.

### Формат входных данных
POST-запрос на адрес http://localhost:8080/main с JSON телом следующего формата:
```
{
	"string":"aaaasds"
}
```

### Формат выходных данных
JSON-ответ формата:
```
{
	"answer": "'a': 4, 's': 2, 'd': 1"
}
```
