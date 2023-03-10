package ru.stqa.pft.sandbox;

import java.util.*;

public class MyFirstProgram {
    public static void main(String[] args) {

                String[] cards =  {"1R", "2R", "3R", "4R","5R", "6R", "7R", "8R", "9R", "10R","1G", "2G", "3G", "4G","5G", "6G", "7G", "8G", "9G", "10G","1B", "2B", "3B", "4B","5B", "6B", "7B", "8B", "9B", "10B","1W", "2W", "3W", "4W","5W", "6W", "7W", "8W", "9W", "10W",};
                List<String> spisok = Arrays.asList(cards);
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                List<String> values = List.of(name.split(" "));

                if(values.size()!=3) {
                    if (!values.get(0).equals("start")) {
                        if (Integer.valueOf(values.get(1)) * Integer.valueOf(values.get(2)) > spisok.size()) {
                            System.out.println("Введите start N C");
                        }
                    }
                }

                int a = Integer.valueOf(values.get(1));
                int b = Integer.valueOf(values.get(2));

                String card = null;

                List<String> newListCards = new ArrayList<>();

                List<String> newListWithoutCurrentCard = new ArrayList<>();
                List<List<String>> spisokSpiskov = new ArrayList<>();

                for (int j=0; j<b; j++) {

                    for (int i = 0; i < a; i++) {
                        newListWithoutCurrentCard = new ArrayList<>();
                        card = null;
                        card = spisok.get(new Random().nextInt(spisok.size()));

                        newListCards.add(card);

                        for (int k = 0; k< spisok.size(); k++){
                            if (!(spisok.get(k).equals(card))) {
                                newListWithoutCurrentCard.add(spisok.get(k));
                            }
                        }
                        spisok = new ArrayList<>();

                        for( int s = 0; s<newListWithoutCurrentCard.size(); s++){
                            spisok.add(newListWithoutCurrentCard.get(s));
                        }

                    }
                    spisokSpiskov.add(newListCards);
                    newListCards = new ArrayList<>();
                }

                Scanner scanner2 = new Scanner(System.in);
                String name2 = scanner2.nextLine();
                List<String> values2 = List.of(name2.split(" "));
                String text =String.valueOf(spisokSpiskov.get(Integer.valueOf(values2.get(1))));

                if(values2.get(0).equals("get-cards")) {
                    if (Integer.valueOf(values2.get(1))>a) {
                        System.out.println("Введите get-cards C");
                    }
                }
                System.out.println(values2.get(1)+ " :" +text);
            }
        }


