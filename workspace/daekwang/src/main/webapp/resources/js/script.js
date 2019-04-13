
//사이드네비 숨기는곳
$(document).ready(function(){
  $(".slideBtn").click(function(){    
    if($("#sidenav").width() == 0){      
        document.getElementById("sidenav").style.width = "250px";
        document.getElementById("wrap").style.paddingLeft = "250px";
        document.getElementById("wrap").style.width = "88%";
        document.getElementById("slidebtn").style.paddingLeft = "250px";
    }else{
        document.getElementById("sidenav").style.width = "0";
        document.getElementById("wrap").style.paddingLeft = "0";
		document.getElementById("wrap").style.width = "100%";
        document.getElementById("slidebtn").style.paddingLeft = "0";
    }
  });
});


//best회원 숨기기
$(document).ready(function(){
	$('.con_bot_div1_div2 > table:not(:first)').hide();
});

$(document).ready(function(){
	$('.con_bot_div1_div1_btn > ul > li > a').click(function(e){
		e.preventDefault();
		$(this).addClass('on');
		$(this).parent().siblings().find('> a').removeClass('on');

		var btn1 = $(this).parent().index();
		if(btn1 == 0){
			$('.con_bot_div1_div2 > table:eq(0)').show();
			$('.con_bot_div1_div2 > table:eq(1)').hide();
		}
		if(btn1 == 1){
			$('.con_bot_div1_div2 > table:eq(1)').show();
			$('.con_bot_div1_div2 > table:eq(0)').hide();
		}
	});
});

$(document).ready(function(){
	$('.con_bot_div2_div1_btn > ul > li > a').click(function(e){
		e.preventDefault();
		$(this).addClass('on');
		$(this).parent().siblings().find('> a').removeClass('on');
	});
});

$(document).ready(function(){
	$('.con_bot_div3_div1_btn > ul > li > a').click(function(e){
		e.preventDefault();
		$(this).addClass('on');
		$(this).parent().siblings().find('> a').removeClass('on');
	});
});

//nav 화살표버튼 및 슬라이드온오프
$(document).ready(function(){
	$('.sidenav > .menulist > li > a').click(function(e){
		e.preventDefault();
		$(this).toggleClass('on');
		
		$(this).parent().find('ul').slideToggle();
		
	});
});

//이름 눌렀을때 나오는 팝업창
$(document).ready(function(){
	$('.head_right > ul > li:eq(1) > a').click(function(e){
		e.preventDefault();
		$(this).parent().find('ul').slideToggle();
	});
	$('.head_right > ul > li:eq(1) > ul').mouseleave(function(e){
		e.preventDefault();
		$(this).parent().find('ul').slideUp();
	});
});



$(document).ready(function(){
	$('.con_pro2_div2_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div2_div2').toggle();
	});

	$('.con_pro2_div3_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div3_div2').toggle();
	});

	$('.con_pro2_div3_1_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div3_1_div2').toggle();
	});


	$('.con_pro2_div4_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div4_div2').toggle();
	});

	$('.con_pro2_div5_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div5_div2').toggle();
	});

	$('.con_pro2_div6_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div6_div2').toggle();
	});

	$('.con_pro2_div7_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div7_div2').toggle();
	});

	$('.con_pro2_div8_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div8_div2').toggle();
	});

	$('.con_pro2_div9_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div9_div2').toggle();
	});

	$('.con_pro2_div10_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div10_div2').toggle();
	});

	$('.con_pro2_div11_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div11_div2').toggle();
	});

	$('.con_pro2_div12_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div12_div2').toggle();
	});

	$('.con_pro2_div13_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div13_div2').toggle();
	});

	$('.con_pro2_div14_div1 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div14_div2').toggle();
	});
});

$(document).ready(function(){
	$('.category1 > li > a').click(function(e){
		e.preventDefault();
		var cate = $(this).parent().index();

		if(cate == 0){
			$('.cate2 > ul:eq(0)').show();
			$('.cate2 > ul:not(:eq(0))').hide();
		}
		if(cate == 1){
			$('.cate2 > ul:eq(1)').show();
			$('.cate2 > ul:not(:eq(1))').hide();
		}
		if(cate == 2){
			$('.cate2 > ul:eq(2)').show();
			$('.cate2 > ul:not(:eq(2))').hide();
		}
		if(cate == 3){
			$('.cate2 > ul:eq(3)').show();
			$('.cate2 > ul:not(:eq(3))').hide();
		}
		if(cate == 4){
			$('.cate2 > ul:eq(4)').show();
			$('.cate2 > ul:not(:eq(4))').hide();
		}
	});

	$('.category2 > li > a').click(function(){
		var cate1 = $(this).parent().index();

		if(cate1 == 0){
			$('.cate3 > ul:eq(0)').show();
			$('.cate3 > ul:not(:eq(0))').hide();
		}
		if(cate1 == 1){
			$('.cate3 > ul:eq(1)').show();
			$('.cate3 > ul:not(:eq(1))').hide();
		}
		if(cate1 == 2){
			$('.cate3 > ul:eq(2)').show();
			$('.cate3 > ul:not(:eq(2))').hide();
		}
		if(cate1 == 3){
			$('.cate3 > ul:eq(3)').show();
			$('.cate3 > ul:not(:eq(3))').hide();
		}
		if(cate1 == 4){
			$('.cate3 > ul:eq(4)').show();
			$('.cate3 > ul:not(:eq(4))').hide();
		}
	});
});

//판매가 YES NO
$(document).ready(function(){
	$('.giganhalin_1 > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$('.selecthalin').show();
			$('.halinprice').show();
			$('.giganhalin2').show();
			$('.halinday').hide();
		}
		if(btn1==1)
		{
			$('.selecthalin').hide();
			$('.halinprice').hide();
			$('.giganhalin2').hide();
			$('.halinday').hide();
		}
	});

	$('.giganhalin_2 > li > a').click(function(e){
		e.preventDefault();
		var btn2 = $(this).parent().index();

		if(btn2==0)
		{
			$('.halinday').show();
		}
		if(btn2==1)
		{
			$('.halinday').hide();
		}
	});
});

//구매혜택 YES NO
$(document).ready(function(){
	$('.pro2_div8_ulbtn_1 > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$('.pro2_div8_halin1').show();		
		}
		if(btn1==1)
		{
			$('.pro2_div8_halin1').hide();
		}
	});

	$('.pro2_div8_ulbtn_2 > li > a').click(function(e){
		e.preventDefault();
		var btn2 = $(this).parent().index();

		if(btn2==0)
		{
			$('.pro2_div8_ulbtn_3').show();
		}
		if(btn2==1)
		{
			$('.pro2_div8_ulbtn_3').hide();
		}
	});

	$('.pro2_div8_halin2 > li > input').click(function(e){

		var btn3 = $(this).parent().index();

		if(btn3==0){
			$('.pro2_div8_halin2_ul').hide();
		}
		if(btn3==1){
			$('.pro2_div8_halin2_ul').show();
		}
	});
});

//상품옵션 YES NO
$(document).ready(function(){
	$('.pro2_div9_ulbtn > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$(this).parents('tr').siblings('.pro2_div9_tr').show();		
		}
		if(btn1==1)
		{
			$(this).parents('tr').siblings().hide();
		}
	});

	$('.pro2_div9_ulbtn1 > li > input').click(function(e){
		var btn2 = $(this).parent().index();

		if(btn2==0)
		{
			$('.pro2_div9_tr1').show();
			$('.pro2_div9_tr2').hide();
		}
		if(btn2==1)
		{
			$('.pro2_div9_tr1').hide();
			$('.pro2_div9_tr2').show();
		}
	});
});

//추가구성상품 YES NO
$(document).ready(function(){
	$('.pro2_div10_ulbtn > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$(this).parents('tr').siblings().show();		
		}
		if(btn1==1)
		{
			$(this).parents('tr').siblings().hide();
		}
	});
});

//배송 YES NO
$(document).ready(function(){
	$('.pro2_div11_ulbtn_1 > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$(this).parents('tr').siblings().show();		
		}
		if(btn1==1)
		{
			$(this).parents('tr').siblings().hide();
		}
	});

	$('.pro2_div11_ul > li > label').click(function(e){
		var btn2 = $(this).parent().index();

		if(btn2==0)
		{
			$('.pro2_div11_ul_ul').hide();		
		}
		if(btn2==1)
		{
			$('.pro2_div11_ul_ul').show();	
		}
	});

	$('.pro2_div11_ulbtn_2 > li > a').click(function(e){
		e.preventDefault();
		var btn3 = $(this).parent().index();

		if(btn3==0)
		{
			$(this).parents('ul').siblings('p').show();	
		}
		if(btn3==1)
		{
			$(this).parents('ul').siblings('p').hide();	
		}
	});

	$('.pro2_div11_ulbtn_3 > li > a').click(function(e){
		e.preventDefault();
		var btn4 = $(this).parent().index();

		if(btn4==0)
		{
			$(this).parents('ul').siblings('p').show();	
		}
		if(btn4==1)
		{
			$(this).parents('ul').siblings('p').hide();	
		}
	});

	$('.pro2_div11_region').click(function(e){
		e.preventDefault();
		$('.con_pro2_div11_div3').slideToggle();
	});

	$('.con_pro2_div11_div3_div3 > p > a').click(function(e){
		e.preventDefault();
		$('.con_pro2_div11_div3').slideUp();
	});

	
});

//상품스펙 YES NO
$(document).ready(function(){
	$('.pro2_div12_ulbtn > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$('.pro2_div12_ul1').show();		
		}
		if(btn1==1)
		{
			$('.pro2_div12_ul1').hide();		
		}
	});
});


//상품속성 YES NO
$(document).ready(function(){
	$('.pro2_div13_ulbtn > li > a').click(function(e){
		e.preventDefault();
		var btn1 = $(this).parent().index();

		if(btn1==0)
		{
			$('.pro2_div13_ul1').show();		
		}
		if(btn1==1)
		{
			$('.pro2_div13_ul1').hide();		
		}
	});
});
