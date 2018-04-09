<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8" />
  <title>Ошибка</title>
  <link rel="stylesheet" href="resources/styles.css">
  <style>
    <%@include file="css/styles.css"%>
  </style>
</head>

<body>
<div class="wrapper">
  <div class="n_wrapper">
    <h1>Тестовое задание</h1>
    <p>Совпадений не найдено</p>
  </div>
  <div>
    <form action="/out" method="get">
      <center>
        <select class="button15" size="1" name="id" style="height: 50px">
          <option disabled>ФИО сотрудника</option>
          <option value = "0">Абрамов Данииил Викторович</option>
          <option value = "1">Балдин Сергей Артемьевич</option>
          <option value = "2">Бураков Антон Олегович</option>
          <option value = "3">Веревкин Максим Николаевич</option>
          <option value = "4">Воронцов Дмитрий Сергеевич</option>
          <option value = "5">Галушкин Александр Александрович</option>
          <option value = "6">Гаськов Виктор Михайлович</option>
          <option value = "7">Головнев Александр Юрьевич</option>
          <option value = "8">Голубев Александр Васильевич</option>
          <option value = "9">Голубец Денис Геннадьевич</option>
          <option value = "10">Данилов Максим Валерьевич</option>
          <option value = "11">Данильченко Евгений Васильевич</option>
          <option value = "12">Дядюшенко Александр Владимирович</option>
          <option value = "13">Егоров Алексей Юрьевич</option>
          <option value = "14">Екшибаров Сергей Владимирович</option>
          <option value = "15">Запасной Александр Сергеевич</option>
          <option value = "16">Зубарев Дмитрий Александрович</option>
          <option value = "17">Иванов Михаил Сергеевич</option>
          <option value = "18">Кайзер Федор Юрьевич</option>
          <option value = "19">Костин Константин Владимирович</option>
          <option value = "20">Ларионов Александр Николаевич</option>
          <option value = "21">Лесин Роман Павлович</option>
          <option value = "22">Лещуков Алексей Иванович</option>
          <option value = "23">Логачева Юлия Евгеньевна</option>
          <option value = "24">Ложкина Дарья Дмитриевна</option>
          <option value = "25">Лукьянов Александр Алексеевич</option>
          <option value = "26">Мамаев Дмитрий Викторович</option>
          <option value = "27">Манаков Александр Сергеевич</option>
          <option value = "28">Марширов Святослав Игоревич</option>
          <option value = "29">Мерзликин Владимир Сергеевич </option>
          <option value = "30">Миняйлов Владимир Александрович</option>
          <option value = "31">Неваров Григорий Олегович</option>
          <option value = "32">Неплюева Лариса Александровна</option>
          <option value = "33">Пензева Ольга Сергеевна</option>
          <option value = "34">Пенюшкин Александр Сергеевич</option>
          <option value = "35">Петраков Евгений Александрович</option>
          <option value = "36">Попов Александр Сергеевич</option>
          <option value = "37">Поскотинова Любовь Сергеевна</option>
          <option value = "38">Пустынников Владимир Владимирович</option>
          <option value = "39">Райшин Сергей Фагимович</option>
          <option value = "40">Рудь Анжелика Александровна</option>
          <option value = "41">Савченко Сергей Анатольевич</option>
          <option value = "42">Секирко Андрей Александрович</option>
          <option value = "43">Сердюк Андрей Анатольевич</option>
          <option value = "44">Сидорова Ирина Александровна</option>
          <option value = "45">Смирнов Константин Андреевич</option>
          <option value = "46">Сорокин Владислав Владимирович</option>
          <option value = "47">Стрельцов Антон Михайлович</option>
          <option value = "48">Ступин Станислав Иванович</option>
          <option value = "49">Суранова Дарья Александровна</option>
          <option value = "50">Талюкина Виктория Игоревна</option>
          <option value = "51">Троицкий Данила Владимирович </option>
          <option value = "52">Трофимчук Антон Алексеевич</option>
          <option value = "53">Фаст Артем Сергеевич</option>
          <option value = "54">Федянина Ольга Андреевна</option>
          <option value = "55">Харцызова Евгения Павловна</option>
          <option value = "56">Шипунова Мария Валерьевна</option>
        </select>
        <input class="button15" name="probability" type="text" placeholder="Введите вероятность" required>
        <input class = "button15" type="submit" value="Отправить" style="width:140px; height: 50px" />
        <br><br>
      </center>
    </form>
  </div>
</div>
