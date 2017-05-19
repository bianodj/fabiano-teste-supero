var app = angular.module('appTask', []);

app.controller('taskController', function($scope, $http) {
	$scope.tasks = []
	$scope.taskForm = {
		id : 0,
		titulo : "",
		status : "",
		descricao : ""
	};
	$scope.statusOptions = [
	                        	{"name":"Ativo","value":"A"},
	                        	{"name":"Inativo","value":"I"},
	                        	{"name":"Bloqueado","value":"B"},
	                        	{"name":"Removido","value":"R"},
	                        	{"name":"Concluído","value":"C"}
	                       ];
	//$scope.statusModel = $scope.orderOptions[1];
	getTaskDetails();

	function getTaskDetails() {
		$http({
			method : "GET",
			url : 'tasks'
		}).then(function successCallback(response) {
			$scope.tasks = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	$scope.processTask = function() {
        var method = "";
        var url = "";
        if ($scope.taskForm.id == 0) {
 			method = "POST";
        } else {
			method = "PUT";
        }
		$http({
			method : method,
			url : 'task',
			data : angular.toJson($scope.taskForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(getTaskDetails(), clearForm()).success(function(data) {
			$scope.tasks = data
		});
	}
	
	$scope.editTask = function(task) {
		$scope.taskForm.id = task.id;
		$scope.taskForm.titulo = task.titulo;
		$scope.taskForm.status = task.status;
		$scope.taskForm.descricao = task.descricao;
		disableName();
	}
	
	$scope.deleteTask = function(task) {
		$http({
			method : 'DELETE',
			url : 'delete',
			data : angular.toJson(task),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(getTaskDetails());
	}

	function clearForm() {
		$scope.taskForm.id = 0;
		$scope.taskForm.titulo = "";
		$scope.taskForm.status = "";
		$scope.taskForm.descricao = "";
		document.getElementById("descricao").disabled = false;
	}

	function disableName() {
		document.getElementById("descricao").disabled = true;
	}
	
});
