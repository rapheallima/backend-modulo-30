# Módulo 30: VendaDAO - Gerenciamento de Vendas

O `VendaDAO` é uma classe responsável pela manipulação de dados das vendas no banco de dados. Ela implementa métodos para inserir, consultar, cancelar e finalizar vendas, além de associar produtos à venda.

## Funcionalidades principais:

- **Cadastrar Venda**: Insere uma nova venda e os produtos associados na tabela `TB_VENDA` e `TB_PRODUTO_QUANTIDADE`.
- **Consultar Venda**: Realiza a consulta de uma venda específica, retornando a venda e os produtos associados.
- **Cancelar/Finalizar Venda**: Atualiza o status da venda para "CANCELADA" ou "CONCLUÍDA", respectivamente.
- **Consultar Todos**: Retorna todas as vendas no banco de dados.

## Detalhes de Implementação:

- **SQL dinâmico**: Utiliza consultas SQL preparadas para manipulação segura de dados.
- **Associação de Produtos**: A venda pode ter múltiplos produtos associados, sendo registrada na tabela `TB_PRODUTO_QUANTIDADE`.
- **Exclusão não permitida**: A exclusão de vendas não é suportada por esse DAO.

## Exceções Tratadas:

- **DAOException**: Em casos de falhas de conexão ou execução de SQL.
- **TipoChaveNaoEncontradaException**: Para lidar com chaves não encontradas durante a operação.

## Dependências:

- `ProdutoQuantidadeFactory` e `VendaFactory` para a conversão de `ResultSet` em objetos de domínio.

