
$(document).ready(function(){	
	function isEmpty(str) {
	    return (!str || 0 === str.length);
	}

	var clues = { 
		container: $('#clueTableContent'),

		add: function(answer,clue){
			this.container.append(this.template( answer,clue));
		},
		
		get: function(){
			return this.container.find("tr");
		},
		
		replaceWithInput: function(row){
			if(row.find('input').length > 0){
				return;
			}
			
			var values = row.find('td');		
					
			var answer = $(values[1]);
			var clue = $(values[2]);
			
			var answerText = answer.text();
			var clueText =  clue.text();
			
			answer.replaceWith(this.inputTemplate(answerText));
			clue.replaceWith(this.inputTemplate(clueText));		
					
			row.append(this.buttonTemplate(row));
		},
		
		replaceWithText: function(row){
			var values = $(row).find('td');		
			
			var answer = $(values[1]);
			var clue = $(values[2]);
			var btn = $(values[3]);
						
			var answerText = answer.find('input').val();
			var clueText =  clue.find('input').val();
			
			answer.replaceWith($('<td>').html(answerText));
			clue.replaceWith($('<td>').html(clueText));			

			btn.remove();
		},
		closeEditing: function(){
			var actives = this.container.find('.edit-row-btn');
			
			actives.each(function(){
				this.click();
			});
		},
		template: function(answerText, clueText){
			var id = $('<td>');
			var answer = $('<td>').html(answerText);
			var clue = $('<td>').html(clueText);
			
			var tr = $('<tr>');

			tr.append(id).append(answer).append(clue);
			
			return tr;
		},
		
		inputTemplate: function(value){
			return  $('<td>').append($("<input>").attr('type', 'text').attr('value', value).addClass('form-control'));	
		},
		
		buttonTemplate: function(row){
			var that = this;
			
			var btn = $('<button>').attr('type','button').addClass('edit-row-btn btn btn-success').html($('<span>').addClass("glyphicon glyphicon-pencil"));
			
			btn.on('click', function(e){
				e.stopPropagation();
				that.replaceWithText(row);
			});
			
			return $('<td>').append(btn);
		}
	};

	var formControl = {
		form: $('form'),
		
		add: function(input){
			this.form.append(input);
		},
		
		addClues: function(clues){
			var that = this;
						
			clues.each(function(index) {
			   var self = $(this);
			   var values = self.find('td');
			   
				var idText = $(values[0]).text();
			   	var answerText = $(values[1]).text();
				var clueText =  $(values[2]).text();
							
				var idName = "clues["+index+"].id";
				var answerName = "clues["+index+"].answer"; 
				var clueName = "clues["+index+"].clue";				
				
				that.add(that.template(idName, idText));
				that.add(that.template(answerName, answerText));
				that.add(that.template(clueName, clueText));			
			});			
		},		
		
		template: function(name, value){
			return $("<input>").attr('type', 'hidden').attr('value', value).attr('name', name);		
		}		
	};
		
	var	addBtn = $('#btnAdd');
	
	var answerField = $("#clueAnswer");
	
	var clueField = $("#clueClue");
	
	addBtn.on('click', function(){		
		var answer = answerField.val();
		var clue = clueField.val();
		
		if(isEmpty(answer) || isEmpty(clue)){
			//TODO send a msg to the user
			console.log("cant add empty clues")
			return;
		}
		
		clues.add(answer, clue);
		answerField.val("");
		clueField.val("");
	});
	
	clues.container.on('click', 'tr', function(){
		var row = $(this);		
		clues.replaceWithInput(row);
	});
	
	formControl.form.on('submit', function(e){
		var cluesArray = clues.get();

		if(cluesArray.length == 0){
			//TODO send a msg to the user
			console.log("cant save without clues");
			e.preventDefault();
			return false;
		}

		clues.closeEditing();
		formControl.addClues(cluesArray);		
	});
	
});