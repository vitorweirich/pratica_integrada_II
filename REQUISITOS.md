# REQUISITOS FUNCIONAIS
	O sistema dever� possibilitar o CRUD de Empresas  
	O sistema dever� possibilitar a inser��o de informa��es de Raz�o Social, CNPJ, Insc Estadual, Endere�o, Cidade e Fone de uma respectiva Empresa.
--- 
	O sistema dever� possibilitar o CRUD Categoria de Produtos  
	O sistema dever� possibilitar a inser��o da descri��o de uma respectiva categoria de produtos
--- 
	O sistema dever� possibilitar o CRUD de produtos
	O sistema dever� possibilitar a inser��o da descri��o descri��o, pre�o e categoria de um respectivo produto
---
	O sistema dever� possibilitar o CRUD de Comandas
	O sistema dever� possibilitar a inser��o da mesa, produto, quantidade e valor pago de uma respectiva comanda
	O sistema dever� quando inserida uma nova comanda dever� gerar automaticamente o c�digo, a data e a hora de uma respectiva comanda
---
	O sistema dever� gerar de forma aut�noma os pedidos para a cozinha, a partir do lan�amento de itens em uma comanda
	O sistema dever� ao ser inserido um produto em um determinada comanda, gerar automaticamente uma tabela de Pedido com os dados de data e hora do pedido, c�digo da comanda, c�digo do produto, data e hora da finaliza��o do pedido e a quantidade do produto 
	O sistema dever� ao gerar a tabela de pedido, persistir os dados de data e hora do pedido, c�digo da comanda, c�digo do produto e quantidade do produto
	O sistema dever persistir a data e hora da finaliza��o do pedido quando o bot�o de finalizar pedido for acionado

	O sistema deve mascarar do usu�rio a digita��o de senhas.

	O sistema deve, em campos de data, permitir a escolha dela em um mini calend�rio.

	O sistema dever� permitir a consulta de produtos por categoria.

	O sistema dever� permitir a listagem dos itens de uma comanda

	O sistema dever� permitir o pagamento parcial de uma comanda

	O sistema dever� possibilitar a listagem de vendas de itens de uma determinada data

	O sistema receber� atrav�s de uma API os dados referente a UF e Cidades de uma UF. (CEP*)

# REQUISITOS N�O FUNCIONAIS


	Os bot�es ou �cones de a��o dever�o possuir cores condizentes a aten��o que dever� ser dispensada pelo usu�rio.

	O sistema deve ser de f�cil uso
	
	O sistema deve ser intuitivo, ou seja, auto explicativo.
	
	O sistema deve prevenir a  ocorr�ncia de erros.
	
	O sistema deve auxiliar na corre��o de erros que venha a surgir.
	
	O sistema n�o deve apresentar imagens e cores agressivas.
	
	O sistema n�o deve permitir a possibilidade de SQL Injection
	
	Na interface de produ��o, na cozinha, s� devem aparecer na consulta, pedidos que n�o foram finalizados
	
	Na interface de Produ��o dever� haver um bot�o para identificar quando o pedido foi finalizado
	
	Nos cadastros de Categoria, Produtos e Comanda dever� haver o c�digo da empresa solicitado
	
	Nas consultas de produtos n�o pode aparecer produtos de outra Empresa
	
	Na interface de entrega de Pedidos, deve existir uma listagem de pedidos finalizados e n�o entregues.
	
	Na interface de entrega de Pedidos, deve existir um bot�o que sinalize a entrega de um pedido.



