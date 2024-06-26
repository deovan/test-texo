#language: pt

Funcionalidade:  Guide menu

  @web
  Cenario: Validar foto do menu guia com id 6
    Dado que acesso a pagina "https://jsonplaceholder.typicode.com/guide/"
    E acesso o link "/albums/1/photos" na página
    Quando capturo os dados exibidos em tela
    Então valido os dados do objeto com id 6
