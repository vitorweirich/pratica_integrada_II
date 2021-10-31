# REQUISITOS FUNCIONAIS

```
> - **Fun��o:** Manter funcion�rios
> - **Descri��o:** O sistema dever� permitir o manteinimento de funcion�rios.

> - **Fun��o:** Manter card�pios
> - **Descri��o:** O sistema dever� permitir o manteinimento de card�pios.

> - **Fun��o:** Manter estabelecimentos
> - **Descri��o:** O sistema dever� permitir o manteinimento de estabelecimentos.

> - **Fun��o:** Manter itens do card�pio
> - **Descri��o:** O sistema dever� permitir o manteinimento de itens do card�pio.

> - **Fun��o:** Manter mesas
> - **Descri��o:** O sistema dever� permitir o manteinimento de mesas.

> - **Fun��o:** Manter comandas
> - **Descri��o:** O sistema dever� permitir o manteinimento de comandas.

> - **Fun��o:** Manter estoque (a pensar)
> - **Descri��o:** O sistema dever� permitir o manteinimento de estoque (a pensar).

> - **Fun��o:** Manter usu�rios
> - **Descri��o:** O sistema dever� permitir o manteinimento de usu�rios.

> - **Fun��o:** Consultar comandas
> - **Descri��o:** O sistema dever� permitir a visualiza��o de todas as comandas abertas.

> - **Fun��o:** Registro de logs
> - **Descri��o:** O sistema dever� disponibilizar um registro de logs referentes as contas a receber.

> - **Fun��o:** Consulta de m�tricas sobre o consumo de itens do card�pio
> - **Descri��o:** O sistema dever� disponibilizar informa��es sobre o consumo dos itens do card�pio.

# REQUISITOS N�O FUNCIONAIS

> **1.** A interface n�o dever� possuir cores e imagens agressivas

> **2.** O sistema dever� ser r�pido, permitindo um atendimento otimizado aos consumidores dos estabelecimentos

> **3.** O sistema dever� funcionar em ambiente web

> **4.** O sistema dever� ter um banco de dados compat�vel com o POSTGRES SQL

> **5.** O sistema n�o deve possuir erros de ortografia nas interfaces

> **5.** O sistema dever� funcionar na plataforma JAVA
 ```

# Seguindo o que o Jean passou

	O sistema dever� possibilitar o CRUD de Empresas  
	O sistema dever� possibilitar a inser��o de informa��es de Raz�o Social, CNPJ, Insc Estadual, Endere�o, Cidade e Fone de uma respectiva Empresa.
--- 
	O sistema dever� possibilitar o CRUD Categoria de Produtos  
	O sistema dever� possibilitar a inser��o da descri��o de uma respectiva categoria de produtos
--- 
	O sistema dever� possibilitar o CRUD de produtos
	O sistema dever� possibilitar a inser��o da descri��o descri��o, pre�o e categoria de um respectivo produto
--- 
	O sistema dever� possibilitar o CRUD de Mesas
	O sistema dever� possibilitar a inser��o da descri��o de uma respectiva mesa
---
	O sistema dever� possibilitar o CRUD de Comandas
	O sistema dever� possibilitar a inser��o da, mesa, produto, quantidade e valor pago de uma respectiva comanda
	O sistema dever� quando inserida uma nova comanda dever� gerar automaticamente o c�digo, a data e a hora de uma respectiva comanda
---
	O sistema dever� gerar de forma aut�noma os pedidos para a cozinha, a partir do lan�amento de itens em uma comanda
	O sistema dever� ao ser inserido um produto em um determinada comanda, gerar automaticamente uma tabela de Pedido com os dados de data e hora do pedido, c�digo da comanda, c�digo do produto, data e hora da finaliza��o do pedido e a quantidade do produto 
	O sistema dever� ao gerar a tabela de pedido, persistir os dados de data e hora do pedido, c�digo da comanda, c�digo do produto e quantidade do produto
	O sistema dever persistir a data e hora da finaliza��o do pedido quando o bot�o de finalizar pedido for acionado

```
Pedido (Cozinha)

* data pedido
* hora pedido
* comanda
* produto
* qtd
* data finaliza��o
* hora finaliza��o

* O sistema dever persistir a data e hora da finaliza��o do pedido quando o bot�o de finalizar pedido for acionado

* O sistema dever� persisitir a data e hora da inser��o do pedido de forma autom�tica.
```

	O sistema deve mascarar do usu�rio a digita��o de senhas.

	O sistema deve, em campos de data, permitir a escolha dela em um mini calend�rio.

	O sistema dever� permitir a consulta de produtos por categoria.

	O sistema dever� permitir a listagem dos itens de uma comanda

	O sistema dever� permitir o pagamento parcial de uma comanda

	O sistema dever� possibilitar a listagem de vendas de itens de uma determinada data

	O sistema receber� atrav�s de uma API os dados referente a UF e Cidades de uma UF. (CEP*)
	
```
* O sistema dever� gerar de forma aut�noma os pedidos para a cozinha, a partir do lan�amento de itens em uma comanda
```




RNF


	Os bot�es ou �cones de a��o dever�o possuir cores condizentes a aten��o que dever� ser dispensada pelo usu�rio.

	O sistema deve ser de f�cil uso
	
	O sistema deve ser intuitivo, ou seja, auto explicativo.
	
	O sistema deve prevenir a  ocorr�ncia de erros.
	
	O sistema deve auxiliar na corre��o de erros que venha a surgir.
	
	O sistema n�o deve apresentar imagens e cores agressivas.
	
	O sistema n�o deve permitir a possibilidade de SQL Injection
	
	Na interface de produ��o, na cozinha, s� devem aparecer na consulta, pedidos que n�o foram finalizados
	
	Na interface de Produ��o dever� haver um bot�o para identificar quando o pedido foi finalizado
	
	Nos cadastros de Mesas, Categoria, Produtos e Comanda dever� haver o c�digo da empresa solicitado
	
	Nas consultas de produtos n�o pode aparecer produtos de outra Empresa



