# Sobre o projeto

- Tetris feito no console com ascii
- O jogo funciona como deveria funcionar, porém sistemas como pontuação e ajuste de velocidade não estão disponiveis (não pretendo adicionar), apenas a gameplay base está feita
- Cada pixel do jogo consiste em uma String com 3 espaços pintados

# Imagem do jogo

![Imagem do jogo](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/tetrisTSPIN.png)

# Como jogar

- (importante) Ao executar o game, uma telinha invisível irá abrir, ela é usada apenas para capturar o teclado, o foco do pc deve ser mantido nela, caso contrario, os comandos não funcionarão
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

- É possivel escolher as peças disponiveis no jogo e o tamanho do campo, basta mudar o construtor e o vetor de Peças no metodo main
  
  ![Main](https://github.com/Domiuau/TetrisConsole/blob/master/Assets/Main.png)
  

# Tecnologias utilizadas
- Java
- Só java

# Como executar o jogo

- Apenas procure pela classe "Main" onde se encontra o metodo main, e execute

# Requisitos

- NÃO tente rodar no mac, o jogo quebra totalmente, e no linux não sei o que acontece
- É recomendado que o console seja exibido em modo janela, assim é possivel maximizar o tamanho dele
- Caso esteja em um monitor com resolução menor que 1920x1080, diminua o tamanho do campo no método main (O padrão é 10x20) ou diminua o tamanho dos caracteres de seu console
  
```bash
# clonar repositório
git clone https://github.com/Domiuau/TetrisConsole
```

# Autor

Guilherme Mateus Sousa Santos
