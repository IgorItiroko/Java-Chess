## Projeto Java-Chess ##
Autores:
Igor Shinji Itiroko
Bruno T. S. Lemes

#--------------------------#
Esse programa foi realizado no ambiente Eclipse IDE for Java Developers - 2021-06.

Para rodar o código deve-se clonar o programa da branch "main" para a sua máquina.

O programa funciona como um Xadres 2D.

Ao selecionar "Jogar" , o programa abrirá uma tela na qual você pode
digitar o nome dos jogadores.
Para fazer uma jogada, basta que o jogador do turno atual clique em sua peça e clique na
posição escolhida.
O jogo mostra quais são os possíveis movimentos que a peça selecionada pode realizar.

Há as opções de "Roque Direita" e "Roque Esquerda" caso um dos jogadores deseja realizar um
Roque. Se possível o roque desejado será realizado, caso não seja possível, nada acontecerá.
Há também as opções de "Desistir" e "Propor Empate" , onde para o primeiro caso,
o jogador desiste da partida, dando vítoria para o oponente e, para o segundo caso,
ele dá a escolha de aceitar o pedido de empate ao oponente, e , caso o oponente aceite, o
jogo terminará em empate.
A Opção "Simular último Jogo" abrirá uma nova tela onde o jogador pode simular o ultimo
jogo. Para fins de demonstração o arquivo "ultimoJogo" já possui um jogo salvo.
Caso os jogadores terminem um jogo, o arquivo será reescrito e salvara as jogadas desse
jogo para a simulação.
Cada situação de vítoria, derrota e empate possui a sua própria tela.

O "Xeque?" demonstra se o jogador do turno atual possui o seu rei em xeque.

Há a função de promoção do peão no jogo. Para realiza-la basta um peão chegar no fim
do tabuleiro para que ele ganhe o direito a ser promovido. As escolhas são Torre, Cavalo,
Bispo ou Rainha.

Ao selecionar "Instruções" , abrirá uma nova tela que explicará brevemente os movimentos de
cada peça e as condições de empate.

Ao selecionar "Sair" , o jogo fechará.