# Sobre o projeto

- Tetris feito no console com ascii
- O jogo funciona como deveria funcionar, porém sistemas como pontuação e ajuste de velocidade não estão disponiveis (não pretendo adicionar), apenas a gameplay base está feita
- Cada pixel do jogo consiste em uma String com 3 espaços ("   " ou " . ") pintadas com uma das poucas cores disponiveis

# Imagem do jogo

![Imagem do jogo](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/tetrisTSPIN.png)

# Como jogar

- Seta para a direita: move a peça 1 espaço para a direita
- Seta para a esquerda: move a peça 1 espaço para a esquerda
- Seta para baixo: move a peça 1 espaço para baixo (a peça é fixada ao encostar em algo)
- Espaço: fixa a peça imediatamente na posição futura dela, representada por uma peça cinza
- Shift: guarda a peça atual para usar mais tarde
- Seta para cima: se possível, rotaciona a peça no sentido horário
- Ctrl esquerdo: se possível, rotaciona a peça no sentido anti-horário

# Funcionalidades da gameplay

- Ao lado esquerdo do jogo, a peça guardada usando o "Shift" é exibida
- Ao lado direito, as futuras peças em ordem
- Colisão
- Caso alguma peça chegue ao topo do campo, o jogo finalizará
- Prévia de onde a peça irá cair/fixar
  
![Prévia](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/previa.png)

- Rotação
  
![Rotação](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/rotacao.png)

- Quebra de linha
  
![Quebra de linha](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/quebraDeLinha.png)

- É possivel adicionar qualquer peça no jogo, seguindo as seguintes regras: ser uma matrix 4x4 e obedecendo o grid da seguinte forma:
  
![Criação de peça](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/exemploComoCriarPeca.png)

basta usar as constantes da classe "Espaco" para montar a peça, que ela funcionará normalmente com colisões como qualquer outra

![Peça maluca](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/PecaMaluca.png)








# Tecnologias utilizadas
## Back end
- Java
- Android SDK
- Firebase
- Firestore Database
- Firebase analytics

# Como executar o aplicativo

- O aplicativo está disponível gratuitamente para download em:
https://play.google.com/store/apps/details?id=com.yuneme.myapplicationz

![QRcode playstore](https://github.com/Domiuau/yunemeapp/blob/master/Assets/yuneme7.png)

- O aplicativo aparecerá desta forma:
  
![Como vai aparecer](https://github.com/Domiuau/yunemeapp/blob/master/Assets/yuneme8.png)

- Ao abrir, a seguinte tela será executada:
  
![Tela cadastro / login](https://github.com/Domiuau/yunemeapp/blob/master/Assets/yuneme6.png)
  
- Não é necessário criar conta para utilizar o aplicativo, basta entrar como visitante
  



# Autor

Guilherme Mateus Sousa Santos
