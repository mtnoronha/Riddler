
$(document).ready(function(){	
	function isEmpty(str) {
	    return (!str || 0 === str.length);
	}

	var clues = { 
		container: $('#clueTableContent'),

		add: function(answer,clue){
			this.container.append(this.template(answer,clue));
		},
		get: function(){
			return this.container.find("tr");
		},
		template: function(answerText, clueText){
			var answer = $('<td>').html(answerText);
			var clue = $('<td>').html(clueText);
			
			var tr = $('<tr>');

			tr.append(answer).append(clue);
			
			return tr;
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
			   
				var answerText = $(values[0]).text();
				var clueText =  $(values[1]).text();
							
				var answerName = "clues["+index+"].answer"; 
				var clueName = "clues["+index+"].clue";				
				
				that.add(that.template(answerName, answerText));
				that.add(that.template(clueName, clueText));			
			});
			
		},
		template: function(name, value){
			return $("<input>").attr('type', 'hidden').attr('value', value).attr('name', name);		
		}
	}
	
	
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
	
	formControl.form.on('submit', function(e){
		var cluesArray = clues.get();

		if(cluesArray.length == 0){
			//TODO send a msg to the user
			console.log("cant save without clues");
			e.preventDefault();
			return false;
		}


		formControl.addClues(cluesArray);

		//TODO remove this, test only
		e.preventDefault();
		return false;
		
		
	});
	
});