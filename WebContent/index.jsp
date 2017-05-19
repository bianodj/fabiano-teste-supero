<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Task Management</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
		<script type="text/javascript" src="js/task.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    	<link rel="stylesheet" href="css/style.css">
	</head>
	<!-- 0800-081-3513 -->
	<body ng-app="appTask" ng-controller="taskController">
		<h3>Cadastro de tarefas</h3>
		<form ng-submit="processTaskDetails()">
			<div class="table-responsive">
				<table class="table table-bordered" style="width: 600px">
					<tr>
						<td>Titulo</td>
						<td>
							<input type="text" id="titulo" ng-model="taskForm.titulo" size="30" />
						</td>
					</tr>
					<tr>
						<td>Situação</td>
						<td>
							<input type="text" id="status" ng-model="taskForm.status" size="30" />
							<!-- 
							<select ng-model="taskForm.status" ng-options="option.name for option in statusOptions"></select>
							-->							
						</td>
					</tr>
					<tr>
						<td>Descrição</td>
						<td>
							<input type="text" id="descricao" ng-model="taskForm.descricao" size="30" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="btn btn-primary btn-sm" ng-click="processTask()" value="Salvar" />
						</td>
					</tr>
				</table>
			</div>
		</form>
		<h3>Tabela de tarefas</h3>
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 800px">
				<tr>
					<th>Título</th>
					<th>Situação</th>
					<th>Descrição</th>
					<th style="width: 15%">Operações</th>
				</tr>	
				<tr ng-repeat="task in tasks">
					<td>{{ task.titulo }}</td>
					<td>{{ task.status }}</td>
					<td>{{ task.descricao }}</td>
					<td>
						<a ng-click="editTask(task)" class="btn btn-primary btn-sm">Edit</a>
						<span> | </span>
						<a ng-click="deleteTask(task)" class="btn btn-danger btn-sm">Delete</a>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>