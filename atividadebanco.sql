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
			SUM(Sales.SalesOrderDetail.UnitPrice) as Valor_Total_Vendido
            FROM Sales.SalesOrderDetail INNER JOIN Sales.SalesOrderHeader ON Sales.SalesOrderDetail.SalesOrderID = Sales.SalesOrderHeader.SalesOrderID
            WHERE YEAR(Sales.SalesOrderHeader.OrderDate) = @ano
            AND MONTH(Sales.SalesOrderHeader.OrderDate) = @mes
            group by ProductID)

select * from SalesMonth(3,2014)

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
