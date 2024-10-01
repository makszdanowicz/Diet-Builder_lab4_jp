
#  Diet Builder
Projekt jest realizacją laboratorium na Politechnice Wrocławskiej w ramach przedmiotu Języki Programowania. Przedstawia aplikację z interfejsem graficznym (GUI), wykonaną przy użyciu technologii JavaFX, która korzysta z bazy danych MySQL. W projekcie zastosowano również narzędzie Maven do zarządzania zależnościami i budowania aplikacji.

## Opis projektu
Diet Builder to aplikacja z graficznym interfejsem użytkownika, która umożliwia tworzenie spersonalizowanej listy zakupów. Aplikacja automatycznie oblicza liczbę kalorii każdego posiłku oraz poszczególnych produktów, co ułatwia planowanie diety i kontrolowanie spożycia kalorii. 





## Spis treści

 - [Funkcjonalność](#funkcjonalność)
 - [Zarządzanie Bazą Danych Produktów i Posiłków](#db---zarządzanie-bazą-danych-produktów-i-posiłków)
 - [Instalacja i uruchomenie aplikacji](#instalacja-i-uruchomenie-aplikacji)
 - [Interface aplikacji](#interface-aplikacji)
 - [Kontakt](#kontakt)


## Funkcjonalność
- użytkownik może dodawać, edytować i usuwać pojedyncze produkty definiując ich metadane, np.
```bash
Banan (100g):
- Węglowodany (g): 23,
- Tłuszcze (g): 0,
- Białko (g): 1,
- Kategoria: Owoce

```
- użytkownik może tworzyć, edytować i usuwać posiłki grupując określone produkty w sekcje (np. śniadanie, obiad, kolacja), np.
```bash
Nazwa: Lunch
Produkty:
- Bułka (100g) x 2
- Szynka (plaster) x 2
- Masło (5g) x 4

Nazwa: Podwieczorek v3
Produkty:
- Banan (100g) x 0.5

```
- Każdy posiłek prezentuje sumaryczną ilość przyjętych makroskładników oraz oblicza ilość kalorii (dynamicznie na podstawie makroskładników).

- Użytkownik ma możliwość wygenerowania listy zakupów dla określonych posiłków w formacie PDF. Produkty powinne być scalone oraz pogrupowane per kategoria (np. jeśli banan występował w kilku posiłkach, na liście zakupów powinien widnieć tylko jeden wpis w kategorii Owoce). 

## DB - Zarządzanie Bazą Danych Produktów i Posiłków

![Schemat Bazy Danych](docs/db_schema.png)

### Struktura Bazy Danych

Baza danych zawiera następujące tabele:

#### Tabela `products`
Ta tabela przechowuje informacje o produktach spożywczych.

- **`name`**: VARCHAR(60), Primary Key - nazwa produktu.
- **`mass`**: DOUBLE, Not Null - masa produktu w gramach.
- **`carbohydrates`**: DOUBLE, Not Null - zawartość węglowodanów w gramach.
- **`fats`**: DOUBLE, Not Null - zawartość tłuszczu w gramach.
- **`protein`**: DOUBLE, Not Null - zawartość białka w gramach.
- **`category`**: VARCHAR(100), Not Null - kategoria produktu.

#### Tabela `breakfast`
Ta tabela przechowuje informacje o produktach użytych do przygotowania śniadania.

- **`name`**: VARCHAR(60), Primary Key - nazwa produktu.
- **`mass`**: DOUBLE, Not Null - masa produktu w gramach.
- **`carbohydrates`**: DOUBLE, Not Null - zawartość węglowodanów w gramach.
- **`fats`**: DOUBLE, Not Null - zawartość tłuszczu w gramach.
- **`protein`**: DOUBLE, Not Null - zawartość białka w gramach.
- **`category`**: VARCHAR(100), Not Null - kategoria produktu.
- **`amount`**: DOUBLE, Not Null - ilość produktu w posiłku.

#### Tabela `lunch`
Ta tabela przechowuje informacje o produktach użytych do przygotowania obiadu.

- **`name`**: VARCHAR(60), Primary Key - nazwa produktu.
- **`mass`**: DOUBLE, Not Null - masa produktu w gramach.
- **`carbohydrates`**: DOUBLE, Not Null - zawartość węglowodanów w gramach.
- **`fats`**: DOUBLE, Not Null - zawartość tłuszczu w gramach.
- **`protein`**: DOUBLE, Not Null - zawartość białka w gramach.
- **`category`**: VARCHAR(100), Not Null - kategoria produktu.
- **`amount`**: DOUBLE, Not Null - ilość produktu w posiłku.

#### Tabela `dinner`
Ta tabela przechowuje informacje o produktach użytych do przygotowania kolacji.

- **`name`**: VARCHAR(60), Primary Key - nazwa produktu.
- **`mass`**: DOUBLE, Not Null - masa produktu w gramach.
- **`carbohydrates`**: DOUBLE, Not Null - zawartość węglowodanów w gramach.
- **`fats`**: DOUBLE, Not Null - zawartość tłuszczu w gramach.
- **`protein`**: DOUBLE, Not Null - zawartość białka w gramach.
- **`category`**: VARCHAR(100), Not Null - kategoria produktu.
- **`amount`**: DOUBLE, Not Null - ilość produktu w posiłku.

## Instalacja i uruchomenie aplikacji

**Krok 1: Sklonuj repozytorium**
    
Rozpocznij od sklonowania repozytorium Diet Builder na swój lokalny system. To stworzy kopię najnowszego kodu źródłowego projektu na twojej maszynie. Otwórz interfejs wiersza poleceń (CLI) i uruchom następujące polecenie:

```bash
  git clone https://github.com/makszdanowicz/Diet-Builder_lab4_jp.git
```

**Krok 2: Przejdź do  `Podłączenie bazy danych do projektu`**

**Krok 3: Przejdź do katalogu projektu**

Po sklonowaniu repozytorium przejdź do katalogu projektu:

```bash
    cd Diet-Builder
```
**Krok 4: Uruchom aplikację**

Uruchom aplikację przy pomocy pliku wykonywalnego JAR, wpisując do konsoli:
```bash
    java -jar "lokalizacja_projektu\target\nazwa_pliku_JAR.jar"
```

### Podłączenie bazy danych do projektu

**Krok 1:** Stworz bazę danych w MySQL i zaimportuj plik `diet_schema.sql`

**Krok 2:** W katalogu `/src/main/resources/` stwróz plik konfiguracyjny o nazwie `config_db.properties`


**Krok 3:** Skonfiguruj plik `config_db.properties`, aby ustawić dane logowania do bazy danych.

```bash
db.url=jdbc:mysql://localhost:3306/database_name
db.username=your_database_username
db.password=your_database_password
```

Upewnij się, że ten plik został dodany do .gitignore, aby chronić dane logowania.


## Interface aplikacji
**Screenshot głównego menu aplikacji:**
![App Screenshot](docs/menu_screenshoot.png)

**Przykład funkcjonalności głównego menu programu:**
![Function_Screenshot](docs/productmenu_function.png)

**Przykład generacji listy zakupów:**
![ShopList_Screenshot](docs/shoplist.png)


## Kontakt

W przypadku pytań proszę skontaktować się ze mną:

- email: zdanowiczmm@gmail.com
- LinkedIn: http://www.linkedin.com/in/maksim-zdanovich
