# ConwayGameOfLifeKt - Это реализация клеточного автомата [Джона Конвея](https://ru.wikipedia.org/wiki/Конвей,_Джон_Хортон) - [игра Жизнь](https://ru.wikipedia.org/wiki/%D0%98%D0%B3%D1%80%D0%B0_%C2%AB%D0%96%D0%B8%D0%B7%D0%BD%D1%8C%C2%BB)


## Клеточный автомат:
  Игра проводится на математической модели называемой [клеточным автоматом](https://ru.wikipedia.org/wiki/Клеточный_автомат)  \
  если вкратце, то клеточный автомат это модель  \
  каждая ячейка которой зависит от состояния соседних ячеек 
  
  
## Правила игры:
  Игра проводится в соответствии с правилами B3S23 (Born - 3, Save - 23): \
  то есть ячейка рождается если вокруг имеются 3 живые клетки (не больше, не меньше)    
  и сохраняет свою жизнь если возле нее есть 2, 3 живых ячейки \
  (ячейки и клетки в данном контексте синонимы) 