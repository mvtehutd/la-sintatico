# T2 - Analisador Sintático
Marcos Cardoso Vendrame - 790725 <br/>
Carlos Eduardo Nascimento dos Santos - 791029


## 1.	Programas Necessários
Para compilar e executar o programa, é necessário ter instalado na máquina o Java, o Maven e o Antlr4. 
Nas compilações e execuções realizadas nesse trabalho, as versões utilizadas para esses softwares foram:

- Java (JDK 17.0.1 e JDK 17.0.6)
- Apache Maven 3.9.2
- ANTLR 4.11.0

É possível que outras versões também sejam compatíveis, então verifique a compatibilidade caso já os tenha instalado na máquina.

## 2.	Compilação e Execução do Programa
Para compilar o código, acesse o diretório em que foi salvo o projeto em sua máquina pelo terminal.
 
   ![image](https://github.com/mvtehutd/la-sintatico/assets/100847921/0b1fe3d6-6275-4459-82b0-fbeb015f46a1)
 <p align="center"><i><b>Imagem 1:</b> Acessando o Diretório do Projeto</i></p>

Em seguida, execute o comando ```mvn package``` no terminal para que o Maven crie os arquivos e o programa com extensão *.jar* necessários.
  
   ![image](https://github.com/mvtehutd/la-sintatico/assets/100847921/0066461e-a7e2-4bc5-aae6-a0b317e02ca9)
<p align="center"><i><b>Imagem 2:</b> Realizando a Compilação</i></p>

![image](https://github.com/mvtehutd/la-sintatico/assets/100847921/cadce2ee-d697-4d2d-9e8d-43d0ffdcc652)
<p align="center"><i><b>Imagem 3:</b> Mensagem Indicando Sucesso na Compilação</i></p>

Com a compilação finalizada, é possível executar o programa. Para isso, o comando a ser realizado é:

```java -jar <caminho do compilador> <arquivo de entrada> <arquivo de saída>```

  Sendo que: </br>
-	```<caminho do compilador>``` é o caminho completo até o arquivo de extensão *.jar* criado, lembrando de escolher o com as dependências. Ele está localizado na pasta target:
 
 ![image](https://github.com/mvtehutd/la-sintatico/assets/100847921/53205879-8551-464e-be8d-026c009c25c6)
<p align="center"><i><b>Imagem 4:</b> Localizando o Compilador no Projeto</i></p>

-	```<arquivo de entrada>``` é o caminho completo até o arquivo de extensão *.txt* com o algoritmo a ser analisado.

 ![image](https://github.com/mvtehutd/la-sintatico/assets/100847921/350d091b-323a-401a-ad55-6f4d7fb66920)
<p align="center"><i><b>Imagem 5:</b> Exemplo de Arquivo de Entrada</i></p>

-	```<arquivo de saída>``` é o caminho completo até o arquivo de extensão *.txt* na qual serão salvos os resultados da análise.

 ![image](https://github.com/mvtehutd/la-sintatico/assets/100847921/e7e2df01-9b9f-4ed2-a206-0af9bd4e19cb)
<p align="center"><i><b>Imagem 6:</b> Exemplo de Arquivo de Saída</i></p>

Exemplo de como o analisador deve rodar:
```
java -jar c:\compilador\meu-compilador.jar c:\casos-de-teste\arquivo1.txt c:\temp\saida.txt
```
