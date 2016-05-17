var app = angular.module('itemModule',[]);

app.controller('itemControl',function($scope,$http){
	
	var url = 'http://localhost:8080/TrabalhoPDS2/rs/item';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (itensRetorno) {
			$scope.itens = itensRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
    $scope.salvar = function() {
		if ($scope.item.codigo == '') {
			$http.post(url, $scope.item).success(function(item) {
				$scope.itens.push($scope.item);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.item).success(function(item) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.item.codItem == '') {
			alert('Selecione um item');
		} else {
			urlExcluir = url + '/' + $scope.item.codItem;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
		$scope.itens.splice($scope.itens.indexOf($scope.item), 1);
		$scope.novo();
	}
	
	$scope.seleciona = function(itemTabela) {
		$scope.item = itemTabela;
	}
	
	$scope.novo = function(){
		$scope.item == '';
	}
	
	$scope.pesquisar();

});