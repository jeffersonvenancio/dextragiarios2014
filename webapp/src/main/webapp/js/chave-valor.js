Dextra = (function($, handle) {
	var Dextra = window.Dextra || {};
	
	Dextra.ChaveValor = {
			
			"init" : function() {
				var source = $("#index-template").html();
				var template = Handlebars.compile(source);

				$.getJSON("/api/chave-valor/vo", {}, function(vo) {

					$("#main-chave-valor").html(template(vo.value));
					Dextra.ChaveValor.atualizaTabela(vo.value.valores);
					
					$("#submeter").click(function() {
						var chave = $("#chave").val();
						var valor = $("#valor").val();
						
						$.post("/api/chave-valor", {
							"chave" : chave,
							"valor" : valor
						}, function(chaveValor) {
							Dextra.ChaveValor.carregaTabela();
						});
					});
				});  
			},
			
			"carregaTabela" : function() {
				$.getJSON("/api/chave-valor", {}, function(listar) {
					Dextra.ChaveValor.atualizaTabela(listar.chaveValor);
				});
			},
			
			"atualizaTabela" : function(valores) {
				var source = $("#template-tabela-chave-valor").html();
				var template = Handlebars.compile(source);
				$("#tabela-valores").html(template({"valores" : valores}));
			}
			
	};

	return Dextra;
})(jQuery, Handlebars);