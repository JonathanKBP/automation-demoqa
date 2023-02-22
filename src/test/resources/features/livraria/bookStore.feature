#language: pt
@bookStore
Funcionalidade: Testar a página livraria
Como usuário
Eu quero acessar a livraria
Para adicionar um livro na minha coleção.

@TC003
Cenário: Acessa ebook da livraria
Dado que realizo o acesso ao endereço "login"
E realizo o login
Quando clico no botão Book Store
E no campo de pesquisa, busco pelo livro "Git Pocket Guide"
E clico no livro pesquisado
E valido os campos isbn e author
E clico no botão Add To Your Collection
E visualizo a mensagem "Book added to your collection."
E clico no botão Profile
Então visualizo o livro que foi selecionado
