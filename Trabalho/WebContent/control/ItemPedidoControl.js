var app = angular.module('ItemPedidoModule', []);

app.controller('ItemPedidoControl', function($scope, $http) {
	
	var urlItem = 'http://localhost:8080/TrabalhoPDS2/rs/item';
	
	var urlPedido = 'http://localhost:8080/TrabalhoPDS2/rs/pedido';

	var url = 'http://localhost:8080/TrabalhoPDS2/rs/ItemPedido';
	
	$scope.pesquisarItem = function() {
		$http.get(urlItem).success(function (itens) {
			$scope.itens = itens;
		}).error(function (erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarPedido = function() {
		$http.get(urlPedido).success(function (pedidos) {
			$scope.pedidos = pedidos;
		}).error(function (erro) {
			alert(erro);
		});
	}

	$scope.pesquisar = function() {
		$http.get(url).success(function(ItemPedidosRetorno) {
			$scope.ItemPedidos = ItemPedidosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});
	}

	$scope.salvar = function() {
		if ($scope.ItemPedido.codItemPedido == '') {
			$http.post(url, $scope.ItemPedido).success(function(ItemPedido) {
				$scope.ItemPedidos.push($scope.ItemPedido);
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		} else {
			$http.put(url, $scope.ItemPedido).success(function(ItemPedido) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}

	
	$scope.excluir = function() {
		if ($scope.ItemPedido.codItemPedido == '') {
			alert('Selecione um ItemPedido');
		} else {
			urlExcluir = url + '/' + $scope.ItemPedido.codItemPedido;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		}
		$scope.ItemPedidos.splice($scope.ItemPedidos.indexOf($scope.ItemPedido), 1);
		$scope.novo();
	}
	
	$scope.novo = function() {
		$scope.ItemPedido = "";
	}

	$scope.seleciona = function(ItemPedidoTabela) {
		$scope.ItemPedido = ItemPedidoTabela;
	}
	
	$scope.selecionaItem = function(item) {
		$scope.item = item;
	}
	
	$scope.pesquisar();
	$scope.pesquisarPedido();
	$scope.pesquisarItem();

});