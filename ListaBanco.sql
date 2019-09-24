USE Imobiliaria;



/*
	1.	Escreva um comando que exiba o código do imóvel, a descrição do imóvel, o estado, a cidade, 
	a zona e o bairro dos imóveis ordenados por estado, cidade, zona e bairro. 
*/

SELECT 
	Imovel.CodImovel, Imovel.Imovel, Imovel.Estado, Imovel.Cidade, Zona.Zona, Bairro.Bairro
FROM 
	Imovel 
	INNER JOIN Bairro ON Bairro.CodBairro = Imovel.CodBairro
	INNER JOIN Zona ON Zona.CodZona = Bairro.CodZona
ORDER BY 
	Imovel.Estado, 
	Imovel.Cidade, 
	Zona.Zona, 
	Bairro.Bairro;



/*
	2.	Escreva um comando que exiba a listagem dos bairros que não têm imóveis cadastrados.
*/

SELECT 
	Bairro.Bairro 
FROM 
	Bairro 
WHERE 
	Bairro.Bairro NOT IN 
	(SELECT DISTINCT Bairro.Bairro FROM Bairro INNER JOIN Imovel ON (Imovel.CodBairro = Bairro.CodBairro));



/*
	3.	Escreva um comando que exiba o nome da zona, o nome dos bairros e a quantidade de imóveis disponíveis 
	em cada bairro ordenado por nome de zona e bairro.
*/


SELECT 
	COUNT(Imovel.CodImovel) AS [Qtd. Imóveis Disponíveis], Zona.Zona, Bairro.Bairro
FROM 
	Imovel 
	INNER JOIN Bairro ON Bairro.CodBairro = Imovel.CodBairro
	INNER JOIN Zona ON Zona.CodZona = Bairro.CodZona
WHERE 
	Imovel.Disponivel = 'S'
GROUP BY 
	Zona.Zona, 
	Bairro.Bairro
ORDER BY  
	Zona.Zona, 
	Bairro.Bairro;




/*
	4.	Escreva um comando que exiba o tipo do imóvel, a quantidade, o valor total 
	dos imóveis e o preço médio dos imóveis ordenado por tipo.
*/

SELECT 
	Imovel.CodImovelTipo,
	Imovel.PrecoVenda, 
	SUM(Imovel.PrecoVenda) AS [SomaPrecoImoveis],  
	AVG(Imovel.PrecoVenda) AS [PrecoMediaImoveis]
FROM 
	Imovel 
	INNER JOIN Bairro ON Bairro.CodBairro = Imovel.CodBairro
	INNER JOIN Zona ON Zona.CodZona = Bairro.CodZona
GROUP BY 
	Imovel.CodImovelTipo, 
	Imovel.PrecoVenda 
ORDER BY Imovel.CodImovelTipo;



/*
	5.	Escreva um comando que apresente as vendas realizadas calculando o desconto 
	dado na venda (diferença entre o valor do imóvel e o valor da venda).
*/


SELECT 
	Venda.CodVenda, 
	(Imovel.PrecoVenda - Venda.Valor) AS [Desconto], 
	Imovel.PrecoVenda AS [PrecoOriginal] 
FROM Venda 
INNER JOIN Imovel ON Imovel.CodImovel = Venda.CodImovel;



/*
	6.	Escreva um comando que exiba a data da venda, a descrição do imóvel, o nome do cliente, 
	o nome do corretor, o percentual de comissão e o valor da comissão sobre as vendas realizadas.
*/

SELECT 
	Venda.Data, 
	(CAST(Imovel.QtdQuarto AS VARCHAR) + ' Quartos, ' + CAST(Imovel.QtdBanheiro AS VARCHAR) + ' Banheiros, ' + CAST(Imovel.QtdVagaGaragem AS VARCHAR) + ' Vagas Garagem') AS [ImovelDescricao],
	(Imovel.Endereco + ', Cidade: '+ Imovel.Cidade + ', Bairro: ' + Bairro.Bairro + ' - ' + Zona.Zona ) AS [ImovelEnderecoCompleto], 
	Imovel.Imovel,
	Cliente.Cliente, 
	Corretor.Corretor, 
	Corretor.Comissao AS PercentualComissao, 
	(Venda.Valor * Corretor.Comissao / 100) AS ValorComissao
FROM Venda 
	INNER JOIN Imovel ON Imovel.CodImovel = Venda.CodImovel
	INNER JOIN Cliente ON Cliente.Codigo = Venda.CodCliente
	INNER JOIN Corretor ON Corretor.CodCorretor = Venda.CodCorretor
	INNER JOIN Bairro ON Imovel.CodBairro = Bairro.CodBairro
	INNER JOIN Zona ON Zona.CodZona = Bairro.CodZona;


/*
	7.	Escreva um comando que exiba o nome do corretor, o percentual de comissão e o valor da comissão sobre as vendas.
*/

SELECT 
	Corretor.Corretor, 
	Corretor.Comissao, 
	(Venda.Valor * Corretor.Comissao / 100) AS ValorComissao
FROM Venda 
	INNER JOIN Corretor ON Venda.CodCorretor = Corretor.CodCorretor;



/*
	8.	Escreva um comando que exiba o nome dos corretores que não realizaram vendas.
*/

SELECT Corretor.Corretor FROM Corretor WHERE Corretor.CodCorretor NOT IN (SELECT Venda.CodCorretor FROM VENDA);
