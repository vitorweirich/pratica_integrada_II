# REQUISITOS FUNCIONAIS

```
> - **Função:** Manter funcionários
> - **Descrição:** O sistema deverá permitir o manteinimento de funcionários.

> - **Função:** Manter cardápios
> - **Descrição:** O sistema deverá permitir o manteinimento de cardápios.

> - **Função:** Manter estabelecimentos
> - **Descrição:** O sistema deverá permitir o manteinimento de estabelecimentos.

> - **Função:** Manter itens do cardápio
> - **Descrição:** O sistema deverá permitir o manteinimento de itens do cardápio.

> - **Função:** Manter mesas
> - **Descrição:** O sistema deverá permitir o manteinimento de mesas.

> - **Função:** Manter comandas
> - **Descrição:** O sistema deverá permitir o manteinimento de comandas.

> - **Função:** Manter estoque (a pensar)
> - **Descrição:** O sistema deverá permitir o manteinimento de estoque (a pensar).

> - **Função:** Manter usuários
> - **Descrição:** O sistema deverá permitir o manteinimento de usuários.

> - **Função:** Consultar comandas
> - **Descrição:** O sistema deverá permitir a visualização de todas as comandas abertas.

> - **Função:** Registro de logs
> - **Descrição:** O sistema deverá disponibilizar um registro de logs referentes as contas a receber.

> - **Função:** Consulta de métricas sobre o consumo de itens do cardápio
> - **Descrição:** O sistema deverá disponibilizar informações sobre o consumo dos itens do cardápio.

# REQUISITOS NÃO FUNCIONAIS

> **1.** A interface não deverá possuir cores e imagens agressivas

> **2.** O sistema deverá ser rápido, permitindo um atendimento otimizado aos consumidores dos estabelecimentos

> **3.** O sistema deverá funcionar em ambiente web

> **4.** O sistema deverá ter um banco de dados compatível com o POSTGRES SQL

> **5.** O sistema não deve possuir erros de ortografia nas interfaces

> **5.** O sistema deverá funcionar na plataforma JAVA
 ```

# Seguindo o que o Jean passou

	O sistema deverá possibilitar o CRUD de Empresas  
	O sistema deverá possibilitar a inserção de informações de Razão Social, CNPJ, Insc Estadual, Endereço, Cidade e Fone de uma respectiva Empresa.
--- 
	O sistema deverá possibilitar o CRUD Categoria de Produtos  
	O sistema deverá possibilitar a inserção da descrição de uma respectiva categoria de produtos
--- 
	O sistema deverá possibilitar o CRUD de produtos
	O sistema deverá possibilitar a inserção da descrição descrição, preço e categoria de um respectivo produto
--- 
	O sistema deverá possibilitar o CRUD de Mesas
	O sistema deverá possibilitar a inserção da descrição de uma respectiva mesa
---
	O sistema deverá possibilitar o CRUD de Comandas
	O sistema deverá possibilitar a inserção da, mesa, produto, quantidade e valor pago de uma respectiva comanda
	O sistema deverá quando inserida uma nova comanda deverá gerar automaticamente o código, a data e a hora de uma respectiva comanda
---
	O sistema deverá gerar de forma autônoma os pedidos para a cozinha, a partir do lançamento de itens em uma comanda
	O sistema deverá ao ser inserido um produto em um determinada comanda, gerar automaticamente uma tabela de Pedido com os dados de data e hora do pedido, código da comanda, código do produto, data e hora da finalização do pedido e a quantidade do produto 
	O sistema deverá ao gerar a tabela de pedido, persistir os dados de data e hora do pedido, código da comanda, código do produto e quantidade do produto
	O sistema dever persistir a data e hora da finalização do pedido quando o botão de finalizar pedido for acionado

```
Pedido (Cozinha)

* data pedido
* hora pedido
* comanda
* produto
* qtd
* data finalização
* hora finalização

* O sistema dever persistir a data e hora da finalização do pedido quando o botão de finalizar pedido for acionado

* O sistema deverá persisitir a data e hora da inserção do pedido de forma automática.
```

	O sistema deve mascarar do usuário a digitação de senhas.

	O sistema deve, em campos de data, permitir a escolha dela em um mini calendário.

	O sistema deverá permitir a consulta de produtos por categoria.

	O sistema deverá permitir a listagem dos itens de uma comanda

	O sistema deverá permitir o pagamento parcial de uma comanda

	O sistema deverá possibilitar a listagem de vendas de itens de uma determinada data

	O sistema receberá através de uma API os dados referente a UF e Cidades de uma UF. (CEP*)
	
```
* O sistema deverá gerar de forma autônoma os pedidos para a cozinha, a partir do lançamento de itens em uma comanda
```




RNF


	Os botões ou ícones de ação deverão possuir cores condizentes a atenção que deverá ser dispensada pelo usuário.

	O sistema deve ser de fácil uso
	
	O sistema deve ser intuitivo, ou seja, auto explicativo.
	
	O sistema deve prevenir a  ocorrência de erros.
	
	O sistema deve auxiliar na correção de erros que venha a surgir.
	
	O sistema não deve apresentar imagens e cores agressivas.
	
	O sistema não deve permitir a possibilidade de SQL Injection
	
	Na interface de produção, na cozinha, só devem aparecer na consulta, pedidos que não foram finalizados
	
	Na interface de Produção deverá haver um botão para identificar quando o pedido foi finalizado
	
	Nos cadastros de Mesas, Categoria, Produtos e Comanda deverá haver o código da empresa solicitado
	
	Nas consultas de produtos não pode aparecer produtos de outra Empresa



