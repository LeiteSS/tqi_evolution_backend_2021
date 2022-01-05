<p align="center">
  <a href="https://www.tqi.com.br">
    <img src="./img/logo.png" width="180">
  </a>
</p>

*Back-end* desenvolvido para o **TQI Evolution 2022**, onde foi possivel obter mais conhecimentos na Autenticação de usuarios usando o *Json Web Token*.

## Funcionalidades
|        Nome          |    Descrição                                                                                                         |
|----------------------|----------------------------------------------------------------------------------------------------------------------|
| Cadastro de Usuario  | Deve ser possivel cadastrar um usuario usando:email, nome, endereço completo, RG, CPF e senha                        | 
| Login                | O usuario deve conseguir logar usando: email e senha                                                                 |
| Solicitação de Empréstimos    | O usuario deve conseguir pedir empréstimos fornecendo o valor do empréstimos, data da primeira parcela e quantidade de parcelas |
| Listar Empréstimos   | Deve ser possivel listar os empréstimos que foram solicitados pelo usuario antes autenticado  |             
| Detalhar Empréstimos | Deve ser possivel detalhar determinado empréstimo                                                                   |  

## Rotas
|      Método      |  Rota                           |
|------------------|---------------------------------|
| `POST`           | `/api/v1/signUp`                |
| `POST`           | `/api/v1/signIn`                |
| `GET`            | `/api/v1/me`                    |
| `POST`           | `/api/v1/loans`                 |
| `GET`            | `/api/v1/loans`                 |
| `GET`            | `/api/v1/loans/{id}`            |






