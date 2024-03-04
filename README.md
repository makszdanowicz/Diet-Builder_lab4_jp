:no_entry:***Working version of projects is availaible on branch*** - `pdf_saver_version`

## Treść programowa
Zaprojektowanie i implementacja aplikacji z graficznym interfejsem użytkownika (z wykorzystaniem podstawowych komponentów do budowy formularzy).

## Cel zajęć
Celem zajęć jest doskonalenie umiejętności programowania obiektowego oraz opanowanie technik budowania aplikacji oferujących graficzny interfejs użytkownika.
```
Od wersji Java SE 9 pakiet `javax.swing` został przeniesiony do modułu `java.desktop`.
JavaFX została usunięta z oficjalnego SDK od wersji 11.

```
Domyślnie implementacja może wykorzystywać:
* pakiet javax.swing (Java SE ≤ 8),
* moduł java.desktop (JavaSE  ≥ 9) - zalecane,
* JavaFX (Java SE ≤ 11),
* Zewnętrzna biblioteka [OpenJFX](https://openjfx.io/)

Niezależnie od wykorzystanej technologi aplikacja powinna być umieszczona w pojedynczym i wykonywalnym pliku JAR. Tworząc aplikację należy w szczególności przemyśleć kwestię usuwania obiektów (jak powinny zachować się powiązane encje) oraz kwestię persystencji danych.
Dodatkowo potrzebna okaże się umiejętność dołączenia zewnętrznych plików JAR (np. do tworzenia PDF lub generowania wizualizacji).


## Grupa B
Celem projektu jest stworzenie aplikacji typu Diet Builder posiadających następujące funkcjonalności:
* użytkownik może dodawać, edytować i usuwać pojedyncze ***produkty*** definiując ich metadane, np.
```bash

Banan (100g):
- Węglowodany (g): 23,
- Tłuszcze (g): 0,
- Białko (g): 1,
- Kategoria: Owoce

```
* Użytkownik może tworzyć, edytować i usuwać ***posiłki*** grupując określone produkty w sekcje (np. śniadanie, obiad, kolacja), np.
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
* Każdy posiłek powinen prezentować sumaryczną ilość przyjętych makroskładników oraz obliczać ilość kalorii (dynamicznie na podstawie makroskładników),
* Użytkownik ma możliwość wygenerowania ***listy zakupów*** dla określonych posiłków w formacie PDF. Produkty powinne być scalone oraz pogrupowane per kategoria (np. jeśli `banan` występował w kilku posiłkach, na liście zakupów powinien widnieć tylko jeden wpis w kategorii `Owoce`). 

# Credits
[Strona Pana Doktora Tomasza Kozłowskiego](https://khozzy.notion.site/Laboratorium-4-GUI-Swing-JavaFX-87aee7ba695448a09f85f65f16dd5d1a)
