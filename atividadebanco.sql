create function SalesMonth(@mes int, @ano int)
returns table
as
return(select 
			Sales.SalesOrderDetail.ProductID as Identificador, 
            AVG(MONTH(Sales.SalesOrderHeader.OrderDate)) as Mês,
			AVG(YEAR(Sales.SalesOrderHeader.OrderDate)) as Ano, 
            COUNT(Sales.SalesOrderDetail.ProductID) as Quantidade_Total_Vendida, 
            AVG(Sales.SalesOrderDetail.UnitPrice) as Preço_Unitário_Médio, 
            SUM(Sales.SalesOrderDetail.UnitPriceDiscount) as Desconto_Total_Concedido,
			SUM(Sales.SalesOrderHeader.TotalDue) as Valor_Total_Vendido
            FROM Sales.SalesOrderDetail INNER JOIN Sales.SalesOrderHeader ON Sales.SalesOrderDetail.SalesOrderID = Sales.SalesOrderHeader.SalesOrderID
            WHERE YEAR(Sales.SalesOrderHeader.OrderDate) = @ano
            AND MONTH(Sales.SalesOrderHeader.OrderDate) = @mes
            group by ProductID)

select * from SalesMonth(2,2014) order by Identificador

/*
	02 - Identificador, Mês (atual), Ano (atual), Quantidade Total Vendida (mês anterior), Valor Total Vendido (mês anterior),
	Quantidade Total Vendida (mês informado), Valor Total Vendido (mês informado), percentual de aumento de vendas (em relação ao valor total vendido).
*/

create function SalesMonthIncrease(@mes int, @ano int)
returns @Func table(
    Identificador int not null,
    Mês_Atual int not null,
    Ano_Atual int not null,
    Quantidade_Total_Vendida_MesAnterior int not null,
    Valor_Total_Vendido_MesAnterior float not null,
    Quantidade_Total_Vendidada_MesAtual int not null,
    Valor_Total_Vendido_MesAtual float not null,
    percentual_de_aumento float not null
)
as
BEGIN
        DECLARE @mesAnterior int, @anoAnterior int
        set @mesAnterior = @mes -1
		set @anoAnterior = @ano
        if @mes = 1
        begin
        set @mesAnterior = 12
        set @anoAnterior = @ano -1
        end
		insert into @Func
		select
				atual.Identificador as Identificador,
				atual.Mês as Mês_Atual,
				atual.Ano as Ano_Atual,
				anterior.Quantidade_Total_Vendida as Quantidade_Total_Vendida_MesAnterior,
				anterior.Valor_Total_Vendido as Valor_Total_Vendido_MesAnterior,
				atual.Quantidade_Total_Vendida as Quantidade_Total_Vendidada_MesAtual,
				atual.Valor_Total_Vendido as Valor_Total_Vendido_MesAtual,
				((atual.Valor_Total_Vendido - anterior.Valor_Total_Vendido)/(anterior.Valor_Total_Vendido)*(100)) as percentual_de_aumento
				from SalesMonth(@mes, @ano) atual, SalesMonth(@mesAnterior, @anoAnterior) anterior where atual.Identificador = anterior.Identificador and atual.Valor_Total_Vendido > anterior.Valor_Total_Vendido
		return
end
drop function SalesMonthIncrease
select * from SalesMonthIncrease(01, 2014) order by Identificador
select * from SalesMonth(12,2013) order by Identificador



/* 3.	Crie uma função de nome CategorySalesMonth que recebe como parâmetro um numero de mês e um numero de ano e apresenta uma lista com os totais vendidos por categoria de produto no mês e 
	ano passados como parâmetro. A lista de apresentar as seguintes informações sobre as categorias: 
	Identificador da Categoria (ProductCategoryID), Nome da Categoria (ProductCategory), Mês, Ano, Quantidade de Itens Vendidos, Preço Unitário Médio do Item, Valor Total Vendido. 
*/
DROP FUNCTION CategorySalesMonth;
CREATE FUNCTION CategorySalesMonth(
	@month int,
	@year int
)
RETURNS TABLE
AS
RETURN
	SELECT psc.ProductCategoryID as 'Identificador da Categoria', pc.Name as 'Nome da Categoria', @month as 'Mês', @year as 'Ano', 
	SUM(sod.OrderQty) as 'Quantidade De Itens Vendidos', 
	AVG(sod.UnitPrice) as 'Preço Unitário Médio do Item', 
	SUM(sod.LineTotal) as 'Valor Total Vendido'
	FROM Production.Product p
	INNER JOIN Production.ProductSubcategory psc
		ON psc.ProductSubcategoryID = p.ProductSubcategoryID
	INNER JOIN Production.ProductCategory pc
		ON pc.ProductCategoryID = psc.ProductCategoryID
	INNER JOIN Sales.SalesOrderDetail sod
		ON sod.ProductID = p.ProductID
	INNER JOIN Sales.SalesOrderHeader soh
		ON soh.SalesOrderID = sod.SalesOrderID
	WHERE MONTH(soh.OrderDate) = @month
	AND YEAR(soh.OrderDate) = @year
	GROUP BY psc.ProductCategoryID, pc.Name;

SELECT * FROM CategorySalesMonth(3, 2014);

/*  4.	Crie uma função de nome CategoryTopIncrease que recebe como parâmetro um numero de mês e um numero de ano e apresenta dados de vendas da categoria de produtos que teve maior aumento 
	de venda na comparação do mesm informado com o mesmo mês do ano anterior. A função deve apresentar as seguintes informações sobre a categoria: 
	Identificador da Categoria (ProductCategoryID), Nome da Categoria (ProductCategory), Mês, Ano, Quantidade Total Vendida (ano anterior), Valor Total Vendido (ano anterior), 
	Quantidade Total Vendida (mês informado), Valor Total Vendido (mês informado), percentual de aumento de vendas (em relação ao valor total vendido).
*/

SELECT TOP 1 [Identificador da Categoria] FROM CategorySalesMonth(2, 2014) ORDER BY [Valor Total Vendido] DESC;

CREATE FUNCTION CategoryTopIncrease (
	@month int,
	@year int
)
RETURNS TABLE
AS
RETURN
SELECT TOP 1 csmatual.[Identificador da Categoria], csmatual.[Nome da Categoria], @month as 'Mês', @year as 'Ano', 
	csmanterior.[Quantidade De Itens Vendidos] as 'Quantidade Total Vendida (ano anterior)', csmanterior.[Valor Total Vendido] as 'Valor Total Vendido (ano anterior)',
	csmatual.[Quantidade De Itens Vendidos] as 'Quantidade Total Vendida (mês informado)', csmatual.[Valor Total Vendido] as 'Valor Total Vendido (mês informado)',
	((csmatual.[Valor Total Vendido] - csmanterior.[Valor Total Vendido]) / csmanterior.[Valor Total Vendido]) * 100 as 'Percentual de aumento de vendas (em relação ao valor total vendido)'
FROM
CategorySalesMonth(@month, @year) csmatual
INNER JOIN 
CategorySalesMonth(@month, @year - 1) csmanterior
ON csmatual.[Identificador da Categoria] = csmanterior.[Identificador da Categoria]
WHERE csmatual.[Valor Total Vendido] > csmanterior.[Valor Total Vendido]
ORDER BY ((csmatual.[Valor Total Vendido] - csmanterior.[Valor Total Vendido]) / csmanterior.[Valor Total Vendido]) ASC;
