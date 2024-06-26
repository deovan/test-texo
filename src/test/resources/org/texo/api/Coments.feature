#language: pt

@api
Funcionalidade:  Comement API

  @get
  Cenario: Realizar uma requisição do tipo GET filtrando por name
    Dado que eu defina o path da url "/comments"
    E defina o atributo "name" com o valor "alias odio sit"
    Quando eu realizar uma requisição do tipo "GET"
    Então o statuscode deve ser 200
    E o email do objeto retornado deve ser "Lew@alysha.tv"
