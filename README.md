**Instituto Federal de Educação, Ciência e Tecnologia da Paraíba**

**Campus Cajazeiras**

**Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas**

**Banco de dados II**

**Professor**: Francisco paulo de Freitas Neto

**Alunos**: José Ferreira 

<h3 align="center">
  Projeto: tecForum
</h3>




#### ROTEIRO PARA IMPLANTAR E UTILIZAR A APLICAÇÃO LOCALMENTE




1. Inicie o servidor de aplicação Java (prefeencialmente o `Payara`). 
2. Banco de dados

    2.a.  Crie um banco de dados Postgres com as seguintes informações para uso da solução:
          Dentro da pasta raiz do projeto va áte: /tecforum/src/main/resources/bd/  
    2.b


    | propriedade | valor |
    |-----|-----|
    | nome do banco | forum
    | user | postgres |
    | passwod | 12345 |
    | porta | 5432 |

    2.b. Utilize o arquivo presente no caminho `tecForum/src/main/resources/bd/database_create.sql` para construir as tabelas no banco de dados criado.


3. No terminal de linha de comando, estando na pasta raiz do projeto, execute `mvn clean install`.

4. Implante o módulo `projeto` no servidor. Logo em seguida à correta execução deste primeiro,
5. Despois de iniciados os módulos acima já será possível a solução web proposta já estará disponível em  [](http://localhost:8080/tecForum/).

    Foi inserido um usuário `admin` para início de uso do sistema, com as seguinte credenciais:
      - email: jose@gmail.com
      - senha: jf1234

<hr>

##### (*) o presente manual de implantação serve para o código disponível na branch `MASTER` deste repositório.  Para implantação no `Docker`, ver a branch [docker](https://github.com/joseferreira01/tecForum/branch/bDocker) deste repositório.
