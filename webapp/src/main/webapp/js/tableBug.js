(function ($){
	bindButtons = function(){
		var trs = $('table.grid tbody tr');
		for(var i = 0; i < trs.length ; i++){
			var tr = $(trs[i]);
			var id = tr.find('.id').text();
			serviceTable().find(parseInt(id)).done(function(desc){
				tr.find('.description').text(desc.desc);
			});
		}
	}
})(jQuery);