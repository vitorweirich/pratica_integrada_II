# REQUISITOS FUNCIONAIS
	O sistema deverá possibilitar o CRUD de Empresas  
	O sistema deverá possibilitar a inserção de informações de Razão Social, CNPJ, Insc Estadual, Endereço, Cidade e Fone de uma respectiva Empresa.
--- 
	O sistema deverá possibilitar o CRUD Categoria de Produtos  
	O sistema deverá possibilitar a inserção da descrição de uma respectiva categoria de produtos
--- 
	O sistema deverá possibilitar o CRUD de produtos
	O sistema deverá possibilitar a inserção da descrição descrição, preço e categoria de um respectivo produto
---
	O sistema deverá possibilitar o CRUD de Comandas
	O sistema deverá possibilitar a inserção da mesa, produto, quantidade e valor pago de uma respectiva comanda
	O sistema deverá quando inserida uma nova comanda deverá gerar automaticamente o código, a data e a hora de uma respectiva comanda
---
	O sistema deverá gerar de forma autônoma os pedidos para a cozinha, a partir do lançamento de itens em uma comanda
	O sistema deverá ao ser inserido um produto em um determinada comanda, gerar automaticamente uma tabela de Pedido com os dados de data e hora do pedido, código da comanda, código do produto, data e hora da finalização do pedido e a quantidade do produto 
	O sistema deverá ao gerar a tabela de pedido, persistir os dados de data e hora do pedido, código da comanda, código do produto e quantidade do produto
	O sistema dever persistir a data e hora da finalização do pedido quando o botão de finalizar pedido for acionado

	O sistema deve mascarar do usuário a digitação de senhas.

	O sistema deve, em campos de data, permitir a escolha dela em um mini calendário.

	O sistema deverá permitir a consulta de produtos por categoria.

	O sistema deverá permitir a listagem dos itens de uma comanda

	O sistema deverá permitir o pagamento parcial de uma comanda

	O sistema deverá possibilitar a listagem de vendas de itens de uma determinada data

	O sistema receberá através de uma API os dados referente a UF e Cidades de uma UF. (CEP*)

# REQUISITOS NÃO FUNCIONAIS


	Os botões ou ícones de ação deverão possuir cores condizentes a atenção que deverá ser dispensada pelo usuário.

	O sistema deve ser de fácil uso
	
	O sistema deve ser intuitivo, ou seja, auto explicativo.
	
	O sistema deve prevenir a  ocorrência de erros.
	
	O sistema deve auxiliar na correção de erros que venha a surgir.
	
	O sistema não deve apresentar imagens e cores agressivas.
	
	O sistema não deve permitir a possibilidade de SQL Injection
	
	Na interface de produção, na cozinha, só devem aparecer na consulta, pedidos que não foram finalizados
	
	Na interface de Produção deverá haver um botão para identificar quando o pedido foi finalizado
	
	Nos cadastros de Categoria, Produtos e Comanda deverá haver o código da empresa solicitado
	
	Nas consultas de produtos não pode aparecer produtos de outra Empresa
	
	Na interface de entrega de Pedidos, deve existir uma listagem de pedidos finalizados e não entregues.
	
	Na interface de entrega de Pedidos, deve existir um botão que sinalize a entrega de um pedido.



