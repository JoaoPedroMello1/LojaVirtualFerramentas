# Documento de referencia para o uso do pacote conector

## Nesse documento, serão inclusas descrições das classes, dos metodos pertencentes a elas e como usa-los

### Atualizar
Classe responsavel por atualizar os dados da tabela linha a linha

* tabela(String tabela, String campo, String valor, int id) 
Funciona com quatro parametros: tres strings que definem a tabela, o campo e o valor a ser atualizados, respectivamente, e um int, que define qual id sofrerá a alteração 

### Cadastro
Classe que efetua o cadastro dos dados na tabela. Ela tem um metodo para cada tabela, ou seja: clientes, pet, agenda e estoque

* cliente(String nome, String telefone, String endereco)
Metodo para cadastrar o cliente. Leva tres strings como parametro, que são o nome do cliente, telefone e endereço

* pet(String nome_pet, String raca, String especie, String porte, int fk_cliente)
Metodo para cadastrar o pet. O metodo consome quatro strings, que são, respectivamente o nome do pet, a raça, a especie (cachorro, gato, peixe, etc) o porte e um int, que é o id relacionado ao id do tutor (verificar a tabela de clientes para saber qual id colocar)

* agenda(String data, String hora, String servico, int fk_pet)
Metodo para cadastrar os agendamentos do pet. Utiliza quatro parametros, sendo tres strings para a data (aceita valores como dd/mm/aaaa ou dd-mm-aaaa ou dd.mm.aaaa), hora (aceita as seguintes entradas "hh:mm" ou "hhHmm") e serviço e um int que deve ser relacionado ao id do pet que receberá o serviço

* estoque(String produto, int quantidade)
Metodo para cadastrar os produtos no estoque. Leva dois parametros: uma string, para o nome/tipo do produto e um int para a quantidade do produto

### Conexao
Classe pai, que efetua a conexão com o banco. 

* conectar()
Metodo responsavel por fazer a conexão com o banco. Esse metodo é usado pelas outras classes, logo, não deve ser utilizado.

### Deletar
Classe que efetua, linha a linha, a exclusão dos dados da tabela selecionada

* dados(String tabela, int id)
Metodo responsavel pela exclusão da linha selecionada. Ele leva dois parametros, um parametro de String, que identifica qual tabela sofrerá a exclusão e outro com o id para definir qual linha será excluida

### Listagem
Metodo para ler e imprimir os dados das tabelas. Possui metodos exclusivos para cada tabela do banco

* cliente()
Lista o conteudo da tabela clientes

* pet()
Lista o conteudo da tabela pets, relacionando a tabela clientes

* agenda()
Lista o conteudo da tabela agenda, relacionando a tabela pet

* estoque()
Lista o conteudo da tabela estoque
*
