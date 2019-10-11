$(document).ready(function (){
	$('.bxslider_banner').bxSlider({
			'pager' : true,
			auto: true,
			pause: 5000,
			maxSlides: 1,
			slideWidth: 970,
			slideMargin: 30,
			controls: false
	});
	
	$('.form-cad').validate();
	$(".form-cad label").inFieldLabels({ fadeOpacity:0 });
	
	var doClick = function() {
		'use strict';
		var event = document.createEvent('MouseEvents');
		event.initMouseEvent('mousedown', true, true, window);
		return event;
	};
	
	$(".btselect").click(function(){
		var alvo = $(this).attr('href');
		//$(alvo).show();
		'use strict';
		$(alvo).focus().get(0).dispatchEvent(doClick());
		return false;
	});
	
	$( "#calendario" ).datepicker({
		dateFormat: 'dd/mm/yy',
	    dayNames: ['Domingo','Segunda','TerÃ§a','Quarta','Quinta','Sexta','SÃ¡bado'],
	    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','SÃ¡b','Dom'],
	    monthNames: ['Janeiro','Fevereiro','MarÃ§o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
	    nextText: 'PrÃ³ximo',
	    prevText: 'Anterior'
	});
});