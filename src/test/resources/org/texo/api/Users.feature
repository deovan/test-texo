#language: pt
@api
Funcionalidade: Users

  @post
  Cenario: Realizar uma requisição do tipo POST para criar um novo usuário
    Dado que eu defina o path da url "/users"
    E defina o body da requisição com o seguinte conteúdo:
    """
    {
      "name": "alias odio sit",
      "username": "Lew",
      "email": "lew.pipi@teste"
    }
    """
    Quando eu realizar uma requisição do tipo "POST"
    Então o statuscode deve ser 201
    E deve retonar o id do usuário criado

  @post
  Esquema do Cenario: Realizar uma requisição do tipo PUT para editar um usuário


    Dado que eu defina o path da url "/users/5"
    E defina o body da requisição com o seguinte conteúdo:
    """
    <DATA>
    """
    Quando eu realizar uma requisição do tipo "PUT"
    Então o statuscode deve ser 200
    E deve retonar os dados do usuário editado
    """
    <DATA>
    """
    Exemplos:
      | DATA                                                       |
      | {"lat": "123","lng": "654",  "email": "lew.pipi@not.test"} |

